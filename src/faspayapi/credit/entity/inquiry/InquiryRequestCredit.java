/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faspayapi.credit.entity.inquiry;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import faspayapi.credit.FaspayConfigCredit;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;

/**
 *
 * @author hilmananwarsah
 */
public class InquiryRequestCredit {

    String transactiontype;
    String response_type;
    String merchantid;
    String payment_method;
    String merchant_tranid;
    String signature;
    String amount;
    FaspayConfigCredit configCredit;

    public InquiryRequestCredit(FaspayConfigCredit configCredit) {
        this.configCredit = configCredit;
    }

    public void setTransactiontype(String transactiontype) {
        this.transactiontype = transactiontype;
    }
    

    public String getResponse_type() {
        return response_type;
    }

    public void setResponse_type(String response_type) {
        this.response_type = response_type;
    }

    public String getMerchantid() {
        return merchantid;
    }

    public void setMerchantid(String merchantid) {
        this.merchantid = merchantid;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public String getMerchant_tranid() {
        return merchant_tranid;
    }

    public void setMerchant_tranid(String merchant_tranid) {
        this.merchant_tranid = merchant_tranid;
    }

    

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public static void main(String[] args) {
        String e = "String TRANSACTIONTYPE = \"2\";\n"
                + "    String RESPONSE_TYPE = \"3\";\n"
                + "    String MERCHANTID;\n"
                + "    String PAYMENT_METHOD = \"1\";\n"
                + "    String MERCHANT_TRANID;\n"
                + "    String TRANSACTIONID;\n"
                + "    String AMOUNT;\n"
                + "    String CUSTNAME;\n"
                + "    String CUSTEMAIL;\n"
                + "    String DESCRIPTION;\n"
                + "    String RETURN_URL;\n"
                + "    String SIGNATURE;";
        System.out.println(e.replaceAll("String", "string").toLowerCase().replace("string", "String"));
    }

    public String getTransactiontype() {
        return transactiontype;
    }

    public String generateHtml() {
        try {
            String json = new ObjectMapper().writeValueAsString(this);
            JSONObject o = new JSONObject(json);
            Iterator<String> e = o.keys();
            StringBuilder sb = new StringBuilder("<form method=\"post\" name=\"form\" action=\"" + configCredit.getMerchantInquiryUrl() + "\">");
            while (e.hasNext()) {
                String next = e.next();
                String val = "";
                if (!o.isNull(next)) {
                    try {
                        val = o.getString(next);
                    } catch (Exception ex) {
                    }

                } else {
                    val = "";
                }
                //           System.out.println(next+" "+val);

                sb = sb.append("\n");
                sb = sb.append("<input type=\"hidden\" name=\"");
                sb = sb.append(next.toUpperCase());
                sb = sb.append("\" value=\"");
                sb = sb.append(val);
                sb = sb.append("\">");

            }
            sb = sb.append("\n</form>");
            sb = sb.append("<script> document.form.submit();</script>");
            return sb.toString();
        } catch (JsonProcessingException ex) {
            Logger.getLogger(InquiryRequestCredit.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

}
