/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faspay;

import faspayapi.debit.FaspayConfigDebit;
import faspayapi.debit.FaspayConfigDebitDev;
import faspayapi.debit.FaspayConfigDebitProd;
import faspayapi.debit.entity.FaspayPaymentChannel;
import faspayapi.debit.entity.err.UnregisteredError;
import faspayapi.debit.rest.inquiry.FaspayInquiryPCService;
import faspayapi.debit.rest.inquiry.FaspayInquiryPCServiceImpl;
import faspayapi.test.TestFaspayUser;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hilmananwarsah
 */
public class TestDebitPaymentChannel {

    public TestDebitPaymentChannel() {
    }
    public final CountDownLatch latch = new CountDownLatch(1);

    @BeforeClass
    public static void setUpClass() {

    }

    @Test
    public void testDebitIncquiryPaymentChannel() {
        TestFaspayUser mTestFaspayUser = new TestFaspayUser();
        FaspayConfigDebit mFaspayConfig = new FaspayConfigDebitDev(mTestFaspayUser);

        //INQUIRY PAYMENT CHANNEL
        new FaspayInquiryPCServiceImpl(mFaspayConfig).inquiryPaymentChannel(new FaspayInquiryPCService.FaspayInquiryServiceCallback() {
            @Override
            public void onGetPaymentChannel(List<FaspayPaymentChannel> channel) {
                for (FaspayPaymentChannel faspayPaymentChannel : channel) {
                    System.out.println(faspayPaymentChannel.getPg_code() + " " + faspayPaymentChannel.getPg_name());

                }
                latch.countDown();
            }

            @Override
            public void onErrorGetPaymentChannel(Exception e) {
                e.printStackTrace();
                latch.countDown();
            }

            @Override
            public void onUserNotRegistered(UnregisteredError mUnregisteredError) {
                System.out.println(mUnregisteredError.getResponse_error().getResponse_code());
                latch.countDown();
            }
        });
        try {
            latch.await();
        } catch (InterruptedException ex) {
            Logger.getLogger(TestDebitPaymentChannel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void hello() {
    }
}
