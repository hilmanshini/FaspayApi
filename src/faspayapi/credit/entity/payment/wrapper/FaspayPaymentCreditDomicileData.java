/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faspayapi.credit.entity.payment.wrapper;

import faspayapi.credit.entity.payment.FaspayPaymentCredit;

/**
 *
 * @author hilmananwarsah
 */
public class FaspayPaymentCreditDomicileData {
    
    private String domicile_address;
    private String domicile_address_city;
    private String domicile_address_region;
    private String domicile_address_state;
    private String domicile_address_poscode;
    private String domicile_address_country_code;
    private String domicile_phone_no;

    public String getDomicile_address() {
        return domicile_address;
    }

    public void setDomicile_address(String domicile_address) {
        this.domicile_address = domicile_address;
    }

    public String getDomicile_address_city() {
        return domicile_address_city;
    }

    public void setDomicile_address_city(String domicile_address_city) {
        this.domicile_address_city = domicile_address_city;
    }

    public String getDomicile_address_region() {
        return domicile_address_region;
    }

    public void setDomicile_address_region(String domicile_address_region) {
        this.domicile_address_region = domicile_address_region;
    }

    public String getDomicile_address_state() {
        return domicile_address_state;
    }

    public void setDomicile_address_state(String domicile_address_state) {
        this.domicile_address_state = domicile_address_state;
    }

    public String getDomicile_address_poscode() {
        return domicile_address_poscode;
    }

    public void setDomicile_address_poscode(String domicile_address_poscode) {
        this.domicile_address_poscode = domicile_address_poscode;
    }

    public String getDomicile_address_country_code() {
        return domicile_address_country_code;
    }

    public void setDomicile_address_country_code(String domicile_address_country_code) {
        this.domicile_address_country_code = domicile_address_country_code;
    }

    public String getDomicile_phone_no() {
        return domicile_phone_no;
    }

    public void setDomicile_phone_no(String domicile_phone_no) {
        this.domicile_phone_no = domicile_phone_no;
    }

    
    

}
