/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faspayapi.credit.entity.inquiry;

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
    "POINT_AMOUNT",
    "MERCHANT_TRANID",
    "BANK_RES_MSG",
    "BANK_RES_CODE",
    "POINT_USED",
    "TXN_STATUS",
    "SIGNATURE",
    "ERR_CODE",
    "AUTH_ID",
    "DESCRIPTION",
    "AMOUNT",
    "TRANSACTIONTYPE",
    "CUSTNAME",
    "POINT_BALANCE",
    "MERCHANTID",
    "PAYMENT_METHOD",
    "TRANSACTIONID",
    "TRANDATE",
    "CURRENCYCODE",
    "BANK_REFERENCE",
    "popupProceed",
    "ERR_DESC",
    "PAYMENT_AMOUNT",
    "TOTAL_REFUND_AMOUNT",
    "WHITELIST_CARD"
})
public class InquiryResponseCredit {

    @JsonProperty("POINT_AMOUNT")
    private String pOINTAMOUNT;
    @JsonProperty("MERCHANT_TRANID")
    private String mERCHANTTRANID;
    @JsonProperty("BANK_RES_MSG")
    private String bANKRESMSG;
    @JsonProperty("BANK_RES_CODE")
    private String bANKRESCODE;
    @JsonProperty("POINT_USED")
    private String pOINTUSED;
    @JsonProperty("TXN_STATUS")
    private String tXNSTATUS;
    @JsonProperty("SIGNATURE")
    private String sIGNATURE;
    @JsonProperty("ERR_CODE")
    private String eRRCODE;
    @JsonProperty("AUTH_ID")
    private String aUTHID;
    @JsonProperty("DESCRIPTION")
    private String dESCRIPTION;
    @JsonProperty("AMOUNT")
    private String aMOUNT;
    @JsonProperty("TRANSACTIONTYPE")
    private String tRANSACTIONTYPE;
    @JsonProperty("CUSTNAME")
    private String cUSTNAME;
    @JsonProperty("POINT_BALANCE")
    private String pOINTBALANCE;
    @JsonProperty("MERCHANTID")
    private String mERCHANTID;
    @JsonProperty("PAYMENT_METHOD")
    private String pAYMENTMETHOD;
    @JsonProperty("TRANSACTIONID")
    private String tRANSACTIONID;
    @JsonProperty("TRANDATE")
    private String tRANDATE;
    @JsonProperty("CURRENCYCODE")
    private String cURRENCYCODE;
    @JsonProperty("BANK_REFERENCE")
    private String bANKREFERENCE;
    @JsonProperty("popupProceed")
    private String popupProceed;
    @JsonProperty("ERR_DESC")
    private String eRRDESC;
    @JsonProperty("PAYMENT_AMOUNT")
    private String pAYMENTAMOUNT;
    @JsonProperty("TOTAL_REFUND_AMOUNT")
    private String tOTALREFUNDAMOUNT;
    @JsonProperty("WHITELIST_CARD")
    private String wHITELISTCARD;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("POINT_AMOUNT")
    public String getPOINTAMOUNT() {
        return pOINTAMOUNT;
    }

    @JsonProperty("POINT_AMOUNT")
    public void setPOINTAMOUNT(String pOINTAMOUNT) {
        this.pOINTAMOUNT = pOINTAMOUNT;
    }

    @JsonProperty("MERCHANT_TRANID")
    public String getMERCHANTTRANID() {
        return mERCHANTTRANID;
    }

    @JsonProperty("MERCHANT_TRANID")
    public void setMERCHANTTRANID(String mERCHANTTRANID) {
        this.mERCHANTTRANID = mERCHANTTRANID;
    }

    @JsonProperty("BANK_RES_MSG")
    public String getBANKRESMSG() {
        return bANKRESMSG;
    }

    @JsonProperty("BANK_RES_MSG")
    public void setBANKRESMSG(String bANKRESMSG) {
        this.bANKRESMSG = bANKRESMSG;
    }

    @JsonProperty("BANK_RES_CODE")
    public String getBANKRESCODE() {
        return bANKRESCODE;
    }

    @JsonProperty("BANK_RES_CODE")
    public void setBANKRESCODE(String bANKRESCODE) {
        this.bANKRESCODE = bANKRESCODE;
    }

    @JsonProperty("POINT_USED")
    public String getPOINTUSED() {
        return pOINTUSED;
    }

    @JsonProperty("POINT_USED")
    public void setPOINTUSED(String pOINTUSED) {
        this.pOINTUSED = pOINTUSED;
    }

    @JsonProperty("TXN_STATUS")
    public String getTXNSTATUS() {
        return tXNSTATUS;
    }

    @JsonProperty("TXN_STATUS")
    public void setTXNSTATUS(String tXNSTATUS) {
        this.tXNSTATUS = tXNSTATUS;
    }

    @JsonProperty("SIGNATURE")
    public String getSIGNATURE() {
        return sIGNATURE;
    }

    @JsonProperty("SIGNATURE")
    public void setSIGNATURE(String sIGNATURE) {
        this.sIGNATURE = sIGNATURE;
    }

    @JsonProperty("ERR_CODE")
    public String getERRCODE() {
        return eRRCODE;
    }

    @JsonProperty("ERR_CODE")
    public void setERRCODE(String eRRCODE) {
        this.eRRCODE = eRRCODE;
    }

