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
import faspayapi.credit.rest.ApiServiceImpl;
import faspayapi.debit.entity.err.UnregisteredError;
import java.io.IOException;
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
public class FaspayCreditServiceImpl extends ApiServiceImpl<Object> implements FaspayCreditService{

    public FaspayCreditServiceImpl(FaspayConfigCredit mFaspayConfig) {
        super(mFaspayConfig);
    }

    @Override
    public void inquiry(InquiryRequestCredit credit,InquiryPaymentCallback callback) {
        try {
            JSONObject p = new JSONObject(new ObjectMapper().writeValueAsString(credit));
            Iterator<String> keys = p.keys();
            Map<String,String> data = new HashMap();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                data.put(next.toUpperCase(), p.getString(next));    
                } catch (Exception e) {
                }
                
            }
            
            sendRequestHttpPlain(getFaspayConfig().getMerchantInquiryUrl(), data, new ApiServiceCallbackPlain() {
                @Override
                public void onFailure(Call call, IOException ioe) {
                    
                }

                @Override
                public void onResponse(String t) {
                    JSONObject data = new JSONObject();
                    String[] x = t.split(";");
                    for (String string : x) {
                        
                        String[] y = string.split("=");
                        if(y.length == 2){
                            data.put(y[0],y[1]);
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
        new FaspayCreditServiceImpl(conf).inquiry(new InquiryRequestCreditWrapper(credit, "DEA32491-4545-4DA7-8ED5-AB5ECAF6C8AD", "2ccb26d48b6c428ba8ba69cdb5558197", 100000),new InquiryPaymentCallback() {
            

            @Override
            public void onErrorGetResponseInquiryPaymentCredit(Exception E) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            
            @Override
            public void onGetResponseInquiryPaymentCredit(InquiryResponseCredit clas) {
                System.out.println(clas.getTXNSTATUS());
            }
        });
    }
 
    
}
