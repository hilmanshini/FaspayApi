/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faspayapi.debit.entity.request_bill;

import com.fasterxml.jackson.annotation.JsonProperty;
import faspayapi.debit.entity.FaspayPayment;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author hilmananwarsah
 */
public class FaspayPaymentRequestBillData {
    
    @JsonProperty("bill_no")
    private String billNo = "";
    @JsonProperty("bill_reff")
    private String billReff = "";
    @JsonProperty("bill_date")
    private String billDate = "";
    @JsonProperty("bill_expired")
    private String billExpired = "";
    @JsonProperty("bill_desc")
    private String billDesc = "";
    @JsonProperty("bill_currency")
    private String billCurrency = "IDR";
    @JsonProperty("bill_gross")
    private String billGross = "";
    @JsonProperty("bill_tax")
    private String billTax = "";
    
    @JsonProperty("bill_miscfee")
    private String billMiscfee = "";
    @JsonProperty("bill_total")
    private String billTotal = "";
    
    @JsonProperty("billing_name")
    private String billingName = "";
    @JsonProperty("billing_lastname")
    private String billingLastname = "";
    @JsonProperty("billing_address")
    private String billingAddress = "";
    @JsonProperty("billing_address_city")
    private String billingAddressCity = "";
    @JsonProperty("billing_address_region")
    private String billingAddressRegion = "";
    @JsonProperty("billing_address_state")
    private String billingAddressState = "";
    @JsonProperty("billing_address_poscode")
    private String billingAddressPoscode = "";
    @JsonProperty("billing_msisdn")
    private String billingMsisdn = "";
        @JsonProperty("billing_address_country_code")
    private String billingAddressCountryCode = "";
    
    @JsonProperty("item")
    private List<FaspayPayment> item = new ArrayList<FaspayPayment>();
    
    public FaspayPaymentRequestBillData(String billDesc, String billDate, String billExpired, String billTotal, List<FaspayPayment> item) {
        setBillDesc(billDesc);
        setBillDate(billDate);
        setBillExpired(billExpired);
        setBillTotal(billTotal);
        setItem(item);
    }
    
    public FaspayPaymentRequestBillData(String billNo,String billDesc, int expired_day_interval, String billTotal,List<FaspayPayment> item,String pay_type) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DAY_OF_MONTH, expired_day_interval);
        setBillNo(billNo);
        setBillDesc(billDesc);
        setBillDate(sdf.format(new Date()));
        setBillExpired(sdf.format(cal.getTime()));
        setBillTotal(billTotal);
        setItem(item);
        setPay_type(Integer.valueOf(pay_type));
        
    }
    
    public FaspayPaymentRequestBillData(String billNo,String billDesc, int expired_day_interval, String billTotal,List<FaspayPayment> item) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DAY_OF_MONTH, expired_day_interval);
        setBillNo(billNo);
        setBillDesc(billDesc);
        setBillDate(sdf.format(new Date()));
        setBillExpired(sdf.format(cal.getTime()));
        setBillTotal(billTotal);
        setItem(item);
        
    }
    
    public List<FaspayPayment> getItem() {
        return item;
    }
    
    int pay_type;
    
    public void setItem(List<FaspayPayment> item) {
        this.item = item;
    }
    
    public String getBillNo() {
        return billNo;
    }
    
    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }
    
    public String getBillReff() {
        return billReff;
    }
    
    public void setBillReff(String billReff) {
        this.billReff = billReff;
    }
    
    public String getBillDate() {
        return billDate;
    }
    
    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }
    
    public String getBillExpired() {
        return billExpired;
    }
    
    public void setBillExpired(String billExpired) {
        this.billExpired = billExpired;
    }
    
    public String getBillDesc() {
        return billDesc;
    }
    
    public void setBillDesc(String billDesc) {
        this.billDesc = billDesc;
    }
    
    public String getBillCurrency() {
        return billCurrency;
    }
    
    public void setBillCurrency(String billCurrency) {
        this.billCurrency = billCurrency;
    }
    
    public String getBillGross() {
        return billGross;
    }
    
    public void setBillGross(String billGross) {
        this.billGross = billGross;
    }
    
    public String getBillMiscfee() {
        return billMiscfee;
    }
    
    public int getPay_type() {
        return pay_type;
    }
    
    public void setPay_type(int pay_type) {
        this.pay_type = pay_type;
    }
    
    public void setBillMiscfee(String billMiscfee) {
        this.billMiscfee = billMiscfee;
    }
    
    public String getBillTotal() {
        return billTotal;
    }
    
    public void setBillTotal(String billTotal) {
        this.billTotal = billTotal;
    }
    
    public String getBillingName() {
        return billingName;
    }
    
    public void setBillingName(String billingName) {
        this.billingName = billingName;
    }
    
    public String getBillingLastname() {
        return billingLastname;
    }
    
    public void setBillingLastname(String billingLastname) {
        this.billingLastname = billingLastname;
    }
    
    public String getBillingAddress() {
        return billingAddress;
    }
    
    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }
    
    public String getBillingAddressCity() {
        return billingAddressCity;
    }
    
    public void setBillingAddressCity(String billingAddressCity) {
        this.billingAddressCity = billingAddressCity;
    }
    
    public String getBillingAddressRegion() {
        return billingAddressRegion;
    }
    
    public void setBillingAddressRegion(String billingAddressRegion) {
        this.billingAddressRegion = billingAddressRegion;
    }
    
    public String getBillingAddressState() {
        return billingAddressState;
    }
    
    public void setBillingAddressState(String billingAddressState) {
        this.billingAddressState = billingAddressState;
    }
    
    public String getBillingAddressPoscode() {
        return billingAddressPoscode;
    }
    
    public void setBillingAddressPoscode(String billingAddressPoscode) {
        this.billingAddressPoscode = billingAddressPoscode;
    }
    
    public String getBillingMsisdn() {
        return billingMsisdn;
    }
    
    public void setBillingMsisdn(String billingMsisdn) {
        this.billingMsisdn = billingMsisdn;
    }
    
    public String getBillingAddressCountryCode() {
        return billingAddressCountryCode;
    }
    
    public void setBillingAddressCountryCode(String billingAddressCountryCode) {
        this.billingAddressCountryCode = billingAddressCountryCode;
    }
    
    public String getBillTax() {
        return billTax;
    }
    
    public void setBillTax(String billTax) {
        this.billTax = billTax;
    }
    
}
