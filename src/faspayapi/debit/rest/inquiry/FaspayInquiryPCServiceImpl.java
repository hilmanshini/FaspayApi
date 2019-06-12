/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faspayapi.debit.rest.inquiry;

import com.fasterxml.jackson.databind.ObjectMapper;
import faspayapi.debit.FaspayConfigDebit;
import faspayapi.debit.FaspayConfigDebitDev;
import faspayapi.test.TestFaspayUser;
import faspayapi.debit.entity.FaspayPaymentChannel;
import faspayapi.debit.entity.FaspayPaymentChannelResponse;
import faspayapi.debit.entity.FaspayPaymentRequest;
import faspayapi.debit.entity.FaspayPaymentResponse;
import faspayapi.debit.entity.err.UnregisteredError;
import faspayapi.rest.ApiServiceImpl;
import faspayapi.rest.UnregisteredErrorCallback;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.Call;
import org.json.JSONObject;

/**
 *
 * @author hilmananwarsah
 */
public class FaspayInquiryPCServiceImpl extends ApiServiceImpl implements FaspayInquiryPCService {

    public FaspayInquiryPCServiceImpl(FaspayConfigDebit mFaspayConfig) {
        super(mFaspayConfig);
    }
    UnregisteredErrorCallback mCallback;

    @Override
    public void inquiryPaymentChannel(FaspayInquiryServiceCallback mCallback) {
        this.mCallback = mCallback;
        JSONObject request = new JSONObject();
        request.put("request", "");
        request.put("merchant_id", getFaspayConfig().getFaspayUser().getMerchantId());
        request.put("merchant", getFaspayConfig().getFaspayUser().getMerchantName());
        request.put("signature", getFaspayConfig().getFaspayUser().calculateSignature());
        sendRequestHttpPost(getFaspayConfig().getInquiryPaymentChannelUrl(), request, new ApiServiceCallbackPost() {
            @Override
            public void onFailure(Call call, IOException ioe) {
                if (mCallback != null) {
                    mCallback.onErrorGetPaymentChannel(ioe);
                }

            }

            @Override
            public void onResponse(JSONObject t) {
                
                
                try {
                    FaspayPaymentChannelResponse response = new ObjectMapper().readValue(t.toString(), FaspayPaymentChannelResponse.class);
                    
                    if (mCallback != null) {
                        mCallback.onGetPaymentChannel(response.getPayment_channel());
                    } else {
                        mCallback.onGetPaymentChannel(new ArrayList<>());
                    }
                } catch (IOException ex) {
                    Logger.getLogger(FaspayInquiryPCServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                    if (mCallback != null) {
                        mCallback.onErrorGetPaymentChannel(ex);
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        TestFaspayUser mTestFaspayUser = new TestFaspayUser();
        FaspayConfigDebit mFaspayConfig = new FaspayConfigDebitDev(mTestFaspayUser);
        
        new FaspayInquiryPCServiceImpl(mFaspayConfig).inquiryPaymentChannel(new FaspayInquiryServiceCallback() {
            @Override
            public void onGetPaymentChannel(List<FaspayPaymentChannel> channel) {
                for (FaspayPaymentChannel faspayPaymentChannel : channel) {
                    System.out.println(faspayPaymentChannel.getPg_code()+" "+faspayPaymentChannel.getPg_name());
                    
                }
            }

            @Override
            public void onErrorGetPaymentChannel(Exception e) {
                e.printStackTrace();
            }

            @Override
            public void onUserNotRegistered(UnregisteredError mUnregisteredError) {
                
            }
        });
    }

    @Override
    public UnregisteredErrorCallback getHandler() {
        return mCallback;
    }

}
