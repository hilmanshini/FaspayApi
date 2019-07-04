/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faspay;

import faspayapi.debit.FaspayConfigDebit;
import faspayapi.debit.FaspayConfigDebitDev;
import faspayapi.debit.FaspayConfigDebitProd;
import faspayapi.debit.entity.FaspayPaymentStatusRequestWrapper;
import faspayapi.debit.entity.FaspayPaymentStatusRequestWrapperProd;
import faspayapi.debit.entity.FaspayPaymentStatusResponse;
import faspayapi.debit.entity.err.UnregisteredError;
import faspayapi.debit.rest.inquiry.FaspayPaymentService;
import faspayapi.debit.rest.inquiry.FaspayPaymentServiceImpl;
import faspayapi.test.TestFaspayUser;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;

/**
 *
 * @author hilmananwarsah
 */
public class TestInquiry {

    @Test
    public void testInquiry() {
        CountDownLatch latch = new CountDownLatch(1);
        TestFaspayPro mTestFaspayUser = new TestFaspayPro();
        FaspayConfigDebit mFaspayConfig = new FaspayConfigDebitProd(mTestFaspayUser);
        FaspayPaymentService mFaspayPaymentService = new FaspayPaymentServiceImpl(mFaspayConfig);
        String trxId = "8830800900002642";
        String billNo = "123123";
        mFaspayPaymentService.inqueryPaymentStatus(new FaspayPaymentStatusRequestWrapperProd("", trxId, billNo, mFaspayConfig,"test","0"), new FaspayPaymentService.FaspayInquiryPaymentStatusCallback() {
            @Override
            public void onGetInquiryPaymentStatusResponse(FaspayPaymentStatusResponse channel) {
                System.out.println("OK " + channel.getPaymentStatusDesc());
                latch.countDown();

            }

            @Override
            public void onErrorGetInquiryPaymentStatusResponse(Exception e) {
                e.printStackTrace();
                System.out.println("ERROR ");
                latch.countDown();
            }

            @Override
            public void onUserNotRegistered(UnregisteredError mUnregisteredError) {
                System.out.println("UNREG");
                latch.countDown();
            }
        });
        try {
            latch.await();
        } catch (InterruptedException ex) {
            Logger.getLogger(TestInquiry.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
