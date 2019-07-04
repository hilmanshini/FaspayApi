/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faspay;

import faspayapi.debit.FaspayUserDebit;

/**
 *
 * @author hilmananwarsah
 */
public class TestFaspayPro extends FaspayUserDebit {

    public TestFaspayPro() {
        setMerchantId("99999");
        setMerchantName("FASFAY");
        setPassword("p@ssw0rd");
        setRedirectUrl("https://faspay.co.id/merchantpage/billing/process/thankyou");
        setUserId("bot99999");

    }

}
