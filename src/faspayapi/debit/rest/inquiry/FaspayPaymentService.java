/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faspayapi.debit.rest.inquiry;

import faspayapi.debit.entity.FaspayCancelPaymentRequest;
import faspayapi.debit.entity.FaspayCancelPaymentResponse;
import faspayapi.debit.entity.FaspayPaymentRequest;
import faspayapi.debit.entity.FaspayPaymentResponse;
import faspayapi.debit.entity.FaspayPaymentStatusRequest;
import faspayapi.debit.entity.FaspayPaymentStatusResponse;
import faspayapi.rest.UnregisteredErrorCallback;
import java.util.List;

/**
 *
 * @author hilmananwarsah
 */
public interface FaspayPaymentService {

    public void createBilling(FaspayPaymentRequest mFaspayPaymentRequest, FaspayCreateBillingServiceCallback mCallback);
    public void inqueryPaymentStatus(FaspayPaymentStatusRequest mRequest,FaspayInquiryPaymentStatusCallback mCallback);
    public void cancelTransaction(FaspayCancelPaymentRequest mFaspayCancelPaymentRequest,FaspayCancelPaymentCallback mCallback);
    public interface FaspayCreateBillingServiceCallback extends  UnregisteredErrorCallback {

        public void onGetPaymentResponse(FaspayPaymentResponse channel);

        void onErrorGetPaymentResponse(Exception e);
    }
    
    public interface FaspayInquiryPaymentStatusCallback extends  UnregisteredErrorCallback{

        public void onGetInquiryPaymentStatusResponse(FaspayPaymentStatusResponse channel);

        void onErrorGetInquiryPaymentStatusResponse(Exception e);
    }
    
    public interface FaspayCancelPaymentCallback extends  UnregisteredErrorCallback{

        public void onCancelPaymentSuccess(FaspayCancelPaymentResponse channel);

        void onErrorRequstCancelPayment(Exception e);
    }
}
