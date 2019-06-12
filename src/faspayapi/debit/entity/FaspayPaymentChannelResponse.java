/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faspayapi.debit.entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 
 * @author hilmananwarsah
 */
public class FaspayPaymentChannelResponse {
    String response_code;
    String response_desc;

    public String getResponse_code() {
        return response_code;
    }

    public void setResponse_code(String response_code) {
        this.response_code = response_code;
    }

    public String getResponse_desc() {
        return response_desc;
    }

    public void setResponse_desc(String response_desc) {
        this.response_desc = response_desc;
    }
    
    String response;
    String merchant_id;
    String merchant;

    List<FaspayPaymentChannel> payment_channel = new ArrayList();

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getMerchant_id() {
        return merchant_id;
    }

    public void setMerchant_id(String merchant_id) {
        this.merchant_id = merchant_id;
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public List<FaspayPaymentChannel> getPayment_channel() {
        return payment_channel;
    }

    public void setPayment_channel(List<FaspayPaymentChannel> payment_channel) {
        this.payment_channel = payment_channel;
    }
    

}
