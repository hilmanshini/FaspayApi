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
    "response_desc"
})
public class FaspayPaymentStatusResponse {

    @JsonProperty("response")
    private String response;
    @JsonProperty("trx_id")
    private String trxId;
    @JsonProperty("merchant_id")
    private String merchantId;
    @JsonProperty("merchant")
    private String merchant;
    @JsonProperty("bill_no")
    private String billNo;
    @JsonProperty("payment_reff")
    private List<String> paymentReff;
    @JsonProperty("payment_date")
    private List<String> paymentDate;
    @JsonProperty("payment_status_code")
    private String paymentStatusCode;
    @JsonProperty("payment_status_desc")
    private String paymentStatusDesc;
    @JsonProperty("response_code")
    private String responseCode;
    @JsonProperty("response_desc")
    private String responseDesc;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("response")
    public String getResponse() {
        return response;
    }

    @JsonProperty("response")
    public void setResponse(String response) {
        this.response = response;
    }

    @JsonProperty("trx_id")
    public String getTrxId() {
        return trxId;
    }

    @JsonProperty("trx_id")
    public void setTrxId(String trxId) {
        this.trxId = trxId;
    }

    @JsonProperty("merchant_id")
    public String getMerchantId() {
        return merchantId;
    }

    @JsonProperty("merchant_id")
    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    @JsonProperty("merchant")
    public String getMerchant() {
        return merchant;
    }

    @JsonProperty("merchant")
    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    @JsonProperty("bill_no")
    public String getBillNo() {
        return billNo;
    }

    @JsonProperty("bill_no")
    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public List<String> getPaymentReff() {
        return paymentReff;
    }

    public void setPaymentReff(List<String> paymentReff) {
        this.paymentReff = paymentReff;
    }

    public List<String> getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(List<String> paymentDate) {
        this.paymentDate = paymentDate;
    }

    

    

    @JsonProperty("payment_status_code")
    public String getPaymentStatusCode() {
        return paymentStatusCode;
    }

    @JsonProperty("payment_status_code")
    public void setPaymentStatusCode(String paymentStatusCode) {
        this.paymentStatusCode = paymentStatusCode;
    }

    @JsonProperty("payment_status_desc")
    public String getPaymentStatusDesc() {
        return paymentStatusDesc;
    }

    @JsonProperty("payment_status_desc")
    public void setPaymentStatusDesc(String paymentStatusDesc) {
        this.paymentStatusDesc = paymentStatusDesc;
    }

    @JsonProperty("response_code")
    public String getResponseCode() {
        return responseCode;
    }

    @JsonProperty("response_code")
    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    @JsonProperty("response_desc")
    public String getResponseDesc() {
        return responseDesc;
    }

    @JsonProperty("response_desc")
    public void setResponseDesc(String responseDesc) {
        this.responseDesc = responseDesc;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
