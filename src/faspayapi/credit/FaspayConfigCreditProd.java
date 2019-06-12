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
public class FaspayConfigCreditProd extends FaspayConfigCredit
{

    @Override
    public String getMerchantWindowUrl() {
        return "https://fpg.faspay.co.id/payment";
    }

    @Override
    public String getMerchantDirectUrl() {
        return "https://fpg.faspay.co.id/payment";
    }
    
    
    @Override
    public String getMerchantInquiryUrl() {
        return "https://fpg.faspay.co.id/payment/api";
    }
    
}
