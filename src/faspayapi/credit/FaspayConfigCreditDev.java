/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faspayapi.credit;

/**
 *
 * @author hilmananwarsah
 */
public class FaspayConfigCreditDev extends FaspayConfigCredit{

    @Override
    public String getMerchantWindowUrl() {
        return "https://fpgdev.faspay.co.id/payment";
    }

    @Override
    public String getMerchantDirectUrl() {
        return "https://fpgdev.faspay.co.id/payment";
    }

    @Override
    public String getMerchantInquiryUrl() {
        return "https://fpgdev.faspay.co.id/payment/api";
    }
    
}
