/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rfaspay;

import faspayapi.debit.FaspayConfigDebit;
import faspayapi.debit.FaspayConfigDebitDev;
import faspayapi.debit.FaspayUserDebit;
import faspayapi.debit.entity.FaspayPayment;
import faspayapi.debit.entity.FaspayPaymentChannel;
import faspayapi.debit.entity.FaspayPaymentResponse;
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
public class TestCreatePayment {

    public TestCreatePayment() {
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
        
    }
}
