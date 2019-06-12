package faspayapi.debit.entity.notify;

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
    "PAYMENT_METHOD",
    "MERCHANTID",
    "MERCHANT_TRANID",
    "ERR_CODE",
    "ERR_DESC",
    "USR_CODE",
    "USR_MSG",
    "TXN_STATUS",
    "CUSTNAME",
    "DESCRIPTION",
    "CURRENCYCODE",
    "AMOUNT",
    "SIGNATURE",
    "TRANSACTIONID",
    "TRANSACTIONTYPE",
    "MPARAM1",
    "MPARAM2",
    "ACQUIRER_BANK",
    "TRANDATE",
    "IS_BLACKLISTED",
    "FRAUDRISKLEVEL",
    "FRAUDRISKSCORE",
    "FRAUD_STATUS",
    "ECI",
    "POINT_USED",
    "POINT_AMOUNT",
    "PAYMENT_AMOUNT",
    "POINT_BALANCE",
    "EXCEED_HIGH_RISK",
    "CARDTYPE",
    "CARD_NO_PARTIAL",
    "CARDNAME",
    "is_on_us",
    "WHITELIST_CARD",
    "BANK_RES_CODE",
    "BANK_RES_MSG",
    "AUTH_ID",
    "BANK_REFERENCE",
    "INSTALLMENT_MONTHLY",
    "INSTALLMENT_LAST",
    "popupProceed"
})
public class NotifyResponse {

    @JsonProperty("PAYMENT_METHOD")
    private String pAYMENTMETHOD;
    @JsonProperty("MERCHANTID")
    private String mERCHANTID;
    @JsonProperty("MERCHANT_TRANID")
    private String mERCHANTTRANID;
    @JsonProperty("ERR_CODE")
    private String eRRCODE;
    @JsonProperty("ERR_DESC")
    private String eRRDESC;
    @JsonProperty("USR_CODE")
    private String uSRCODE;
    @JsonProperty("USR_MSG")
    private String uSRMSG;
    @JsonProperty("TXN_STATUS")
    private String tXNSTATUS;
    @JsonProperty("CUSTNAME")
    private String cUSTNAME;
    @JsonProperty("DESCRIPTION")
    private String dESCRIPTION;
    @JsonProperty("CURRENCYCODE")
    private String cURRENCYCODE;
    @JsonProperty("AMOUNT")
    private String aMOUNT;
    @JsonProperty("SIGNATURE")
    private String sIGNATURE;
    @JsonProperty("TRANSACTIONID")
    private String tRANSACTIONID;
    @JsonProperty("TRANSACTIONTYPE")
    private String tRANSACTIONTYPE;
    @JsonProperty("MPARAM1")
    private Object mPARAM1;
    @JsonProperty("MPARAM2")
    private Object mPARAM2;
    @JsonProperty("ACQUIRER_BANK")
    private String aCQUIRERBANK;
    @JsonProperty("TRANDATE")
    private String tRANDATE;
    @JsonProperty("IS_BLACKLISTED")
    private String iSBLACKLISTED;
    @JsonProperty("FRAUDRISKLEVEL")
    private String fRAUDRISKLEVEL;
    @JsonProperty("FRAUDRISKSCORE")
    private String fRAUDRISKSCORE;
    @JsonProperty("FRAUD_STATUS")
    private String fRAUDSTATUS;
    @JsonProperty("ECI")
    private String eCI;
    @JsonProperty("POINT_USED")
    private String pOINTUSED;
    @JsonProperty("POINT_AMOUNT")
    private String pOINTAMOUNT;
    @JsonProperty("PAYMENT_AMOUNT")
    private String pAYMENTAMOUNT;
    @JsonProperty("POINT_BALANCE")
    private String pOINTBALANCE;
    @JsonProperty("EXCEED_HIGH_RISK")
    private String eXCEEDHIGHRISK;
    @JsonProperty("CARDTYPE")
    private String cARDTYPE;
    @JsonProperty("CARD_NO_PARTIAL")
    private String cARDNOPARTIAL;
    @JsonProperty("CARDNAME")
    private String cARDNAME;
    @JsonProperty("is_on_us")
    private String isOnUs;
    @JsonProperty("WHITELIST_CARD")
    private String wHITELISTCARD;
    @JsonProperty("BANK_RES_CODE")
    private String bANKRESCODE;
    @JsonProperty("BANK_RES_MSG")
    private String bANKRESMSG;
    @JsonProperty("AUTH_ID")
    private String aUTHID;
    @JsonProperty("BANK_REFERENCE")
    private String bANKREFERENCE;
    @JsonProperty("INSTALLMENT_MONTHLY")
    private String iNSTALLMENTMONTHLY;
    @JsonProperty("INSTALLMENT_LAST")
    private String iNSTALLMENTLAST;
    @JsonProperty("popupProceed")
    private String popupProceed;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("PAYMENT_METHOD")
    public String getPAYMENTMETHOD() {
        return pAYMENTMETHOD;
    }

