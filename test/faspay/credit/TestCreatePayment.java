    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faspay.credit;


import faspayapi.credit.FaspayUserCredit;
import faspayapi.credit.TetsUser;
import faspayapi.credit.TetsUser2;
import static faspayapi.credit.entity.payment.FaspayPaymentCredit.CARD_TYPE_VISA;
import static faspayapi.credit.entity.payment.FaspayPaymentCredit.RESPONSE_TYPE_POST;
import faspayapi.credit.entity.payment.FaspayPaymentCreditWrapperDev;
import faspayapi.credit.entity.payment.FaspayPaymentCreditWrapperProd;
import faspayapi.credit.entity.payment.wrapper.FaspayPaymentCreditBillData;
import faspayapi.credit.entity.payment.wrapper.FaspayPaymentCreditCardData;
import faspayapi.credit.entity.payment.wrapper.FaspayPaymentCreditConfigApp;
import faspayapi.credit.entity.payment.wrapper.FaspayPaymentCreditDomicileData;
import faspayapi.credit.entity.payment.wrapper.FaspayPaymentCreditItemData;
import faspayapi.credit.entity.payment.wrapper.FaspayPaymentCreditShippingdata;
import faspayapi.credit.entity.payment.wrapper.FaspayPaymentCreditShopperData;
import faspayapi.credit.entity.payment.wrapper.FaspayPaymentCreditTransactionData;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author hilmananwarsah
 */
public class TestCreatePayment extends InBrowserTest {

    CountDownLatch latch = new CountDownLatch(1);

    public TestCreatePayment() {
    }

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
    
    
    public void TestUserBaruCredit() {
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void hello() {
        //FaspayUserCredit usr = new TetsUser2();
        FaspayUserCredit usr = new TestUserBaruCredit();
                FaspayPaymentCreditWrapperProd w = new FaspayPaymentCreditWrapperProd(usr,
                new FaspayPaymentCreditTransactionData(usr, UUID.randomUUID().toString().replaceAll("-", ""), "IDR", 10000),
                new FaspayPaymentCreditShopperData("ha", "ha@ha.com",
                        "123123123123", "123123", "5123456789012346", "123123",
                        CARD_TYPE_VISA, 10, "2020", "123123"),
                new FaspayPaymentCreditConfigApp(RESPONSE_TYPE_POST, "https://programmermiskin.chickenkiller.com/faspay/api/notify"),
                new FaspayPaymentCreditBillData("123", "123", "123", "123", "123", "ID"),
                new FaspayPaymentCreditShippingdata("5", "5", "5", "5", "5", "5", 0),
                new FaspayPaymentCreditItemData("Racun TIkus","Pil KB","Bubur ayam"),
                new FaspayPaymentCreditDomicileData(),
                new FaspayPaymentCreditCardData());

//        System.out.println(w.generateHtml());
        try {
            File temp = File.createTempFile(UUID.randomUUID().toString(), ".html");

            FileOutputStream fos = new FileOutputStream(temp);
            fos.write(w.generateHtml().getBytes());
            fos.flush();
            fos.close();
            System.out.println(temp.getAbsolutePath());
           openFile(temp);
        } catch (IOException ex) {
            Logger.getLogger(TestCreatePayment.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            latch.await();
        } catch (InterruptedException ex) {
            Logger.getLogger(TestCreatePayment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
