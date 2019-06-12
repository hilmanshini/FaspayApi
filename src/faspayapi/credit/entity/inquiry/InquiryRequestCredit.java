/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faspayapi.credit.entity.inquiry;

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
    String transactionid;
    String amount;

    public void setTransactiontype(String transactiontype) {
        this.transactiontype = transactiontype;
    }
    String signature;

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

}