    @JsonProperty("PAYMENT_METHOD")
    public void setPAYMENTMETHOD(String pAYMENTMETHOD) {
        this.pAYMENTMETHOD = pAYMENTMETHOD;
    }

    @JsonProperty("MERCHANTID")
    public String getMERCHANTID() {
        return mERCHANTID;
    }

    @JsonProperty("MERCHANTID")
    public void setMERCHANTID(String mERCHANTID) {
        this.mERCHANTID = mERCHANTID;
    }

    @JsonProperty("MERCHANT_TRANID")
    public String getMERCHANTTRANID() {
        return mERCHANTTRANID;
    }

    @JsonProperty("MERCHANT_TRANID")
    public void setMERCHANTTRANID(String mERCHANTTRANID) {
        this.mERCHANTTRANID = mERCHANTTRANID;
    }

    @JsonProperty("ERR_CODE")
    public String getERRCODE() {
        return eRRCODE;
    }

    @JsonProperty("ERR_CODE")
    public void setERRCODE(String eRRCODE) {
        this.eRRCODE = eRRCODE;
    }

    @JsonProperty("ERR_DESC")
    public String getERRDESC() {
        return eRRDESC;
    }

    @JsonProperty("ERR_DESC")
    public void setERRDESC(String eRRDESC) {
        this.eRRDESC = eRRDESC;
    }

    @JsonProperty("USR_CODE")
    public String getUSRCODE() {
        return uSRCODE;
    }

    @JsonProperty("USR_CODE")
    public void setUSRCODE(String uSRCODE) {
        this.uSRCODE = uSRCODE;
    }

    @JsonProperty("USR_MSG")
    public String getUSRMSG() {
        return uSRMSG;
    }

    @JsonProperty("USR_MSG")
    public void setUSRMSG(String uSRMSG) {
        this.uSRMSG = uSRMSG;
    }

    @JsonProperty("TXN_STATUS")
    public String getTXNSTATUS() {
        return tXNSTATUS;
    }

    @JsonProperty("TXN_STATUS")
    public void setTXNSTATUS(String tXNSTATUS) {
        this.tXNSTATUS = tXNSTATUS;
    }

    @JsonProperty("CUSTNAME")
    public String getCUSTNAME() {
        return cUSTNAME;
    }

    @JsonProperty("CUSTNAME")
    public void setCUSTNAME(String cUSTNAME) {
        this.cUSTNAME = cUSTNAME;
    }

    @JsonProperty("DESCRIPTION")
    public String getDESCRIPTION() {
        return dESCRIPTION;
    }

    @JsonProperty("DESCRIPTION")
    public void setDESCRIPTION(String dESCRIPTION) {
        this.dESCRIPTION = dESCRIPTION;
    }

    @JsonProperty("CURRENCYCODE")
    public String getCURRENCYCODE() {
        return cURRENCYCODE;
    }

    @JsonProperty("CURRENCYCODE")
    public void setCURRENCYCODE(String cURRENCYCODE) {
        this.cURRENCYCODE = cURRENCYCODE;
    }

    @JsonProperty("AMOUNT")
    public String getAMOUNT() {
        return aMOUNT;
    }

    @JsonProperty("AMOUNT")
    public void setAMOUNT(String aMOUNT) {
        this.aMOUNT = aMOUNT;
    }

    @JsonProperty("SIGNATURE")
    public String getSIGNATURE() {
        return sIGNATURE;
    }

    @JsonProperty("SIGNATURE")
    public void setSIGNATURE(String sIGNATURE) {
        this.sIGNATURE = sIGNATURE;
    }

    @JsonProperty("TRANSACTIONID")
    public String getTRANSACTIONID() {
        return tRANSACTIONID;
    }

