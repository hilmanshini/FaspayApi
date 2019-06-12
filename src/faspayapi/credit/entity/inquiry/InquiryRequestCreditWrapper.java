/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faspayapi.credit.entity.inquiry;

import faspayapi.credit.FaspayUserCredit;
import java.text.DecimalFormat;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author hilmananwarsah
 */
public class InquiryRequestCreditWrapper extends InquiryRequestCredit{
    FaspayUserCredit user;
    String transactionid;
    String merchant_tranid;

    public InquiryRequestCreditWrapper(FaspayUserCredit user, String TRANSACTIONID, String MERCHANT_TRANID,long amount) {
        this.user = user;
        this.transactionid = TRANSACTIONID;
        this.merchant_tranid = MERCHANT_TRANID;
        DecimalFormat df = new DecimalFormat("#.00");
        this.amount = df.format(amount);
        setTransactionid(TRANSACTIONID);
        setTransactiontype("4");
        setResponse_type("3");
        setMerchantid(user.getMerchantId());
        setPayment_method("1");
        String rawsig = new StringBuilder("##").append(user.getMerchantId().toUpperCase()).append("##").append(user.getPass().toUpperCase()).append("##").append(MERCHANT_TRANID).append("##").append(getAmount()).append("##0##").toString();
        System.out.println("raw sign = "+rawsig);
        this.signature = DigestUtils.sha1Hex(rawsig);
    }

    public FaspayUserCredit getUser() {
        return user;
    }

    public void setUser(FaspayUserCredit user) {
        this.user = user;
    }

    public String getTransactionid() {
        return transactionid;
    }

    public void setTransactionid(String transactionid) {
        this.transactionid = transactionid;
    }

    public String getMerchant_tranid() {
        return merchant_tranid;
    }

    public void setMerchant_tranid(String merchant_tranid) {
        this.merchant_tranid = merchant_tranid;
    }
    
    
}
