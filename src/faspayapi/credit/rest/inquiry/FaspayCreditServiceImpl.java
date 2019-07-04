/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faspayapi.credit.rest.inquiry;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import faspayapi.credit.FaspayConfigCredit;
import faspayapi.credit.FaspayConfigCreditDev;
import faspayapi.credit.FaspayUserCredit;
import faspayapi.credit.TetsUser;
import faspayapi.credit.TetsUser2;
import faspayapi.credit.entity.inquiry.InquiryRequestCredit;
import faspayapi.credit.entity.inquiry.InquiryRequestCreditWrapper;
import faspayapi.credit.entity.inquiry.InquiryResponseCredit;
import faspayapi.credit.entity.void_transaction.VoidRequestCredit;
import faspayapi.credit.entity.void_transaction.VoidResponseCredit;
import faspayapi.credit.rest.ApiServiceImpl;
import faspayapi.debit.entity.err.UnregisteredError;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.Call;
import okhttp3.FormBody;
import org.json.JSONObject;

/**
 *
 * @author hilmananwarsah
 */
public class FaspayCreditServiceImpl extends ApiServiceImpl<Object> implements FaspayCreditService {
    
    public FaspayCreditServiceImpl(FaspayConfigCredit mFaspayConfig) {
        super(mFaspayConfig);
    }
    
    @Override
    public void inquiry(InquiryRequestCredit credit, InquiryPaymentCallback callback) {
        try {
            JSONObject p = new JSONObject(new ObjectMapper().writeValueAsString(credit));
            Iterator<String> keys = p.keys();
            Map<String, String> data = new HashMap();
            while (keys.hasNext()) {
                String next = keys.next();
                
                try {
                    data.put(next.toUpperCase(), URLEncoder.encode(data.get(next), "utf-8"));
                } catch (Exception e) {
                }
                
            }
            
            sendRequestHttpPlain(getFaspayConfig().getMerchantInquiryUrl(), data, new ApiServiceCallbackPlain() {
                @Override
                public void onFailure(Call call, IOException ioe) {
                    callback.onErrorGetResponseInquiryPaymentCredit(ioe);
                }
                
                @Override
                public void onResponse(String t) {
                    JSONObject data = new JSONObject();
                    String[] x = t.split(";");
                    for (String string : x) {
                        
                        String[] y = string.split("=");
                        if (y.length == 2) {
                            data.put(y[0], y[1]);
                        }
                        
                    }
                    try {
                        InquiryResponseCredit clas = new ObjectMapper().readValue(data.toString(), InquiryResponseCredit.class);
                        callback.onGetResponseInquiryPaymentCredit(clas);
                    } catch (IOException ex) {
                        Logger.getLogger(FaspayCreditServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                        callback.onErrorGetResponseInquiryPaymentCredit(ex);
                    }
                    
                }
                
            });
        } catch (JsonProcessingException ex) {
            Logger.getLogger(FaspayCreditServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            callback.onErrorGetResponseInquiryPaymentCredit(ex);
        }
        
    }
    
    public static void main(String[] args) {
        FaspayConfigCredit conf = new FaspayConfigCreditDev();
        FaspayUserCredit credit = new TetsUser2();
        
    }
    
    @Override
    public void voidTransaction(VoidRequestCredit requestCredit, VoidPaymentCallback callback) {
        
        JSONObject o;
        
        try {
            o = new JSONObject(new ObjectMapper().writeValueAsString(requestCredit));
            Iterator<String> e = o.keys();
            Map<String, String> data = new HashMap<>();
            while (e.hasNext()) {
                String next = e.next();
                String val;
                if (!o.isNull(next)) {
                    val = o.getString(next);
                } else {
                    val = "";
                }
                data.put(next.toUpperCase(), val);
                //           System.out.println(next+" "+val);
            }
            sendRequestHttpPlain(requestCredit.getUrl(), data, new ApiServiceCallbackPlain() {
                @Override
                public void onFailure(Call call, IOException ioe) {
                    System.out.println("ERR");
                    callback.onErrorVoidPaymentCallback(ioe);
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
                
                @Override
                public void onResponse(String t) {
//                    try {
//                        System.out.println("ok");
//                        String[] d = t.split(";");
//                        JSONObject data = new JSONObject();
//                        for (String string : d) {
//                            String[] kv = string.split("=");
//                            if (kv.length == 0) {
//                                data.put(kv[0], "");
//                            } else {
//                                data.put(kv[0], kv[1]);
//                            }
//                            
//                        }
//                        VoidResponseCredit voidResponseCredit = new ObjectMapper().readValue(data.toString(), VoidResponseCredit.class);
//                        callback.onVoidSuucess(voidResponseCredit);
////                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//                    } catch (IOException ex) {
//                        callback.onErrorVoidPaymentCallback(ex);
//                        Logger.getLogger(FaspayCreditServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
//                    }
                }
            });
        } catch (JsonProcessingException ex) {
            Logger.getLogger(FaspayCreditServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