    @JsonProperty("TRANSACTIONID")
    public void setTRANSACTIONID(String tRANSACTIONID) {
        this.tRANSACTIONID = tRANSACTIONID;
    }

    @JsonProperty("TRANSACTIONTYPE")
    public String getTRANSACTIONTYPE() {
        return tRANSACTIONTYPE;
    }

    @JsonProperty("TRANSACTIONTYPE")
    public void setTRANSACTIONTYPE(String tRANSACTIONTYPE) {
        this.tRANSACTIONTYPE = tRANSACTIONTYPE;
    }

    @JsonProperty("MPARAM1")
    public Object getMPARAM1() {
        return mPARAM1;
    }

    @JsonProperty("MPARAM1")
    public void setMPARAM1(Object mPARAM1) {
        this.mPARAM1 = mPARAM1;
    }

    @JsonProperty("MPARAM2")
    public Object getMPARAM2() {
        return mPARAM2;
    }

    @JsonProperty("MPARAM2")
    public void setMPARAM2(Object mPARAM2) {
        this.mPARAM2 = mPARAM2;
    }

    @JsonProperty("ACQUIRER_BANK")
    public String getACQUIRERBANK() {
        return aCQUIRERBANK;
    }

    @JsonProperty("ACQUIRER_BANK")
    public void setACQUIRERBANK(String aCQUIRERBANK) {
        this.aCQUIRERBANK = aCQUIRERBANK;
    }

    @JsonProperty("TRANDATE")
    public String getTRANDATE() {
        return tRANDATE;
    }

    @JsonProperty("TRANDATE")
    public void setTRANDATE(String tRANDATE) {
        this.tRANDATE = tRANDATE;
    }

    @JsonProperty("IS_BLACKLISTED")
    public String getISBLACKLISTED() {
        return iSBLACKLISTED;
    }

    @JsonProperty("IS_BLACKLISTED")
    public void setISBLACKLISTED(String iSBLACKLISTED) {
        this.iSBLACKLISTED = iSBLACKLISTED;
    }

    @JsonProperty("FRAUDRISKLEVEL")
    public String getFRAUDRISKLEVEL() {
        return fRAUDRISKLEVEL;
    }

    @JsonProperty("FRAUDRISKLEVEL")
    public void setFRAUDRISKLEVEL(String fRAUDRISKLEVEL) {
        this.fRAUDRISKLEVEL = fRAUDRISKLEVEL;
    }

    @JsonProperty("FRAUDRISKSCORE")
    public String getFRAUDRISKSCORE() {
        return fRAUDRISKSCORE;
    }

    @JsonProperty("FRAUDRISKSCORE")
    public void setFRAUDRISKSCORE(String fRAUDRISKSCORE) {
        this.fRAUDRISKSCORE = fRAUDRISKSCORE;
    }

    @JsonProperty("FRAUD_STATUS")
    public String getFRAUDSTATUS() {
        return fRAUDSTATUS;
    }

    @JsonProperty("FRAUD_STATUS")
    public void setFRAUDSTATUS(String fRAUDSTATUS) {
        this.fRAUDSTATUS = fRAUDSTATUS;
    }

    @JsonProperty("ECI")
    public String getECI() {
        return eCI;
    }

    @JsonProperty("ECI")
    public void setECI(String eCI) {
        this.eCI = eCI;
    }

    @JsonProperty("POINT_USED")
    public String getPOINTUSED() {
        return pOINTUSED;
    }

    @JsonProperty("POINT_USED")
    public void setPOINTUSED(String pOINTUSED) {
        this.pOINTUSED = pOINTUSED;
    }

    @JsonProperty("POINT_AMOUNT")
    public String getPOINTAMOUNT() {
        return pOINTAMOUNT;
    }

    @JsonProperty("POINT_AMOUNT")
    public void setPOINTAMOUNT(String pOINTAMOUNT) {
        this.pOINTAMOUNT = pOINTAMOUNT;
    }

    @JsonProperty("PAYMENT_AMOUNT")
    public String getPAYMENTAMOUNT() {
        return pAYMENTAMOUNT;
    }

    @JsonProperty("PAYMENT_AMOUNT")
    public void setPAYMENTAMOUNT(String pAYMENTAMOUNT) {
        this.pAYMENTAMOUNT = pAYMENTAMOUNT;
    }

