/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faspayapi.test;

import faspayapi.debit.FaspayConfigDebit;
import faspayapi.debit.FaspayConfigDebitDev;
import faspayapi.debit.FaspayUserDebit;
import faspayapi.debit.entity.FaspayCancelPaymentResponse;
import faspayapi.debit.entity.FaspayPayment;
import faspayapi.debit.entity.FaspayPaymentChannel;
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
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.codec.cli.Digest;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author hilmananwarsah
 */
public class TestFaspayUser extends FaspayUserDebit {

    public TestFaspayUser() {
        super("SINTESA", "32254", "bot32254", "p@ssw0rd", "");
    }

    public static void main(String[] args) {
        TestFaspayUser m = new TestFaspayUser();

        TestFaspayUser mTestFaspayUser = new TestFaspayUser();
        FaspayConfigDebit mFaspayConfig = new FaspayConfigDebitDev(mTestFaspayUser);

        //INQUIRY PAYMENT CHANNEL
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
                System.out.println(mUnregisteredError.getResponse_error().getResponse_code());
            }
        });
        // MOCK PAYMENT CHANNEL
//        //CHANGE TRX ID AND BILL NOW , in 2nd and 3rd param
//        mFaspayPaymentService.inqueryPaymentStatus(new FaspayPaymentStatusRequestWrapper("x", "8986322540000844", "123123", mFaspayConfig), new FaspayPaymentService.FaspayInquiryPaymentStatusCallback() {
//            @Override
//            public void onGetInquiryPaymentStatusResponse(FaspayPaymentStatusResponse channel) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
//
//            @Override
//            public void onErrorGetInquiryPaymentStatusResponse(Exception e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
//        });
//        //TO CANCEL PAYMENT
//        mFaspayPaymentService.cancelTransaction(new FaspayCancelPaymentRequestWrapper("8986322540000760", "123123", "gatau", mFaspayConfig), new FaspayPaymentService.FaspayCancelPaymentCallback() {
//            @Override
//            public void onCancelPaymentSuccess(FaspayCancelPaymentResponse channel) {
//                System.out.println(channel.getTrxStatusDesc());
//            }
//
//            @Override
//            public void onErrorRequstCancelPayment(Exception e) {
//                
//            }
//        });

    }

}
