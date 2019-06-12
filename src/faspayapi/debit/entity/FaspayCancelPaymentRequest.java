/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faspayapi.debit.entity;

/**
 *
 * @author hilmananwarsah
 */

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;



@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "request",
    "trx_id",
    "merchant_id",
    "merchant",
    "bill_no",
    "payment_cancel",
    "signature"
})
public class FaspayCancelPaymentRequest {

    @JsonProperty("request")
    private String request;
    @JsonProperty("trx_id")
    private String trxId;
    @JsonProperty("merchant_id")
    private String merchantId;
    @JsonProperty("merchant")
    private String merchant;
    @JsonProperty("bill_no")
    private String billNo;
    @JsonProperty("payment_cancel")
    private String paymentCancel;
    @JsonProperty("signature")
    private String signature;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("request")
    public String getRequest() {
        return request;
    }

    @JsonProperty("request")
    public void setRequest(String request) {
        this.request = request;
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

    @JsonProperty("payment_cancel")
    public String getPaymentCancel() {
        return paymentCancel;
    }

    @JsonProperty("payment_cancel")
    public void setPaymentCancel(String paymentCancel) {
        this.paymentCancel = paymentCancel;
    }

    @JsonProperty("signature")
    public String getSignature() {
        return signature;
    }

    @JsonProperty("signature")
    public void setSignature(String signature) {
        this.signature = signature;
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
