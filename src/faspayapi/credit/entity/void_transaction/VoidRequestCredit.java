/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faspayapi.credit.entity.void_transaction;

import faspayapi.credit.entity.capture.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import faspayapi.credit.entity.payment.FaspayPaymentCreditWrapperDev;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;

/**
 *
 * @author hilmananwarsah
 */
public abstract class VoidRequestCredit {
    String transactiontype = "10";
    String response_type = "3";
    String merchantid;
    String payment_method = "1";
    String merchant_tranid;
    String transactionid;
    String amount;
    String custname;
    String custemail;
    String description;
    String return_url;
    String signature;

    public String getTransactiontype() {
        return transactiontype;
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

    public String getTransactionid() {
        return transactionid;
    }

    public void setTransactionid(String transactionid) {
        this.transactionid = transactionid;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCustname() {
        return custname;
    }

    public void setCustname(String custname) {
        this.custname = custname;
    }

    public String getCustemail() {
        return custemail;
    }

    public void setCustemail(String custemail) {
        this.custemail = custemail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReturn_url() {
        return return_url;
    }

    public void setReturn_url(String return_url) {
        this.return_url = return_url;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    
    public abstract String getUrl();
    
    public String generateHtml(){
        

        try {
            
            JSONObject o = new JSONObject(new ObjectMapper().writeValueAsString(this));
            
            

            Iterator<String> e = o.keys();
            StringBuilder sb = new StringBuilder("<form method=\"post\" name=\"form\" action=\""+getUrl()+"\">");
            while (e.hasNext()) {
                String next = e.next();
                String val;
                if (!o.isNull(next)) {
                    val = o.getString(next);
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
            Logger.getLogger(FaspayPaymentCreditWrapperDev.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
}
