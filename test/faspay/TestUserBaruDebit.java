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
public class TestUserBaruDebit extends FaspayUserDebit{

    public TestUserBaruDebit() {
        setMerchantId("merchnatId");
        setMerchantName("merchantName");
        setPassword("12345");
        setRedirectUrl("www.rarbg.com");
        setUserId("12345");
    }
    
    
    
}
