/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faspayapi.debit.entity;

/**
 *
 * @author hilmananwarsah
 *
 *
 */
import faspayapi.debit.entity.request_bill.FaspayPaymentRequestWrapper;
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
import faspayapi.debit.FaspayConfigDebit;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "request",
    "merchant_id",
    "merchant",
    "bill_no",
    "bill_reff",
    "bill_date",
    "bill_expired",
    "bill_desc",
    "bill_currency",
    "bill_gross",
    "bill_miscfee",
    "bill_total",
    "cust_no",
    "cust_name",
    "payment_channel",
    "pay_type",
    "bank_userid",
    "msisdn",
    "email",
    "terminal",
    "billing_name",
    "billing_lastname",
    "billing_address",
    "billing_address_city",
    "billing_address_region",
    "billing_address_state",
    "billing_address_poscode",
    "billing_msisdn",
    "billing_address_country_code",
    "receiver_name_for_shipping",
    "shipping_lastname",
    "shipping_address",
    "shipping_address_city",
    "shipping_address_region",
    "shipping_address_state",
    "shipping_address_poscode",
    "shipping_msisdn",
    "shipping_address_country_code",
    "item",
    "reserve1",
    "reserve2",
    "signature"
})
public class FaspayPaymentRequest {

    @JsonProperty("request")
    private String request;
    @JsonProperty("merchant_id")
    private String merchantId;
    @JsonProperty("merchant")
    private String merchant;
    @JsonProperty("bill_no")
    private String billNo;
    @JsonProperty("bill_reff")
    private String billReff;
    @JsonProperty("bill_date")
    private String billDate;
    @JsonProperty("bill_expired")
    private String billExpired;
    @JsonProperty("bill_desc")
    private String billDesc;
    @JsonProperty("bill_currency")
    private String billCurrency;
    @JsonProperty("bill_gross")
    private String billGross;
    @JsonProperty("bill_tax")
    private String billTax = "";
    @JsonProperty("bill_miscfee")
    private String billMiscfee;
    @JsonProperty("bill_total")
    private String billTotal;
    @JsonProperty("cust_no")
    private String custNo;
    @JsonProperty("cust_name")
    private String custName;
    @JsonProperty("payment_channel")
    private String paymentChannel;
    @JsonProperty("pay_type")
    private String payType;
    @JsonProperty("bank_userid")
    private String bankUserid;
    @JsonProperty("msisdn")
    private String msisdn;
    @JsonProperty("email")
    private String email;
    @JsonProperty("terminal")
    private String terminal;
    @JsonProperty("billing_name")
    private String billingName;
    @JsonProperty("billing_lastname")
    private String billingLastname;
    @JsonProperty("billing_address")
    private String billingAddress;
    @JsonProperty("billing_address_city")
    private String billingAddressCity;
    @JsonProperty("billing_address_region")
    private String billingAddressRegion;
    @JsonProperty("billing_address_state")
    private String billingAddressState;
    @JsonProperty("billing_address_poscode")
    private String billingAddressPoscode;
    @JsonProperty("billing_msisdn")
    private String billingMsisdn;
    @JsonProperty("billing_address_country_code")
    private String billingAddressCountryCode;
    @JsonProperty("receiver_name_for_shipping")
    private String receiverNameForShipping;
    @JsonProperty("shipping_lastname")
    private String shippingLastname;
    @JsonProperty("shipping_address")
    private String shippingAddress;
    @JsonProperty("shipping_address_city")
    private String shippingAddressCity;
    @JsonProperty("shipping_address_region")
    private String shippingAddressRegion;
    @JsonProperty("shipping_address_state")
    private String shippingAddressState;
    @JsonProperty("shipping_address_poscode")
    private String shippingAddressPoscode;
    @JsonProperty("shipping_msisdn")
    private String shippingMsisdn;
    @JsonProperty("shipping_address_country_code")
    private String shippingAddressCountryCode;
    @JsonProperty("item")
    private List<FaspayPayment> item = new ArrayList<FaspayPayment>();
    @JsonProperty("reserve1")
    private String reserve1;
    @JsonProperty("reserve2")
    private String reserve2;
    @JsonProperty("signature")
    private String signature;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public FaspayPaymentRequest() {
    }

  
    @JsonProperty("request")
    public String getRequest() {
        return request;
    }

