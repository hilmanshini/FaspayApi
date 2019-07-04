/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faspayapi.debit.entity.notify;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author hilmananwarsah
 */
@JacksonXmlRootElement(localName = "faspay")
public class FaspayTraceSuccessXMLResponse {

    String response = "Payment Notification";
    String trx_id;
    String merchant_id;
    String bill_no;
    String response_code = "00";
    String response_desc = "Success";
    String response_date;

    public FaspayTraceSuccessXMLResponse(String trx_id, String merchant_id, String bill_no) {
        this.trx_id = trx_id;
        this.merchant_id = merchant_id;
        this.bill_no = bill_no;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        response_date = sdf.format(new Date());
    }

    public FaspayTraceSuccessXMLResponse(FaspayXMLResponse response) {
        this.trx_id = response.getTrx_id();
        this.merchant_id = response.getMerchant_id();
        this.bill_no = response.getBill_no();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        response_date = sdf.format(new Date());
    }
    

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
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

    public String getBill_no() {
        return bill_no;
    }

    public void setBill_no(String bill_no) {
        this.bill_no = bill_no;
    }

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

    public String getResponse_date() {
        return response_date;
    }

    public void setResponse_date(String response_date) {
        this.response_date = response_date;
    }
    
}
