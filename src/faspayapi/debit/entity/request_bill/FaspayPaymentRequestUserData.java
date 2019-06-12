/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faspayapi.debit.entity.request_bill;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author hilmananwarsah
 */
public class FaspayPaymentRequestUserData {
    @JsonProperty("bank_userid")
    private String bankUserid = "";
    @JsonProperty("msisdn")
    private String msisdn;
    @JsonProperty("email")
    private String email;
    @JsonProperty("terminal")
    private String terminal;
    
    String custNo;
    String custName;

    public FaspayPaymentRequestUserData(String msisdn, String email, String terminal, String custNo, String custName) {
        this.msisdn = msisdn;
        this.email = email;
        this.terminal = terminal;
        this.custNo = custNo;
        this.custName = custName;
    }

    public FaspayPaymentRequestUserData() {
    }
    
    

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }
    

    public String getBankUserid() {
        return bankUserid;
    }

    public void setBankUserid(String bankUserid) {
        this.bankUserid = bankUserid;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }
    
    
    
}
