/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faspayapi.debit.entity;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "response",
    "trx_id",
    "merchant_id",
    "merchant",
    "bill_no",
    "payment_reff",
    "payment_date",
    "payment_status_code",
    "payment_status_desc",
    "response_code",
    "response_desc",
    "payment_status_code"
})
public class FaspayPaymentStatusResponse {


    

    
    
    @JsonProperty("response")
    private Object response;
    @JsonProperty("trx_id")
    private Object trxId;
    @JsonProperty("merchant_id")
    private Object merchantId;
    @JsonProperty("merchant")
    private Object merchant;
    @JsonProperty("bill_no")
    private Object billNo;
    @JsonProperty("payment_reff")
    private Object paymentReff;
    @JsonProperty("payment_date")
    private Object paymentDate;
    @JsonProperty("payment_status_code")
    private Object paymentStatusCode;
    @JsonProperty("payment_status_desc")
    private Object paymentStatusDesc;
    @JsonProperty("response_code")
    private Object responseCode;
    @JsonProperty("response_desc")
    private Object responseDesc;
    @JsonProperty("payment_total")
    private Object payment_total;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Object getResponse() {
        return response;
    }

    public Object getPayment_total() {
        return payment_total;
    }

    public void setPayment_total(Object payment_total) {
        this.payment_total = payment_total;
    }

    public void setResponse(Object response) {
        this.response = response;
    }

    public Object getTrxId() {
        return trxId;
    }

    public void setTrxId(Object trxId) {
        this.trxId = trxId;
    }

    public Object getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Object merchantId) {
        this.merchantId = merchantId;
    }

    public Object getMerchant() {
        return merchant;
    }

    public void setMerchant(Object merchant) {
        this.merchant = merchant;
    }

    public Object getBillNo() {
        return billNo;
    }

    public void setBillNo(Object billNo) {
        this.billNo = billNo;
    }

    public Object getPaymentReff() {
        return paymentReff;
    }

    public void setPaymentReff(Object paymentReff) {
        this.paymentReff = paymentReff;
    }

    public Object getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Object paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Object getPaymentStatusCode() {
        return paymentStatusCode;
    }

    public void setPaymentStatusCode(Object paymentStatusCode) {
        this.paymentStatusCode = paymentStatusCode;
    }

    public Object getPaymentStatusDesc() {
        return paymentStatusDesc;
    }

    public void setPaymentStatusDesc(Object paymentStatusDesc) {
        this.paymentStatusDesc = paymentStatusDesc;
    }

    public Object getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Object responseCode) {
        this.responseCode = responseCode;
    }

    public Object getResponseDesc() {
        return responseDesc;
    }

    public void setResponseDesc(Object responseDesc) {
        this.responseDesc = responseDesc;
    }

    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    

}
