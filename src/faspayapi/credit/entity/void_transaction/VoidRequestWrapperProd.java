/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faspayapi.credit.entity.void_transaction;

import faspayapi.credit.FaspayConfigCredit;
import faspayapi.credit.FaspayConfigCreditDev;
import faspayapi.credit.entity.capture.*;
import faspayapi.credit.FaspayUserCredit;
import faspayapi.credit.TetsUser;
import faspayapi.credit.TetsUser2;
import faspayapi.credit.entity.inquiry.InquiryRequestCreditWrapper;
import faspayapi.credit.entity.inquiry.InquiryResponseCredit;
import static faspayapi.credit.entity.payment.FaspayPaymentCredit.CARD_TYPE_AMEX;
import static faspayapi.credit.entity.payment.FaspayPaymentCredit.RESPONSE_TYPE_POST;
import faspayapi.credit.entity.payment.FaspayPaymentCreditWrapperDev;
import faspayapi.credit.entity.payment.wrapper.FaspayPaymentCreditBillData;
import faspayapi.credit.entity.payment.wrapper.FaspayPaymentCreditCardData;
import faspayapi.credit.entity.payment.wrapper.FaspayPaymentCreditConfigApp;
import faspayapi.credit.entity.payment.wrapper.FaspayPaymentCreditDomicileData;
import faspayapi.credit.entity.payment.wrapper.FaspayPaymentCreditItemData;
import faspayapi.credit.entity.payment.wrapper.FaspayPaymentCreditShippingdata;
import faspayapi.credit.entity.payment.wrapper.FaspayPaymentCreditShopperData;
import faspayapi.credit.entity.payment.wrapper.FaspayPaymentCreditTransactionData;
import faspayapi.credit.rest.inquiry.FaspayCreditService;
import faspayapi.credit.rest.inquiry.FaspayCreditServiceImpl;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.cli.Digest;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author hilmananwarsah
 */
public class VoidRequestWrapperProd extends VoidRequestCredit {

    public VoidRequestWrapperProd(FaspayUserCredit user, String MERCHANT_TRANID, String TRANSACTIONID, long AMOUNT, String CUSTNAME, String CUSTEMAIL, String DESCRIPTION, String RETURN_URL) {
        this.merchantid = user.getMerchantId();
        this.merchant_tranid = MERCHANT_TRANID;
        this.transactionid = TRANSACTIONID;
        DecimalFormat df = new DecimalFormat("#.00");
        this.amount = df.format(AMOUNT);
        this.custname = CUSTNAME;
        this.custemail = CUSTEMAIL;
        this.description = DESCRIPTION;
        this.return_url = RETURN_URL;
        String raw = new StringBuilder().append("##").append(user.getMerchantId().toUpperCase()).append("##").append(user.getPass().toUpperCase()).append("##").append(merchant_tranid).append("##").append(getAmount()).append("##").append(TRANSACTIONID).append("##").toString();
        System.out.println(raw);
        
        byte[] data = DigestUtils.sha1(raw);
        char[] sha1 = Hex.encodeHex(data);
        this.signature = (new String(sha1));
        
    }

    @Override
    public String getUrl() {
        return "https://fpg.faspay.co.id/payment/api";
    }

    public static void main(String[] args) {
        FaspayConfigCredit conf = new FaspayConfigCreditDev();
        FaspayUserCredit usr = new TetsUser2();
        String merchantTranId = UUID.randomUUID().toString().replaceAll("-", "");
        FaspayPaymentCreditWrapperDev w = new FaspayPaymentCreditWrapperDev(usr,
                new FaspayPaymentCreditTransactionData(usr, UUID.randomUUID().toString().replaceAll("-", ""), "IDR", 100000),
                new FaspayPaymentCreditShopperData("ha", "ha@ha.com",
                        "123123123123", "123123", "5123456789012346", "123123",
                        CARD_TYPE_AMEX, 10, "2020", "123123"),
                new FaspayPaymentCreditConfigApp(RESPONSE_TYPE_POST, "http://programmermiskin.chickenkiller.com/faspay/api/notify"),
                new FaspayPaymentCreditBillData("123", "123", "123", "123", "123", "ID"),
                new FaspayPaymentCreditShippingdata("5", "5", "5", "5", "5", "5", 0),
                new FaspayPaymentCreditItemData("Baju koko robet"),
                new FaspayPaymentCreditDomicileData(),
                new FaspayPaymentCreditCardData());

//        System.out.println(w.generateHtml());
        try {
            File temp = File.createTempFile(UUID.randomUUID().toString(), ".html");
            System.out.println(temp.getAbsolutePath());
            FileOutputStream fos = new FileOutputStream(temp);
            fos.write(w.generateHtml().getBytes());
            fos.flush();
            fos.close();
            System.out.println(temp.getAbsolutePath());
//            openFile(temp);
        } catch (IOException ex) {
//            Logger.getLogger(TestCreatePayment.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
//        try {
//            latch.await();
//        } catch (InterruptedException ex) {
//            Logger.getLogger(TestCreatePayment.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        System.out.println(new VoidRequestWrapperDev(new TetsUser2(), "2019061200757", "66A93765-1DC2-46FD-B542-267AF1B75AE4", 100000, "merhcant test CC", "haha@haha.com", "ddddd ", "https://programmermiskin.chickenkiller.com/faspay/api/notify").generateHtml());
        new FaspayCreditServiceImpl(conf).voidTransaction(new VoidRequestWrapperDev(new TetsUser2(), "44850a85e59648e4b7f909456599132d", "CFACADF1-4367-4604-B6B4-23E704D978D0", 100000, "merhcant test CC", "haha@haha.com", "ddddd ", "https://programmermiskin.chickenkiller.com/faspay/api/notify"), new FaspayCreditService.VoidPaymentCallback() {
            @Override
            public void onErrorVoidPaymentCallback(Exception E) {

            }

            @Override
            public void onVoidSuucess(VoidResponseCredit responseCredit) {

            }
        });
        

    }

}
