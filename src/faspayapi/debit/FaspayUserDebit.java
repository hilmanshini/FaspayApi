/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faspayapi.debit;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author hilmananwarsah
 */
    public class FaspayUserDebit {

    String merchantName;
    String merchantId;
    String userId;
    String password;
    String redirectUrl;

    public FaspayUserDebit() {
    }
    
    

    public FaspayUserDebit(String merchantName, String merchantId, String userId, String password, String redirectUrl) {
        this.merchantName = merchantName;
        this.merchantId = merchantId;
        this.userId = userId;
        this.password = password;
        this.redirectUrl = redirectUrl;
    }
    
    

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public String calculateSignature() {
        String userAndPass = new StringBuilder(userId).append(password).toString();
        System.out.println(userAndPass);
        char[] md5 = Hex.encodeHex(DigestUtils.md5(userAndPass));
        byte[] data = DigestUtils.sha1(new String(md5));
        char[] sha1 = Hex.encodeHex(data);
        return (new String(sha1));
        
    }

}
