/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faspayapi.credit.entity.payment.wrapper;

import faspayapi.credit.entity.payment.FaspayPaymentCredit;
import java.text.DecimalFormat;

/**
 *
 * @author hilmananwarsah
 */
public class FaspayPaymentCreditShippingdata {
    
    private String receiver_name_for_shipping;
    private String shipping_address;
    private String shipping_address_city;
    private String shipping_address_region;
    private String shipping_address_state;
    private String shipping_address_poscode;
    private String shipping_address_country_code;
    private String shippingcost;

    public FaspayPaymentCreditShippingdata(String shipping_address, String shipping_address_city, String shipping_address_region, String shipping_address_state, String shipping_address_poscode, String shipping_address_country_code, long shippingcost) {
        this.shipping_address = shipping_address;
        this.shipping_address_city = shipping_address_city;
        this.shipping_address_region = shipping_address_region;
        this.shipping_address_state = shipping_address_state;
        this.shipping_address_poscode = shipping_address_poscode;
        this.shipping_address_country_code = shipping_address_country_code;
        DecimalFormat d = new DecimalFormat("#.00");
        this.shippingcost = d.format(shippingcost);
    }

    public String getReceiver_name_for_shipping() {
        return receiver_name_for_shipping;
    }

    public void setReceiver_name_for_shipping(String receiver_name_for_shipping) {
        this.receiver_name_for_shipping = receiver_name_for_shipping;
    }

    public String getShipping_address() {
        return shipping_address;
    }

    public void setShipping_address(String shipping_address) {
        this.shipping_address = shipping_address;
    }

    public String getShipping_address_city() {
        return shipping_address_city;
    }

    public void setShipping_address_city(String shipping_address_city) {
        this.shipping_address_city = shipping_address_city;
    }

    public String getShipping_address_region() {
        return shipping_address_region;
    }

    public void setShipping_address_region(String shipping_address_region) {
        this.shipping_address_region = shipping_address_region;
    }

    public String getShipping_address_state() {
        return shipping_address_state;
    }

    public void setShipping_address_state(String shipping_address_state) {
        this.shipping_address_state = shipping_address_state;
    }

    public String getShipping_address_poscode() {
        return shipping_address_poscode;
    }

    public void setShipping_address_poscode(String shipping_address_poscode) {
        this.shipping_address_poscode = shipping_address_poscode;
    }

    public String getShipping_address_country_code() {
        return shipping_address_country_code;
    }

    public void setShipping_address_country_code(String shipping_address_country_code) {
        this.shipping_address_country_code = shipping_address_country_code;
    }

    public String getShippingcost() {
        return shippingcost;
    }

    public void setShippingcost(String shippingcost) {
        this.shippingcost = shippingcost;
    }
    

}