    @JsonProperty("AUTH_ID")
    public String getAUTHID() {
        return aUTHID;
    }

    @JsonProperty("AUTH_ID")
    public void setAUTHID(String aUTHID) {
        this.aUTHID = aUTHID;
    }

    @JsonProperty("DESCRIPTION")
    public String getDESCRIPTION() {
        return dESCRIPTION;
    }

    @JsonProperty("DESCRIPTION")
    public void setDESCRIPTION(String dESCRIPTION) {
        this.dESCRIPTION = dESCRIPTION;
    }

    @JsonProperty("AMOUNT")
    public String getAMOUNT() {
        return aMOUNT;
    }

    @JsonProperty("AMOUNT")
    public void setAMOUNT(String aMOUNT) {
        this.aMOUNT = aMOUNT;
    }

    @JsonProperty("TRANSACTIONTYPE")
    public String getTRANSACTIONTYPE() {
        return tRANSACTIONTYPE;
    }

    @JsonProperty("TRANSACTIONTYPE")
    public void setTRANSACTIONTYPE(String tRANSACTIONTYPE) {
        this.tRANSACTIONTYPE = tRANSACTIONTYPE;
    }

    @JsonProperty("CUSTNAME")
    public String getCUSTNAME() {
        return cUSTNAME;
    }

    @JsonProperty("CUSTNAME")
    public void setCUSTNAME(String cUSTNAME) {
        this.cUSTNAME = cUSTNAME;
    }

    @JsonProperty("POINT_BALANCE")
    public String getPOINTBALANCE() {
        return pOINTBALANCE;
    }

    @JsonProperty("POINT_BALANCE")
    public void setPOINTBALANCE(String pOINTBALANCE) {
        this.pOINTBALANCE = pOINTBALANCE;
    }

    @JsonProperty("MERCHANTID")
    public String getMERCHANTID() {
        return mERCHANTID;
    }

    @JsonProperty("MERCHANTID")
    public void setMERCHANTID(String mERCHANTID) {
        this.mERCHANTID = mERCHANTID;
    }

    @JsonProperty("PAYMENT_METHOD")
    public String getPAYMENTMETHOD() {
        return pAYMENTMETHOD;
    }

    @JsonProperty("PAYMENT_METHOD")
    public void setPAYMENTMETHOD(String pAYMENTMETHOD) {
        this.pAYMENTMETHOD = pAYMENTMETHOD;
    }

    @JsonProperty("TRANSACTIONID")
    public String getTRANSACTIONID() {
        return tRANSACTIONID;
    }

    @JsonProperty("TRANSACTIONID")
    public void setTRANSACTIONID(String tRANSACTIONID) {
        this.tRANSACTIONID = tRANSACTIONID;
    }

    @JsonProperty("TRANDATE")
    public String getTRANDATE() {
        return tRANDATE;
    }

    @JsonProperty("TRANDATE")
    public void setTRANDATE(String tRANDATE) {
        this.tRANDATE = tRANDATE;
    }

    @JsonProperty("CURRENCYCODE")
    public String getCURRENCYCODE() {
        return cURRENCYCODE;
    }

    @JsonProperty("CURRENCYCODE")
    public void setCURRENCYCODE(String cURRENCYCODE) {
        this.cURRENCYCODE = cURRENCYCODE;
    }

    @JsonProperty("BANK_REFERENCE")
    public String getBANKREFERENCE() {
        return bANKREFERENCE;
    }

    @JsonProperty("BANK_REFERENCE")
    public void setBANKREFERENCE(String bANKREFERENCE) {
        this.bANKREFERENCE = bANKREFERENCE;
    }

    @JsonProperty("popupProceed")
    public String getPopupProceed() {
        return popupProceed;
    }

    @JsonProperty("popupProceed")
    public void setPopupProceed(String popupProceed) {
        this.popupProceed = popupProceed;
    }

    @JsonProperty("ERR_DESC")
    public String getERRDESC() {
        return eRRDESC;
    }

    @JsonProperty("ERR_DESC")
    public void setERRDESC(String eRRDESC) {
        this.eRRDESC = eRRDESC;
    }

    @JsonProperty("PAYMENT_AMOUNT")
    public String getPAYMENTAMOUNT() {
        return pAYMENTAMOUNT;
    }

    @JsonProperty("PAYMENT_AMOUNT")
    public void setPAYMENTAMOUNT(String pAYMENTAMOUNT) {
        this.pAYMENTAMOUNT = pAYMENTAMOUNT;
    }

    @JsonProperty("TOTAL_REFUND_AMOUNT")
    public String getTOTALREFUNDAMOUNT() {
        return tOTALREFUNDAMOUNT;
    }

    @JsonProperty("TOTAL_REFUND_AMOUNT")
    public void setTOTALREFUNDAMOUNT(String tOTALREFUNDAMOUNT) {
        this.tOTALREFUNDAMOUNT = tOTALREFUNDAMOUNT;
    }

    @JsonProperty("WHITELIST_CARD")
    public String getWHITELISTCARD() {
        return wHITELISTCARD;
    }

    @JsonProperty("WHITELIST_CARD")
    public void setWHITELISTCARD(String wHITELISTCARD) {
        this.wHITELISTCARD = wHITELISTCARD;
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
