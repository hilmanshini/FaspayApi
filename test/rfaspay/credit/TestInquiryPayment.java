/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rfaspay.credit;

import faspayapi.credit.FaspayConfigCredit;
import faspayapi.credit.FaspayConfigCreditDev;
import faspayapi.credit.FaspayUserCredit;
import faspayapi.credit.TetsUser2;
import faspayapi.credit.entity.inquiry.InquiryRequestCredit;
import faspayapi.credit.entity.inquiry.InquiryRequestCreditWrapper;
import faspayapi.credit.entity.inquiry.InquiryResponseCredit;
import faspayapi.credit.rest.inquiry.FaspayCreditService;
import faspayapi.credit.rest.inquiry.FaspayCreditServiceImpl;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;

/**
 *
 * @author hilmananwarsah
 */
public class TestInquiryPayment extends InBrowserTest {

    @Test
    public void x() {
        CountDownLatch latch = new CountDownLatch(1);
        FaspayConfigCredit conf = new FaspayConfigCreditDev();
        FaspayUserCredit credit = new TetsUser2();
        InquiryRequestCredit d = new InquiryRequestCreditWrapper(conf, credit,  "2ccb26d48b6c428ba8ba69cdb5558197", 100000);
//        new FaspayCreditServiceImpl(conf).inquiry(d, new FaspayCreditService.InquiryPaymentCallback() {
//
//            @Override
//            public void onErrorGetResponseInquiryPaymentCredit(Exception E) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
//
//            @Override
//            public void onGetResponseInquiryPaymentCredit(InquiryResponseCredit clas) {
//                System.out.println(clas.getTXNSTATUS());
//                latch.countDown();
//            }
//        });
System.out.println(d.generateHtml());
        openHtml(d.generateHtml());
        try {
            latch.await();
        } catch (InterruptedException ex) {
            Logger.getLogger(TestInquiryPayment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
