/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faspayapi.debit.entity.request_bill;

/**
 *
 * @author hilmananwarsah
 */
public class FaspayPaymentRequestShippingData {

    String receiver_name_for_shipping = "";
    String shipping_lastname = "";
    String shipping_address = "";
    String shipping_address_city = "";
    String shipping_address_region = "";
    String shipping_address_state = "";
    String shipping_address_poscode = "";
    String shipping_msisdn = "";
    String shipping_address_country_code = "ID";

    public String getReceiver_name_for_shipping() {
        return receiver_name_for_shipping;
    }

    public void setReceiver_name_for_shipping(String receiver_name_for_shipping) {
        this.receiver_name_for_shipping = receiver_name_for_shipping;
    }

    public String getShipping_lastname() {
        return shipping_lastname;
    }

    public void setShipping_lastname(String shipping_lastname) {
        this.shipping_lastname = shipping_lastname;
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

    public String getShipping_msisdn() {
        return shipping_msisdn;
    }

    public void setShipping_msisdn(String shipping_msisdn) {
        this.shipping_msisdn = shipping_msisdn;
    }

    public String getShipping_address_country_code() {
        return shipping_address_country_code;
    }

    public void setShipping_address_country_code(String shipping_address_country_code) {
        this.shipping_address_country_code = shipping_address_country_code;
    }

}
