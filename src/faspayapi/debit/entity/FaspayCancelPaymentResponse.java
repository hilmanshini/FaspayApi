/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faspayapi.debit.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "response",
    "trx_id",
    "merchant_id",
    "merchant",
    "bill_no",
    "trx_status_code",
    "trx_status_desc",
    "payment_status_code",
    "payment_status_desc",
    "payment_cancel_date",
    "payment_cancel",
    "response_code",
    "response_desc"
})
public class FaspayCancelPaymentResponse {

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
    @JsonProperty("trx_status_code")
    private String trxStatusCode;
    @JsonProperty("trx_status_desc")
    private String trxStatusDesc;
    @JsonProperty("payment_status_code")
    private String paymentStatusCode;
    @JsonProperty("payment_status_desc")
    private String paymentStatusDesc;
    @JsonProperty("payment_cancel_date")
    private List<Object> paymentCancelDate = new ArrayList<Object>();
    @JsonProperty("payment_cancel")
    private String paymentCancel;
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

    @JsonProperty("trx_status_code")
    public String getTrxStatusCode() {
        return trxStatusCode;
    }

    @JsonProperty("trx_status_code")
    public void setTrxStatusCode(String trxStatusCode) {
        this.trxStatusCode = trxStatusCode;
    }

    @JsonProperty("trx_status_desc")
    public String getTrxStatusDesc() {
        return trxStatusDesc;
    }

    @JsonProperty("trx_status_desc")
    public void setTrxStatusDesc(String trxStatusDesc) {
        this.trxStatusDesc = trxStatusDesc;
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

    @JsonProperty("payment_cancel_date")
    public List<Object> getPaymentCancelDate() {
        return paymentCancelDate;
    }

    @JsonProperty("payment_cancel_date")
    public void setPaymentCancelDate(List<Object> paymentCancelDate) {
        this.paymentCancelDate = paymentCancelDate;
    }

    @JsonProperty("payment_cancel")
    public String getPaymentCancel() {
        return paymentCancel;
    }

    @JsonProperty("payment_cancel")
    public void setPaymentCancel(String paymentCancel) {
        this.paymentCancel = paymentCancel;
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
