/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faspay;

import faspayapi.debit.FaspayConfigDebit;
import faspayapi.debit.FaspayConfigDebitDev;
import faspayapi.debit.entity.FaspayCancelPaymentResponse;
import faspayapi.debit.entity.cancel.FaspayCancelPaymentRequestWrapper;
import faspayapi.debit.entity.err.UnregisteredError;
import faspayapi.debit.rest.inquiry.FaspayPaymentService;
import faspayapi.debit.rest.inquiry.FaspayPaymentServiceImpl;
import faspayapi.test.TestFaspayUser;
import java.util.concurrent.CountDownLatch;
import org.junit.Test;

/**
 *
 * @author hilmananwarsah
 */
public class TestCancel {

    @Test
    public void testCancel() {
        String trxId = "8986322540001644";
        String billNo = "123123";
        CountDownLatch latch = new CountDownLatch(1);
        TestFaspayUser mTestFaspayUser = new TestFaspayUser();
        FaspayConfigDebit mFaspayConfig = new FaspayConfigDebitDev(mTestFaspayUser);
        FaspayPaymentService mFaspayPaymentService = new FaspayPaymentServiceImpl(mFaspayConfig);
        mFaspayPaymentService.cancelTransaction(new FaspayCancelPaymentRequestWrapper(trxId, billNo, "test", mFaspayConfig), new FaspayPaymentService.FaspayCancelPaymentCallback() {
            @Override
            public void onCancelPaymentSuccess(FaspayCancelPaymentResponse channel) {
                System.out.println("CANCELED " + channel.getPaymentStatusDesc());
                latch.countDown();
            }

            @Override
            public void onErrorRequstCancelPayment(Exception e) {
                e.printStackTrace();
                System.out.println("error ");
                latch.countDown();
            }

            @Override
            public void onUserNotRegistered(UnregisteredError mUnregisteredError) {
                System.out.println("UNREG");
                latch.countDown();
            }
        });
    }
}
