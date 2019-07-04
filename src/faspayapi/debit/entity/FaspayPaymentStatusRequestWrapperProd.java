/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faspayapi.debit.entity;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import faspayapi.debit.FaspayConfigDebit;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "request",
    "trx_id",
    "merchant_id",
    "bill_no",
    "signature",
    "payment_status_code",
    "payment_status_desc"
        
})
public class FaspayPaymentStatusRequestWrapperProd extends FaspayPaymentStatusRequest {
    
    String payment_status_desc;
    String payment_status_code;

    public String getPayment_status_desc() {
        return payment_status_desc;
    }

    public void setPayment_status_desc(String payment_status_desc) {
        this.payment_status_desc = payment_status_desc;
    }

    public String getPayment_status_code() {
        return payment_status_code;
    }

    public void setPayment_status_code(String payment_status_code) {
        this.payment_status_code = payment_status_code;
    }
    
    
    
    public FaspayPaymentStatusRequestWrapperProd(String request, String trxId, String bill_no, FaspayConfigDebit mFaspayConfig,String payment_status_desc,String payment_status_code) {

        String userAndPass = new StringBuilder(mFaspayConfig.getFaspayUser().getUserId()).append(mFaspayConfig.getFaspayUser().getPassword()).append(bill_no).toString();
        setRequest(request);
        setTrxId(trxId);
        setBillNo(bill_no);
        setPayment_status_code(payment_status_code);
        setPayment_status_desc(payment_status_desc);
        setMerchantId(mFaspayConfig.getFaspayUser().getMerchantId());
        char[] md5 = Hex.encodeHex(DigestUtils.md5(userAndPass));
        byte[] data = DigestUtils.sha1(new String(md5));
        char[] sha1 = Hex.encodeHex(data);
        setSignature(new String(sha1));

    }

}
