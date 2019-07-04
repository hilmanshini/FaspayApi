/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faspayapi.credit.entity.payment;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import faspayapi.credit.FaspayUserCredit;
import faspayapi.credit.TetsUser;
import faspayapi.credit.entity.payment.wrapper.FaspayPaymentCreditBillData;
import faspayapi.credit.entity.payment.wrapper.FaspayPaymentCreditCardData;
import faspayapi.credit.entity.payment.wrapper.FaspayPaymentCreditConfigApp;
import faspayapi.credit.entity.payment.wrapper.FaspayPaymentCreditDomicileData;
import faspayapi.credit.entity.payment.wrapper.FaspayPaymentCreditItemData;
import faspayapi.credit.entity.payment.wrapper.FaspayPaymentCreditShippingdata;
import faspayapi.credit.entity.payment.wrapper.FaspayPaymentCreditShopperData;
import faspayapi.credit.entity.payment.wrapper.FaspayPaymentCreditTransactionData;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;

/**
 *
 * @author hilmananwarsah
 */
public abstract class FaspayPaymentCredit {

    public String getTransactiontype() {
        return transactiontype;
    }

    public void setTransactiontype(String transactiontype) {
        this.transactiontype = transactiontype;
    }

    public static final String RESPONSE_TYPE_GET = "1";
    public static final String RESPONSE_TYPE_POST = "2";
    public static final String RESPONSE_TYPE_PRINT = "3";

    public static final char CARD_TYPE_MASTERCARD = 'M';
    public static final char CARD_TYPE_VISA = 'V';
    public static final char CARD_TYPE_JCB = 'J';
    public static final char CARD_TYPE_AMEX = 'A';

    private String payment_method = "1";
    private String merchantid;
    private String merchant_tranid;
    private String txn_password;
    private String lang;
    private String currencycode;
    private String amount;
    private String signature;
    private String custname;
    private String custemail;
    private String shopper_ip;
    private String description;
    private String response_type;
    private String return_url;
    private String cardno;
    private String cardname;
    private String cardtype;
    private String expirymonth;
    private String expiryyear;
    private String cardcvc;
    private String card_issuer_bank_country_code;
    private String billing_address;
    private String billing_address_city;
    private String billing_address_region;
    private String billing_address_state;
    private String billing_address_poscode;
    private String billing_address_country_code;
    private String receiver_name_for_shipping;
    private String shipping_address;
    private String shipping_address_city;
    private String shipping_address_region;
    private String shipping_address_state;
    private String shipping_address_poscode;
    private String shipping_address_country_code;
    private String shippingcost;
    private String phone_no;
    private String mref1;
    private String mref2;
    private String mref3;
    private String mref4;
    private String mref5;
    private String mref6;
    private String mref7;
    private String mref8;
    private String mref9;
    private String mref10;
    private String mparam1;
    private String mparam2;
    private String customer_ref;
    private String frisk1;
    private String frisk2;
    private String domicile_address;
    private String domicile_address_city;
    private String domicile_address_region;
    private String domicile_address_state;
    private String domicile_address_poscode;
    private String domicile_address_country_code;
    private String domicile_phone_no;
    private String handshake_url;
    private String handshake_param;
    private String card_issuer_bank;
    private String card_identity_ref_type;
    private String card_identity_ref;
    private String card_phone;
    private String card_bill_addr;
    private String card_bill_addr_poscode;
    private String card_bill_addr_city;
    private String card_bill_addr_region;
    private String card_bill_addr_state;
    private String card_bill_addr_country_code;
    private String card_email;
    private String transactiontype = "1";
    
    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getTxn_password() {
        return txn_password;
    }

    public void setTxn_password(String txn_password) {
        this.txn_password = txn_password;
    }
    

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public String getMerchantid() {
        return merchantid;
    }

    public void setMerchantid(String merchantid) {
        this.merchantid = merchantid;
    }

    public String getMerchant_tranid() {
        return merchant_tranid;
    }

    public void setMerchant_tranid(String merchant_tranid) {
        this.merchant_tranid = merchant_tranid;
    }

    public String getCurrencycode() {
        return currencycode;
    }

