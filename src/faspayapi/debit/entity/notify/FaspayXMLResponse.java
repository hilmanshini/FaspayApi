/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faspayapi.debit.entity.notify;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hilmananwarsah
 */
@JacksonXmlRootElement(localName = "faspay")
public class FaspayXMLResponse {
 String request, trx_id, merchant_id, merchant, bill_no, payment_reff, payment_date, payment_status_code, payment_status_desc, signature,payment_total,payment_channel_uid,payment_channel;
    long bill_total;

    public String getPayment_total() {
        return payment_total;
    }

    public void setPayment_total(String payment_total) {
        this.payment_total = payment_total;
    }

    public String getPayment_channel_uid() {
        return payment_channel_uid;
    }

    public void setPayment_channel_uid(String payment_channel_uid) {
        this.payment_channel_uid = payment_channel_uid;
    }

    public String getPayment_channel() {
        return payment_channel;
    }

    public void setPayment_channel(String payment_channel) {
        this.payment_channel = payment_channel;
    }

   
    public long getBill_total() {
        return bill_total;
    }

    public void setBill_total(long bill_total) {
        this.bill_total = bill_total;
    }
    

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getTrx_id() {
        return trx_id;
    }

    public void setTrx_id(String trx_id) {
        this.trx_id = trx_id;
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

    public String getBill_no() {
        return bill_no;
    }

    public void setBill_no(String bill_no) {
        this.bill_no = bill_no;
    }

    public String getPayment_reff() {
        return payment_reff;
    }

    public void setPayment_reff(String payment_reff) {
        this.payment_reff = payment_reff;
    }

    public String getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(String payment_date) {
        this.payment_date = payment_date;
    }

    public String getPayment_status_code() {
        return payment_status_code;
    }

    public void setPayment_status_code(String payment_status_code) {
        this.payment_status_code = payment_status_code;
    }

    public String getPayment_status_desc() {
        return payment_status_desc;
    }

    public void setPayment_status_desc(String payment_status_desc) {
        this.payment_status_desc = payment_status_desc;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    
}
