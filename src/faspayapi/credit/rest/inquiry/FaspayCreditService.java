/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faspayapi.credit.rest.inquiry;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import faspayapi.credit.entity.inquiry.InquiryRequestCredit;
import faspayapi.credit.entity.inquiry.InquiryResponseCredit;
import faspayapi.credit.entity.payment.FaspayPaymentCreditDev;
import faspayapi.credit.entity.void_transaction.VoidRequestCredit;
import faspayapi.credit.entity.void_transaction.VoidResponseCredit;

import faspayapi.debit.FaspayConfigDebit;
import faspayapi.debit.FaspayConfigDebitDev;
import faspayapi.debit.entity.FaspayCancelPaymentResponse;
import faspayapi.debit.entity.err.UnregisteredError;
import faspayapi.debit.rest.inquiry.FaspayPaymentService;
import faspayapi.rest.ApiServiceImpl;
import faspayapi.rest.UnregisteredErrorCallback;
import faspayapi.test.TestFaspayUser;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.Call;
import org.json.JSONObject;

/**
 *
 * @author hilmananwarsah
 */
public interface FaspayCreditService {
    void inquiry(InquiryRequestCredit credit,InquiryPaymentCallback callback);
    void voidTransaction(VoidRequestCredit requestCredit,VoidPaymentCallback callback);
    public interface InquiryPaymentCallback {
        
        void onErrorGetResponseInquiryPaymentCredit(Exception E);

        public void onGetResponseInquiryPaymentCredit(InquiryResponseCredit clas);
    }
    
    public interface VoidPaymentCallback {
        
        void onErrorVoidPaymentCallback(Exception E);

        public void onVoidSuucess(VoidResponseCredit responseCredit);
    }
    
}
