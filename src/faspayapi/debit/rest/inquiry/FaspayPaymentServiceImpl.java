/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faspayapi.debit.rest.inquiry;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import faspayapi.debit.FaspayConfigDebit;
import faspayapi.debit.entity.FaspayCancelPaymentRequest;
import faspayapi.debit.entity.FaspayCancelPaymentResponse;
import faspayapi.debit.entity.FaspayPaymentChannelResponse;
import faspayapi.debit.entity.FaspayPaymentRequest;
import faspayapi.debit.entity.FaspayPaymentResponse;
import faspayapi.debit.entity.FaspayPaymentStatusRequest;
import faspayapi.debit.entity.FaspayPaymentStatusResponse;
import faspayapi.rest.ApiServiceImpl;
import faspayapi.rest.UnregisteredErrorCallback;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.Call;
import org.json.JSONObject;

/**
 *
 * @author hilmananwarsah
 */
public class FaspayPaymentServiceImpl extends ApiServiceImpl<FaspayPaymentResponse> implements FaspayPaymentService {

    public FaspayPaymentServiceImpl(FaspayConfigDebit mFaspayConfig) {
        super(mFaspayConfig);
    }

    @Override
    public void createBilling(FaspayPaymentRequest mFaspayPaymentRequest, FaspayCreateBillingServiceCallback mCallback) {
        this.mCallback = mCallback;
        JSONObject data;
        try {
            data = new JSONObject(new ObjectMapper().writeValueAsString(mFaspayPaymentRequest));
        } catch (JsonProcessingException ex) {
            Logger.getLogger(FaspayPaymentServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            mCallback.onErrorGetPaymentResponse(ex);
            return;
        }

        sendRequestHttpPost(getFaspayConfig().getCreateBillingUrl(), data, new ApiServiceCallbackPost() {
            @Override
            public void onFailure(Call call, IOException ioe) {
                if (mCallback != null) {
                    mCallback.onErrorGetPaymentResponse(ioe);
                }

            }

            @Override
            public void onResponse(JSONObject t) {
                try {
                    FaspayPaymentResponse response = new ObjectMapper().readValue(t.toString(), FaspayPaymentResponse.class);
                    if (mCallback != null) {
                        mCallback.onGetPaymentResponse(response);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(FaspayInquiryPCServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                    if (mCallback != null) {
                        mCallback.onErrorGetPaymentResponse(ex);
                    }
                }
            }
        });
    }

    @Override
    public void inqueryPaymentStatus(FaspayPaymentStatusRequest mRequest, FaspayInquiryPaymentStatusCallback mCallback) {
        this.mCallback = mCallback;
        JSONObject data;
        try {
            data = new JSONObject(new ObjectMapper().writeValueAsString(mRequest));
        } catch (JsonProcessingException ex) {
            Logger.getLogger(FaspayPaymentServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            mCallback.onErrorGetInquiryPaymentStatusResponse(ex);
            return;
        }

        sendRequestHttpPost(getFaspayConfig().getInqueryPaymentStatusUrl(), data, new ApiServiceCallbackPost() {
            @Override
            public void onFailure(Call call, IOException ioe) {
                if (mCallback != null) {
                    mCallback.onErrorGetInquiryPaymentStatusResponse(ioe);
                }

            }

            @Override
            public void onResponse(JSONObject t) {
                try {
                    FaspayPaymentStatusResponse response = new ObjectMapper().readValue(t.toString(), FaspayPaymentStatusResponse.class);
                    if (mCallback != null) {
                        mCallback.onGetInquiryPaymentStatusResponse(response);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(FaspayInquiryPCServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                    if (mCallback != null) {
                        mCallback.onErrorGetInquiryPaymentStatusResponse(ex);
                    }
                }
            }
        });
    }
    UnregisteredErrorCallback mCallback;

    @Override
    public void cancelTransaction(FaspayCancelPaymentRequest mRequest, FaspayCancelPaymentCallback mCallback) {
        this.mCallback = mCallback;
        JSONObject data;
        try {
            data = new JSONObject(new ObjectMapper().writeValueAsString(mRequest));
        } catch (JsonProcessingException ex) {
            Logger.getLogger(FaspayPaymentServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            mCallback.onErrorRequstCancelPayment(ex);
            return;
        }

        sendRequestHttpPost(getFaspayConfig().getCancelTransactionUrl(), data, new ApiServiceCallbackPost() {
            @Override
            public void onFailure(Call call, IOException ioe) {
                if (mCallback != null) {
                    mCallback.onErrorRequstCancelPayment(ioe);
                }

            }

            @Override
            public void onResponse(JSONObject t) {
                try {
                    FaspayCancelPaymentResponse response = new ObjectMapper().readValue(t.toString(), FaspayCancelPaymentResponse.class);
                    if (mCallback != null) {
                        mCallback.onCancelPaymentSuccess(response);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(FaspayInquiryPCServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                    if (mCallback != null) {
                        mCallback.onErrorRequstCancelPayment(ex);
                    }
                }
            }
        });
    }

    @Override
    public UnregisteredErrorCallback getHandler() {
        return mCallback;
    }

}