    public void setCurrencycode(String currencycode) {
        this.currencycode = currencycode;
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

    public String getShopper_ip() {
        return shopper_ip;
    }

    public void setShopper_ip(String shopper_ip) {
        this.shopper_ip = shopper_ip;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResponse_type() {
        return response_type;
    }

    public void setResponse_type(String response_type) {
        this.response_type = response_type;
    }

    public String getReturn_url() {
        return return_url;
    }

    public void setReturn_url(String return_url) {
        this.return_url = return_url;
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }

    public String getCardname() {
        return cardname;
    }

    public void setCardname(String cardname) {
        this.cardname = cardname;
    }

    public String getCardtype() {
        return cardtype;
    }

    public void setCardtype(String cardtype) {
        this.cardtype = cardtype;
    }

    public String getExpirymonth() {
        return expirymonth;
    }

    public void setExpirymonth(String expirymonth) {
        this.expirymonth = expirymonth;
    }

    public String getExpiryyear() {
        return expiryyear;
    }

    public void setExpiryyear(String expiryyear) {
        this.expiryyear = expiryyear;
    }

    public String getCardcvc() {
        return cardcvc;
    }

    public void setCardcvc(String cardcvc) {
        this.cardcvc = cardcvc;
    }

    public String getCard_issuer_bank_country_code() {
        return card_issuer_bank_country_code;
    }

    public void setCard_issuer_bank_country_code(String card_issuer_bank_country_code) {
        this.card_issuer_bank_country_code = card_issuer_bank_country_code;
    }

    public String getBilling_address() {
        return billing_address;
    }

    public void setBilling_address(String billing_address) {
        this.billing_address = billing_address;
    }

    public String getBilling_address_city() {
        return billing_address_city;
    }

    public void setBilling_address_city(String billing_address_city) {
        this.billing_address_city = billing_address_city;
    }

    public String getBilling_address_region() {
        return billing_address_region;
    }

    public void setBilling_address_region(String billing_address_region) {
        this.billing_address_region = billing_address_region;
    }

    public String getBilling_address_state() {
        return billing_address_state;
    }

    public void setBilling_address_state(String billing_address_state) {
        this.billing_address_state = billing_address_state;
    }

    public String getBilling_address_poscode() {
        return billing_address_poscode;
    }

    public void setBilling_address_poscode(String billing_address_poscode) {
        this.billing_address_poscode = billing_address_poscode;
    }

    public String getBilling_address_country_code() {
        return billing_address_country_code;
    }

    public void setBilling_address_country_code(String billing_address_country_code) {
        this.billing_address_country_code = billing_address_country_code;
    }

    public String getReceiver_name_for_shipping() {
        return receiver_name_for_shipping;
    }

    public void setReceiver_name_for_shipping(String receiver_name_for_shipping) {
        this.receiver_name_for_shipping = receiver_name_for_shipping;
    }

    public String getShipping_address() {
        return shipping_address;
    }

    public void setShipping_address(String shipping_address) {
        this.shipping_address = shipping_address;
    }

    public String getShipping_address_city() {
        return shipping_address_city;
    }

    public void setShipping_address_city(String shipping_address_city) {
        this.shipping_address_city = shipping_address_city;
    }

    public String getShipping_address_region() {
        return shipping_address_region;
    }

    public void setShipping_address_region(String shipping_address_region) {
        this.shipping_address_region = shipping_address_region;
    }

    public String getShipping_address_state() {
        return shipping_address_state;
    }

    public void setShipping_address_state(String shipping_address_state) {
        this.shipping_address_state = shipping_address_state;
    }

    public String getShipping_address_poscode() {
        return shipping_address_poscode;
    }

    public void setShipping_address_poscode(String shipping_address_poscode) {
        this.shipping_address_poscode = shipping_address_poscode;
    }

    public String getShipping_address_country_code() {
        return shipping_address_country_code;
    }

    public void setShipping_address_country_code(String shipping_address_country_code) {
        this.shipping_address_country_code = shipping_address_country_code;
    }

    public String getShippingcost() {
        return shippingcost;
    }

    public void setShippingcost(String shippingcost) {
        this.shippingcost = shippingcost;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getMref1() {
        return mref1;
    }

    public void setMref1(String mref1) {
        this.mref1 = mref1;
    }

    public String getMref2() {
        return mref2;
    }

    public void setMref2(String mref2) {
        this.mref2 = mref2;
    }

    public String getMref3() {
        return mref3;
    }

    public void setMref3(String mref3) {
        this.mref3 = mref3;
    }

    public String getMref4() {
        return mref4;
    }

    public void setMref4(String mref4) {
        this.mref4 = mref4;
    }

    public String getMref5() {
        return mref5;
    }

    public void setMref5(String mref5) {
        this.mref5 = mref5;
    }

    public String getMref6() {
        return mref6;
    }

    public void setMref6(String mref6) {
        this.mref6 = mref6;
    }

    public String getMref7() {
        return mref7;
    }

    public void setMref7(String mref7) {
        this.mref7 = mref7;
    }

    public String getMref8() {
        return mref8;
    }

    public void setMref8(String mref8) {
        this.mref8 = mref8;
    }

    public String getMref9() {
        return mref9;
    }

    public void setMref9(String mref9) {
        this.mref9 = mref9;
    }

    public String getMref10() {
        return mref10;
    }

    public void setMref10(String mref10) {
        this.mref10 = mref10;
    }

    public String getMparam1() {
        return mparam1;
    }

    public void setMparam1(String mparam1) {
        this.mparam1 = mparam1;
    }

    public String getMparam2() {
        return mparam2;
    }

    public void setMparam2(String mparam2) {
        this.mparam2 = mparam2;
    }

    public String getCustomer_ref() {
        return customer_ref;
    }

    public void setCustomer_ref(String customer_ref) {
        this.customer_ref = customer_ref;
    }

    public String getFrisk1() {
        return frisk1;
    }

    public void setFrisk1(String frisk1) {
        this.frisk1 = frisk1;
    }

    public String getFrisk2() {
        return frisk2;
    }

    public void setFrisk2(String frisk2) {
        this.frisk2 = frisk2;
    }

    public String getDomicile_address() {
        return domicile_address;
    }

    public void setDomicile_address(String domicile_address) {
        this.domicile_address = domicile_address;
    }

    public String getDomicile_address_city() {
        return domicile_address_city;
    }

    public void setDomicile_address_city(String domicile_address_city) {
        this.domicile_address_city = domicile_address_city;
    }

    public String getDomicile_address_region() {
        return domicile_address_region;
    }

    public void setDomicile_address_region(String domicile_address_region) {
        this.domicile_address_region = domicile_address_region;
    }

    public String getDomicile_address_state() {
        return domicile_address_state;
    }

    public void setDomicile_address_state(String domicile_address_state) {
        this.domicile_address_state = domicile_address_state;
    }

    public String getDomicile_address_poscode() {
        return domicile_address_poscode;
    }

    public void setDomicile_address_poscode(String domicile_address_poscode) {
        this.domicile_address_poscode = domicile_address_poscode;
    }

    public String getDomicile_address_country_code() {
        return domicile_address_country_code;
    }

    public void setDomicile_address_country_code(String domicile_address_country_code) {
        this.domicile_address_country_code = domicile_address_country_code;
    }

    public String getDomicile_phone_no() {
        return domicile_phone_no;
    }

    public void setDomicile_phone_no(String domicile_phone_no) {
        this.domicile_phone_no = domicile_phone_no;
    }

    public String getHandshake_url() {
        return handshake_url;
    }

    public void setHandshake_url(String handshake_url) {
        this.handshake_url = handshake_url;
    }

    public String getHandshake_param() {
        return handshake_param;
    }

    public void setHandshake_param(String handshake_param) {
        this.handshake_param = handshake_param;
    }

    public String getCard_issuer_bank() {
        return card_issuer_bank;
    }

    public void setCard_issuer_bank(String card_issuer_bank) {
        this.card_issuer_bank = card_issuer_bank;
    }

    public String getCard_identity_ref_type() {
        return card_identity_ref_type;
    }

    public void setCard_identity_ref_type(String card_identity_ref_type) {
        this.card_identity_ref_type = card_identity_ref_type;
    }

    public String getCard_identity_ref() {
        return card_identity_ref;
    }

    public void setCard_identity_ref(String card_identity_ref) {
        this.card_identity_ref = card_identity_ref;
    }

    public String getCard_phone() {
        return card_phone;
    }

    public void setCard_phone(String card_phone) {
        this.card_phone = card_phone;
    }

    public String getCard_bill_addr() {
        return card_bill_addr;
    }

    public void setCard_bill_addr(String card_bill_addr) {
        this.card_bill_addr = card_bill_addr;
    }

    public String getCard_bill_addr_poscode() {
        return card_bill_addr_poscode;
    }

    public void setCard_bill_addr_poscode(String card_bill_addr_poscode) {
        this.card_bill_addr_poscode = card_bill_addr_poscode;
    }

    public String getCard_bill_addr_city() {
        return card_bill_addr_city;
    }

    public void setCard_bill_addr_city(String card_bill_addr_city) {
        this.card_bill_addr_city = card_bill_addr_city;
    }

    public String getCard_bill_addr_region() {
        return card_bill_addr_region;
    }

    public void setCard_bill_addr_region(String card_bill_addr_region) {
        this.card_bill_addr_region = card_bill_addr_region;
    }

    public String getCard_bill_addr_state() {
        return card_bill_addr_state;
    }

    public void setCard_bill_addr_state(String card_bill_addr_state) {
        this.card_bill_addr_state = card_bill_addr_state;
    }

    public String getCard_bill_addr_country_code() {
        return card_bill_addr_country_code;
    }

    public void setCard_bill_addr_country_code(String card_bill_addr_country_code) {
        this.card_bill_addr_country_code = card_bill_addr_country_code;
    }

    public String getCard_email() {
        return card_email;
    }

    public void setCard_email(String card_email) {
        this.card_email = card_email;
    }

    abstract String getUrl();

    public void generateHtml(String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            fos.write(generateHtml().getBytes());;
            fos.flush();
            fos.close();
        } catch (Exception e) {
        }

    }

    public String generateHtml() {

        try {
            System.out.println(getCard_issuer_bank());
            JSONObject o = new JSONObject(new ObjectMapper().writeValueAsString(this));

            o.remove("cardno");
            o.remove("CARDNO");

            Iterator<String> e = o.keys();
            List<String> d = new ArrayList<String>(o.keySet());
            Collections.sort(d);
            StringBuilder sb = new StringBuilder("<form method=\"post\" name=\"form\" action=\"" + getUrl() + "\">");
            for (String next : d) {
//                String next = e.next();
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