    @JsonProperty("request")
    public void setRequest(String request) {
        this.request = request;
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

    @JsonProperty("bill_reff")
    public String getBillReff() {
        return billReff;
    }

    @JsonProperty("bill_reff")
    public void setBillReff(String billReff) {
        this.billReff = billReff;
    }

    @JsonProperty("bill_date")
    public String getBillDate() {
        return billDate;
    }

    @JsonProperty("bill_date")
    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    @JsonProperty("bill_tax")
    public String getBillTax() {
        return billTax;
    }

    @JsonProperty("bill_tax")
    public void setBillTax(String billTax) {
        this.billTax = billTax;
    }

    @JsonProperty("bill_expired")
    public String getBillExpired() {
        return billExpired;
    }

    @JsonProperty("bill_expired")
    public void setBillExpired(String billExpired) {
        this.billExpired = billExpired;
    }

    @JsonProperty("bill_desc")
    public String getBillDesc() {
        return billDesc;
    }

    @JsonProperty("bill_desc")
    public void setBillDesc(String billDesc) {
        this.billDesc = billDesc;
    }

    @JsonProperty("bill_currency")
    public String getBillCurrency() {
        return billCurrency;
    }

    @JsonProperty("bill_currency")
    public void setBillCurrency(String billCurrency) {
        this.billCurrency = billCurrency;
    }

    @JsonProperty("bill_gross")
    public String getBillGross() {
        return billGross;
    }

    @JsonProperty("bill_gross")
    public void setBillGross(String billGross) {
        this.billGross = billGross;
    }

    @JsonProperty("bill_miscfee")
    public String getBillMiscfee() {
        return billMiscfee;
    }

    @JsonProperty("bill_miscfee")
    public void setBillMiscfee(String billMiscfee) {
        this.billMiscfee = billMiscfee;
    }

    @JsonProperty("bill_total")
    public String getBillTotal() {
        return billTotal;
    }

    @JsonProperty("bill_total")
    public void setBillTotal(String billTotal) {
        this.billTotal = billTotal;
    }

    @JsonProperty("cust_no")
    public String getCustNo() {
        return custNo;
    }

    @JsonProperty("cust_no")
    public void setCustNo(String custNo) {
        this.custNo = custNo;
    }

    @JsonProperty("cust_name")
    public String getCustName() {
        return custName;
    }

    @JsonProperty("cust_name")
    public void setCustName(String custName) {
        this.custName = custName;
    }

    @JsonProperty("payment_channel")
    public String getPaymentChannel() {
        return paymentChannel;
    }

    @JsonProperty("payment_channel")
    public void setPaymentChannel(String paymentChannel) {
        this.paymentChannel = paymentChannel;
    }

    @JsonProperty("pay_type")
    public String getPayType() {
        return payType;
    }

    @JsonProperty("pay_type")
    public void setPayType(String payType) {
        this.payType = payType;
    }

    @JsonProperty("bank_userid")
    public String getBankUserid() {
        return bankUserid;
    }

    @JsonProperty("bank_userid")
    public void setBankUserid(String bankUserid) {
        this.bankUserid = bankUserid;
    }

    @JsonProperty("msisdn")
    public String getMsisdn() {
        return msisdn;
    }

    @JsonProperty("msisdn")
    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("terminal")
    public String getTerminal() {
        return terminal;
    }

    @JsonProperty("terminal")
    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    @JsonProperty("billing_name")
    public String getBillingName() {
        return billingName;
    }

    @JsonProperty("billing_name")
    public void setBillingName(String billingName) {
        this.billingName = billingName;
    }

    @JsonProperty("billing_lastname")
    public String getBillingLastname() {
        return billingLastname;
    }

    @JsonProperty("billing_lastname")
    public void setBillingLastname(String billingLastname) {
        this.billingLastname = billingLastname;
    }

    @JsonProperty("billing_address")
    public String getBillingAddress() {
        return billingAddress;
    }

    @JsonProperty("billing_address")
    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    @JsonProperty("billing_address_city")
    public String getBillingAddressCity() {
        return billingAddressCity;
    }

    @JsonProperty("billing_address_city")
    public void setBillingAddressCity(String billingAddressCity) {
        this.billingAddressCity = billingAddressCity;
    }

    @JsonProperty("billing_address_region")
    public String getBillingAddressRegion() {
        return billingAddressRegion;
    }

    @JsonProperty("billing_address_region")
    public void setBillingAddressRegion(String billingAddressRegion) {
        this.billingAddressRegion = billingAddressRegion;
    }

    @JsonProperty("billing_address_state")
    public String getBillingAddressState() {
        return billingAddressState;
    }

    @JsonProperty("billing_address_state")
    public void setBillingAddressState(String billingAddressState) {
        this.billingAddressState = billingAddressState;
    }

    @JsonProperty("billing_address_poscode")
    public String getBillingAddressPoscode() {
        return billingAddressPoscode;
    }

    @JsonProperty("billing_address_poscode")
    public void setBillingAddressPoscode(String billingAddressPoscode) {
        this.billingAddressPoscode = billingAddressPoscode;
    }

    @JsonProperty("billing_msisdn")
    public String getBillingMsisdn() {
        return billingMsisdn;
    }

    @JsonProperty("billing_msisdn")
    public void setBillingMsisdn(String billingMsisdn) {
        this.billingMsisdn = billingMsisdn;
    }

    @JsonProperty("billing_address_country_code")
    public String getBillingAddressCountryCode() {
        return billingAddressCountryCode;
    }

    @JsonProperty("billing_address_country_code")
    public void setBillingAddressCountryCode(String billingAddressCountryCode) {
        this.billingAddressCountryCode = billingAddressCountryCode;
    }

    @JsonProperty("receiver_name_for_shipping")
    public String getReceiverNameForShipping() {
        return receiverNameForShipping;
    }

    @JsonProperty("receiver_name_for_shipping")
    public void setReceiverNameForShipping(String receiverNameForShipping) {
        this.receiverNameForShipping = receiverNameForShipping;
    }

    @JsonProperty("shipping_lastname")
    public String getShippingLastname() {
        return shippingLastname;
    }

    @JsonProperty("shipping_lastname")
    public void setShippingLastname(String shippingLastname) {
        this.shippingLastname = shippingLastname;
    }

    @JsonProperty("shipping_address")
    public String getShippingAddress() {
        return shippingAddress;
    }

    @JsonProperty("shipping_address")
    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    @JsonProperty("shipping_address_city")
    public String getShippingAddressCity() {
        return shippingAddressCity;
    }

    @JsonProperty("shipping_address_city")
    public void setShippingAddressCity(String shippingAddressCity) {
        this.shippingAddressCity = shippingAddressCity;
    }

    @JsonProperty("shipping_address_region")
    public String getShippingAddressRegion() {
        return shippingAddressRegion;
    }

    @JsonProperty("shipping_address_region")
    public void setShippingAddressRegion(String shippingAddressRegion) {
        this.shippingAddressRegion = shippingAddressRegion;
    }

    @JsonProperty("shipping_address_state")
    public String getShippingAddressState() {
        return shippingAddressState;
    }

    @JsonProperty("shipping_address_state")
    public void setShippingAddressState(String shippingAddressState) {
        this.shippingAddressState = shippingAddressState;
    }

    @JsonProperty("shipping_address_poscode")
    public String getShippingAddressPoscode() {
        return shippingAddressPoscode;
    }

    @JsonProperty("shipping_address_poscode")
    public void setShippingAddressPoscode(String shippingAddressPoscode) {
        this.shippingAddressPoscode = shippingAddressPoscode;
    }

    @JsonProperty("shipping_msisdn")
    public String getShippingMsisdn() {
        return shippingMsisdn;
    }

    @JsonProperty("shipping_msisdn")
    public void setShippingMsisdn(String shippingMsisdn) {
        this.shippingMsisdn = shippingMsisdn;
    }

    @JsonProperty("shipping_address_country_code")
    public String getShippingAddressCountryCode() {
        return shippingAddressCountryCode;
    }

    @JsonProperty("shipping_address_country_code")
    public void setShippingAddressCountryCode(String shippingAddressCountryCode) {
        this.shippingAddressCountryCode = shippingAddressCountryCode;
    }

    @JsonProperty("item")
    public List<FaspayPayment> getItem() {
        return item;
    }

    @JsonProperty("item")
    public void setItem(List<FaspayPayment> item) {
        this.item = item;
    }

    @JsonProperty("reserve1")
    public String getReserve1() {
        return reserve1;
    }

    @JsonProperty("reserve1")
    public void setReserve1(String reserve1) {
        this.reserve1 = reserve1;
    }

    @JsonProperty("reserve2")
    public String getReserve2() {
        return reserve2;
    }

    @JsonProperty("reserve2")
    public void setReserve2(String reserve2) {
        this.reserve2 = reserve2;
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