    @JsonProperty("POINT_BALANCE")
    public String getPOINTBALANCE() {
        return pOINTBALANCE;
    }

    @JsonProperty("POINT_BALANCE")
    public void setPOINTBALANCE(String pOINTBALANCE) {
        this.pOINTBALANCE = pOINTBALANCE;
    }

    @JsonProperty("EXCEED_HIGH_RISK")
    public String getEXCEEDHIGHRISK() {
        return eXCEEDHIGHRISK;
    }

    @JsonProperty("EXCEED_HIGH_RISK")
    public void setEXCEEDHIGHRISK(String eXCEEDHIGHRISK) {
        this.eXCEEDHIGHRISK = eXCEEDHIGHRISK;
    }

    @JsonProperty("CARDTYPE")
    public String getCARDTYPE() {
        return cARDTYPE;
    }

    @JsonProperty("CARDTYPE")
    public void setCARDTYPE(String cARDTYPE) {
        this.cARDTYPE = cARDTYPE;
    }

    @JsonProperty("CARD_NO_PARTIAL")
    public String getCARDNOPARTIAL() {
        return cARDNOPARTIAL;
    }

    @JsonProperty("CARD_NO_PARTIAL")
    public void setCARDNOPARTIAL(String cARDNOPARTIAL) {
        this.cARDNOPARTIAL = cARDNOPARTIAL;
    }

    @JsonProperty("CARDNAME")
    public String getCARDNAME() {
        return cARDNAME;
    }

    @JsonProperty("CARDNAME")
    public void setCARDNAME(String cARDNAME) {
        this.cARDNAME = cARDNAME;
    }

    @JsonProperty("is_on_us")
    public String getIsOnUs() {
        return isOnUs;
    }

    @JsonProperty("is_on_us")
    public void setIsOnUs(String isOnUs) {
        this.isOnUs = isOnUs;
    }

    @JsonProperty("WHITELIST_CARD")
    public String getWHITELISTCARD() {
        return wHITELISTCARD;
    }

    @JsonProperty("WHITELIST_CARD")
    public void setWHITELISTCARD(String wHITELISTCARD) {
        this.wHITELISTCARD = wHITELISTCARD;
    }

    @JsonProperty("BANK_RES_CODE")
    public String getBANKRESCODE() {
        return bANKRESCODE;
    }

    @JsonProperty("BANK_RES_CODE")
    public void setBANKRESCODE(String bANKRESCODE) {
        this.bANKRESCODE = bANKRESCODE;
    }

    @JsonProperty("BANK_RES_MSG")
    public String getBANKRESMSG() {
        return bANKRESMSG;
    }

    @JsonProperty("BANK_RES_MSG")
    public void setBANKRESMSG(String bANKRESMSG) {
        this.bANKRESMSG = bANKRESMSG;
    }

    @JsonProperty("AUTH_ID")
    public String getAUTHID() {
        return aUTHID;
    }

    @JsonProperty("AUTH_ID")
    public void setAUTHID(String aUTHID) {
        this.aUTHID = aUTHID;
    }

    @JsonProperty("BANK_REFERENCE")
    public String getBANKREFERENCE() {
        return bANKREFERENCE;
    }

    @JsonProperty("BANK_REFERENCE")
    public void setBANKREFERENCE(String bANKREFERENCE) {
        this.bANKREFERENCE = bANKREFERENCE;
    }

    @JsonProperty("INSTALLMENT_MONTHLY")
    public String getINSTALLMENTMONTHLY() {
        return iNSTALLMENTMONTHLY;
    }

    @JsonProperty("INSTALLMENT_MONTHLY")
    public void setINSTALLMENTMONTHLY(String iNSTALLMENTMONTHLY) {
        this.iNSTALLMENTMONTHLY = iNSTALLMENTMONTHLY;
    }

    @JsonProperty("INSTALLMENT_LAST")
    public String getINSTALLMENTLAST() {
        return iNSTALLMENTLAST;
    }

    @JsonProperty("INSTALLMENT_LAST")
    public void setINSTALLMENTLAST(String iNSTALLMENTLAST) {
        this.iNSTALLMENTLAST = iNSTALLMENTLAST;
    }

    @JsonProperty("popupProceed")
    public String getPopupProceed() {
        return popupProceed;
    }

    @JsonProperty("popupProceed")
    public void setPopupProceed(String popupProceed) {
        this.popupProceed = popupProceed;
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
