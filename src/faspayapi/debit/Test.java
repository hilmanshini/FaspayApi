/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faspayapi.debit;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import faspayapi.debit.entity.FaspayCancelPaymentResponse;
import faspayapi.debit.entity.FaspayPayment;
import faspayapi.debit.entity.FaspayPaymentChannel;
import faspayapi.debit.entity.FaspayPaymentRequest;
import faspayapi.debit.entity.FaspayPaymentResponse;
import faspayapi.debit.entity.FaspayPaymentStatusRequestWrapper;
import faspayapi.debit.entity.FaspayPaymentStatusResponse;
import faspayapi.debit.entity.cancel.FaspayCancelPaymentRequestWrapper;
import faspayapi.debit.entity.err.UnregisteredError;
import faspayapi.debit.entity.request_bill.FaspayPaymentRequestBillData;
import faspayapi.debit.entity.request_bill.FaspayPaymentRequestShippingData;
import faspayapi.debit.entity.request_bill.FaspayPaymentRequestUserData;
import faspayapi.debit.entity.request_bill.FaspayPaymentRequestWrapper;
import faspayapi.debit.rest.inquiry.FaspayInquiryPCService;
import faspayapi.debit.rest.inquiry.FaspayInquiryPCServiceImpl;
import faspayapi.debit.rest.inquiry.FaspayPaymentService;
import faspayapi.debit.rest.inquiry.FaspayPaymentServiceImpl;
import faspayapi.test.TestFaspayUser;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hilmananwarsah
 */
public class Test {

    public static void main(String[] args) {
        TestFaspayUser mTestFaspayUser = new TestFaspayUser();
        FaspayConfigDebit mFaspayConfig = new FaspayConfigDebitDev(mTestFaspayUser);
        new FaspayInquiryPCServiceImpl(mFaspayConfig).inquiryPaymentChannel(new FaspayInquiryPCService.FaspayInquiryServiceCallback() {
            @Override
            public void onGetPaymentChannel(List<FaspayPaymentChannel> channel) {
                for (FaspayPaymentChannel faspayPaymentChannel : channel) {
                    System.out.println(faspayPaymentChannel.getPg_code() + " " + faspayPaymentChannel.getPg_name());

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
        FaspayPaymentChannel mFaspayPaymentChannel = new FaspayPaymentChannel();
        mFaspayPaymentChannel.setPg_code("402");
        mFaspayPaymentChannel.setPg_name("ALFA");
        List<FaspayPayment> item = new ArrayList<>();
        item.add(new FaspayPayment("444", 1, 100000, FaspayPayment.PAYMENT_PLAN_FULL_SETTLEMENT, mFaspayConfig.getFaspayUser().getMerchantId(), FaspayPayment.TENOR_FULL));
        FaspayPaymentRequestBillData billing = new FaspayPaymentRequestBillData("123123", "x", 10, "10000", item);
        FaspayPaymentRequestUserData mFaspayPaymentRequestUserData = new FaspayPaymentRequestUserData("087123123123", "hil@hil.com", String.valueOf(FaspayPaymentRequestWrapper.TERMINAL_MOBILE_APP_ANDROID), "123123", "hahahaha");
        FaspayPaymentRequestShippingData mFaspayPaymentRequestShippingData = new FaspayPaymentRequestShippingData();
        FaspayPaymentRequestWrapper mFaspayPaymentRequestWrapper = new FaspayPaymentRequestWrapper(mFaspayConfig, billing, mFaspayPaymentChannel, mFaspayPaymentRequestUserData, mFaspayPaymentRequestShippingData);
        FaspayPaymentService mFaspayPaymentService = new FaspayPaymentServiceImpl(mFaspayConfig);
        mFaspayPaymentService.createBilling(mFaspayPaymentRequestWrapper, new FaspayPaymentService.FaspayCreateBillingServiceCallback() {
            @Override
            public void onGetPaymentResponse(FaspayPaymentResponse channel) {

            }

            @Override
            public void onErrorGetPaymentResponse(Exception e) {
                
            }

            @Override
            public void onUserNotRegistered(UnregisteredError mUnregisteredError) {
                
            }
        });
        mFaspayPaymentService.inqueryPaymentStatus(new FaspayPaymentStatusRequestWrapper("x", "8986322540000844", "123123", mFaspayConfig), new FaspayPaymentService.FaspayInquiryPaymentStatusCallback() {
            @Override
            public void onGetInquiryPaymentStatusResponse(FaspayPaymentStatusResponse channel) {
                
            }

            @Override
            public void onErrorGetInquiryPaymentStatusResponse(Exception e) {
                
            }

            @Override
            public void onUserNotRegistered(UnregisteredError mUnregisteredError) {
                
            }
        });
        mFaspayPaymentService.cancelTransaction(new FaspayCancelPaymentRequestWrapper("8986322540000760", "123123", "gatau", mFaspayConfig), new FaspayPaymentService.FaspayCancelPaymentCallback() {
            @Override
            public void onCancelPaymentSuccess(FaspayCancelPaymentResponse channel) {
                System.out.println(channel.getTrxStatusDesc());
            }

            @Override
            public void onErrorRequstCancelPayment(Exception e) {
                
            }

            @Override
            public void onUserNotRegistered(UnregisteredError mUnregisteredError) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
    }

}
