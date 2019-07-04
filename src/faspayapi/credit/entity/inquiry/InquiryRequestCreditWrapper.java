/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faspayapi.credit.entity.inquiry;

import faspayapi.credit.FaspayConfigCredit;
import faspayapi.credit.FaspayUserCredit;
import java.text.DecimalFormat;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author hilmananwarsah
 */
public class InquiryRequestCreditWrapper extends InquiryRequestCredit{
    FaspayUserCredit user;
    
    String merchant_tranid;

    public InquiryRequestCreditWrapper(FaspayConfigCredit configCredit,FaspayUserCredit user,  String MERCHANT_TRANID,long amount) {
        super(configCredit);
        this.user = user;
        
        this.merchant_tranid = MERCHANT_TRANID;
        DecimalFormat df = new DecimalFormat("#.00");
        this.amount = df.format(amount);
        setTransactiontype("4");
        setResponse_type("3");
        setMerchantid(user.getMerchantId());
        setPayment_method("1");
          String rawsig = new StringBuilder("##").append(user.getMerchantId().toUpperCase()).append("##").append(user.getPass().toUpperCase()).append("##").append(MERCHANT_TRANID).append("##").append(getAmount()).append("##0##").toString();
        System.out.println("raw sign = "+rawsig);
        this.signature =  new String(Hex.encodeHex(DigestUtils.sha1(rawsig)));
    }

    public FaspayUserCredit getUser() {
        return user;
    }

    public void setUser(FaspayUserCredit user) {
        this.user = user;
    }

    

    public String getMerchant_tranid() {
        return merchant_tranid;
    }

    public void setMerchant_tranid(String merchant_tranid) {
        this.merchant_tranid = merchant_tranid;
    }

    
    
    
}
