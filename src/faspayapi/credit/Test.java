/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faspayapi.credit;

import static faspayapi.credit.entity.payment.FaspayPaymentCredit.CARD_TYPE_VISA;
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
import faspayapi.debit.FaspayConfigDebitDev;
import faspayapi.debit.entity.err.UnregisteredError;
import faspayapi.debit.rest.inquiry.FaspayInquiryPCService;
import faspayapi.debit.rest.inquiry.FaspayInquiryPCServiceImpl;
import faspayapi.rest.ApiServiceImpl;
import faspayapi.rest.UnregisteredErrorCallback;
import faspayapi.test.TestFaspayUser;
import java.util.UUID;

/**
 *
 * @author hilmananwarsah
 */
public class Test {
    public static void main(String[] args) {
        FaspayUserCredit usr = new TetsUser2();

        FaspayPaymentCreditWrapperDev w = new FaspayPaymentCreditWrapperDev(usr,
                new FaspayPaymentCreditTransactionData(usr, UUID.randomUUID().toString().replaceAll("-", ""), "IDR", 100000),
                new FaspayPaymentCreditShopperData("ha", "ha@ha.com",
                        "123123123123", "123123", "5123456789012346", "123123",
                        CARD_TYPE_VISA, 10, "2020", "123123"),
                new FaspayPaymentCreditConfigApp(RESPONSE_TYPE_POST, "http://programmermiskin.chickenkiller.com/faspay/api/notify"),
                new FaspayPaymentCreditBillData("123", "123", "123", "123", "123", "ID"),
                new FaspayPaymentCreditShippingdata("5", "5", "5", "5", "5", "5", 0),
                new FaspayPaymentCreditItemData("Baju koko robet"),
                new FaspayPaymentCreditDomicileData(),
                new FaspayPaymentCreditCardData());

        System.out.println(w.generateHtml());
        
    }
}
