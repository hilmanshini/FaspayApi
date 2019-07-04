/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faspayapi.credit.entity.capture;

import faspayapi.credit.FaspayUserCredit;
import java.text.DecimalFormat;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.cli.Digest;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author hilmananwarsah
 */
public class CaptureRequestWrapperDev extends CaptureRequest {

    public CaptureRequestWrapperDev(FaspayUserCredit user, String MERCHANT_TRANID, String TRANSACTIONID, long AMOUNT, String CUSTNAME, String CUSTEMAIL, String DESCRIPTION, String RETURN_URL) {
        this.merchantid = user.getMerchantId();
        this.merchant_tranid = MERCHANT_TRANID;
        this.transactionid = TRANSACTIONID;
        DecimalFormat df = new DecimalFormat("#.00");
        this.amount = df.format(AMOUNT);
        this.custname = CUSTNAME;
        this.custemail = CUSTEMAIL;
        this.description = DESCRIPTION;
        this.return_url = RETURN_URL;
        String raw = new StringBuilder().append("##").append(user.getMerchantId().toUpperCase()).append("##").append(user.getPass().toUpperCase()).append("##").append(merchant_tranid).append("##").append(getAmount()).append("##").append(TRANSACTIONID).append("##").toString();
        System.out.println(raw);
        this.signature =  new String(Hex.encodeHex(DigestUtils.sha1(raw)));
        
    }

    @Override
    String getUrl() {
        return "https://fpgdev.faspay.co.id/payment/api";
    }

}
