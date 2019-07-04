/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faspayapi.credit.entity.payment.wrapper;

import faspayapi.credit.FaspayUserCredit;
import java.text.DecimalFormat;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author hilmananwarsah
 */
public class FaspayPaymentCreditTransactionData {

    private String merchant_tranid;
    private String currencycode;
    private long amount;
    private FaspayUserCredit usr;
    private String signature;

    public FaspayPaymentCreditTransactionData(FaspayUserCredit usr,String merchant_tranid,String currencycode,long amount) {
        this.usr = usr;
        this.merchant_tranid = merchant_tranid;
        this.currencycode = currencycode;
        this.amount = amount;
    }

    public String getMerchant_tranid() {
        return merchant_tranid;
    }

    public void setMerchant_tranid(String merchant_tranid) {
        this.merchant_tranid = merchant_tranid;
    }

    public String getSignature() {
        StringBuilder sb = new StringBuilder();
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        System.out.println("SIG "+getAmount()+" "+getMerchant_tranid());
        signature = sb.append("##").append(usr.getMerchantId().toUpperCase()).append("##").append(usr.getPass().toUpperCase()).append("##").append(getMerchant_tranid()).append("##").append(decimalFormat.format(getAmount())).append("##0##").toString();
        System.out.println("all "+signature);
        return new String(Hex.encodeHex(DigestUtils.sha1(signature)));
        
    }

    public void setSignature(String signature) {

    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getCurrencycode() {
        return currencycode;
    }

    public void setCurrencycode(String currencycode) {
        this.currencycode = currencycode;
    }
    
    

}
