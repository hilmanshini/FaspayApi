/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faspay;

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
import faspayapi.debit.rest.inquiry.FaspayPaymentService;
import faspayapi.debit.rest.inquiry.FaspayPaymentServiceImpl;
import faspayapi.test.TestFaspayUser;
import java.util.ArrayList;
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
public class TestCreateAndCancel {

    public TestCreateAndCancel() {
    }
    CountDownLatch latch = new CountDownLatch(1);

    @BeforeClass
    public static void setUpClass() {

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
        TestFaspayUser mTestFaspayUser = new TestFaspayUser();
        FaspayConfigDebit mFaspayConfig = new FaspayConfigDebitDev(mTestFaspayUser);

//        FaspayPaymentChannel mFaspayPaymentChannel = new FaspayPaymentChannel();
//        mFaspayPaymentChannel.setPg_code("402");
//        mFaspayPaymentChannel.setPg_name("ALFA");

//        //ADD MOCK ITEMS
//        List<FaspayPayment> item = new ArrayList<>();
//        item.add(new FaspayPayment("anjing edan", 1, 100000, FaspayPayment.PAYMENT_PLAN_FULL_SETTLEMENT, mFaspayConfig.getFaspayUser().getMerchantId(), FaspayPayment.TENOR_FULL));
//        //CREATE BILL DATA
//        FaspayPaymentRequestBillData billing = new FaspayPaymentRequestBillData("123123", "x", 10, "10000", item);
//        //CREATE BILL USERDATA
//        FaspayPaymentRequestUserData mFaspayPaymentRequestUserData = new FaspayPaymentRequestUserData("087123123123", "hil@hil.com", String.valueOf(FaspayPaymentRequestWrapper.TERMINAL_MOBILE_APP_ANDROID), "123123", "hahahaha");
//        //CREATE BILL SHIPPING DATA
//        FaspayPaymentRequestShippingData mFaspayPaymentRequestShippingData = new FaspayPaymentRequestShippingData();
//        //WRAPP ALL BILL
//        FaspayPaymentRequestWrapper mFaspayPaymentRequestWrapper = new FaspayPaymentRequestWrapper(mFaspayConfig, billing, mFaspayPaymentChannel, mFaspayPaymentRequestUserData, mFaspayPaymentRequestShippingData);
//        //send response
        FaspayPaymentService mFaspayPaymentService = new FaspayPaymentServiceImpl(mFaspayConfig);
        String trxId = "8986322540001651";
        String billNo = "123123";
        cancel(mFaspayPaymentService, mFaspayConfig, trxId, billNo);
//        mFaspayPaymentService.createBilling(mFaspayPaymentRequestWrapper, new FaspayPaymentService.FaspayCreateBillingServiceCallback() {
//            @Override
//            public void onGetPaymentResponse(FaspayPaymentResponse channel) {
//                System.out.println("OK");
//
//                inquiry(channel, mFaspayPaymentService, mFaspayConfig);
//            }
//
//            @Override
//            public void onErrorGetPaymentResponse(Exception e) {
//                System.out.println("ERRO");
//                e.printStackTrace();
//                latch.countDown();
//            }
//
//            @Override
//            public void onUserNotRegistered(UnregisteredError mUnregisteredError) {
//                System.out.println("unreg " + mUnregisteredError.getResponse_error().getResponse_desc());
//                latch.countDown();
//            }
//
//        });
        try {
            latch.await();
        } catch (InterruptedException ex) {
            Logger.getLogger(TestCreateAndCancel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void inquiry(FaspayPaymentResponse channel, FaspayPaymentService mFaspayPaymentService, FaspayConfigDebit conf) {
        System.out.println("inq");

        mFaspayPaymentService.cancelTransaction(new FaspayCancelPaymentRequestWrapper(channel.getTrxId(), channel.getBillNo(), "test", conf), new FaspayPaymentService.FaspayCancelPaymentCallback() {
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

    private void cancel(FaspayPaymentService mFaspayPaymentService, FaspayConfigDebit configDebit, String trxId, String billNo) {
        mFaspayPaymentService.cancelTransaction(new FaspayCancelPaymentRequestWrapper(trxId, billNo, "test", configDebit), new FaspayPaymentService.FaspayCancelPaymentCallback() {
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
