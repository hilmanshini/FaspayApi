/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faspayapi.credit.entity.capture;

import faspayapi.credit.FaspayUserCredit;
import faspayapi.credit.TetsUser;
import java.text.DecimalFormat;
import org.apache.commons.codec.cli.Digest;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author hilmananwarsah
 */
public class CaptureRequestWrapperProd extends CaptureRequest {

    public CaptureRequestWrapperProd(FaspayUserCredit user, String MERCHANT_TRANID, String TRANSACTIONID, long AMOUNT, String CUSTNAME, String CUSTEMAIL, String DESCRIPTION, String RETURN_URL) {
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
        this.signature = DigestUtils.sha1Hex(raw);
    }

    @Override
    String getUrl() {
        return "https://fpg.faspay.co.id/payment/api";
    }

    public static void main(String[] args) {
        System.out.println(new CaptureRequestWrapperDev(new TetsUser(), "2019061200757", "66A93765-1DC2-46FD-B542-267AF1B75AE4", 100000, "merhcant test CC", "haha@haha.com", "ddddd ", "https://programmermiskin.chickenkiller.com/faspay/api/notify").generateHtml());
    }

}
