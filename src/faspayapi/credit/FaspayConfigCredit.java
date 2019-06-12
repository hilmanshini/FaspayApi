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
public abstract class FaspayConfigCredit {
    String merchantWindowUrl;
    String merchantDirectUrl;

    abstract public String getMerchantWindowUrl() ;

    abstract public String getMerchantDirectUrl() ;
    
    abstract public String getMerchantInquiryUrl();
    
}
