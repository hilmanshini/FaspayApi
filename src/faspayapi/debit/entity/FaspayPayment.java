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
    "product",
    "qty",
    "amount",
    "payment_plan",
    "merchant_id",
    "tenor"
})
public class FaspayPayment {
    public static final String PAYMENT_PLAN_FULL_SETTLEMENT = "1";
    public static final String PAYMENT_PLAN_INSTALLMENT = "2";
    public static final String TENOR_FULL = "00";
    public static final String TENOR_3MONTHS = "03";   
    public static final String TENOR_6MONTHS = "06";   
    public static final String TENOR_12MONTHS = "12";   

    @JsonProperty("product")
    private String product;
    @JsonProperty("qty")
    private String qty;
    @JsonProperty("amount")
    private String amount;
    @JsonProperty("payment_plan")
    private String paymentPlan;
    @JsonProperty("merchant_id")
    private String merchantId;
    @JsonProperty("tenor")
    private String tenor;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public FaspayPayment(String product, int qty, long amount, String paymentPlan, String merchantId, String tenor) {
        this.product = product;
        this.qty = String.valueOf(qty);
        this.amount = String.valueOf(amount);
        this.paymentPlan = paymentPlan;
        this.merchantId = merchantId;
        this.tenor = tenor;
    }

    public FaspayPayment() {
    }
    
    
    @JsonProperty("product")
    public String getProduct() {
        return product;
    }

    @JsonProperty("product")
    public void setProduct(String product) {
        this.product = product;
    }

    @JsonProperty("qty")
    public String getQty() {
        return qty;
    }

    @JsonProperty("qty")
    public void setQty(String qty) {
        this.qty = qty;
    }

    @JsonProperty("amount")
    public String getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(String amount) {
        this.amount = amount;
    }

    @JsonProperty("payment_plan")
    public String getPaymentPlan() {
        return paymentPlan;
    }

    @JsonProperty("payment_plan")
    public void setPaymentPlan(String paymentPlan) {
        this.paymentPlan = paymentPlan;
    }

    @JsonProperty("merchant_id")
    public String getMerchantId() {
        return merchantId;
    }

    @JsonProperty("merchant_id")
    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    @JsonProperty("tenor")
    public String getTenor() {
        return tenor;
    }

    @JsonProperty("tenor")
    public void setTenor(String tenor) {
        this.tenor = tenor;
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
