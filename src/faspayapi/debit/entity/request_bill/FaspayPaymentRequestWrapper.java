/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faspayapi.debit.entity.request_bill;

import faspayapi.debit.entity.request_bill.FaspayPaymentRequestBillData;
import faspayapi.debit.FaspayConfigDebit;
import faspayapi.debit.entity.FaspayPaymentChannel;
import faspayapi.debit.entity.FaspayPaymentRequest;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author hilmananwarsah
 */
public class FaspayPaymentRequestWrapper extends FaspayPaymentRequest {

    FaspayConfigDebit mFaspayConfig;
    public static final int PAY_TYPE_PAY_TYPE_FULL_SETTLEMENT = 1;
    public static final int PAY_TYPE_INSTALLMENT = 2;
    public static final int PAY_TYPE_MIXED = 3;

    public static final int TERMINAL_WEB = 10;
    public static final int TERMINAL_MOBILE_APP_BLACKBERRY = 20;
    public static final int TERMINAL_MOBILE_APP_ANDROID = 21;
    public static final int TERMINAL_MOBILE_APP_IOS = 22;
    public static final int TERMINAL_MOBILE_APP_WINDOWS = 23;
    public static final int TERMINAL_MOBILE_APP_SYMBIAN = 24;
    public static final int TERMINAL_TAB_APP_BLACKBERRY = 30;
    public static final int TERMINAL_TAB_APP_ANDROID = 31;
    public static final int TERMINAL_TAB_APP_IOS = 32;
    public static final int TERMINAL_TAB_APP_WINDOWS = 33;

    public FaspayPaymentRequestWrapper(
            FaspayConfigDebit mFaspayConfig,
            FaspayPaymentRequestBillData billing,
            FaspayPaymentChannel mFaspayPaymentChannel,
            FaspayPaymentRequestUserData userData,
            FaspayPaymentRequestShippingData mShippingData
    ) {
        this.mFaspayConfig = mFaspayConfig;
        setRequest("");
        setMerchantId(mFaspayConfig.getFaspayUser().getMerchantId());
        setMerchant(mFaspayConfig.getFaspayUser().getMerchantName());
        setBillNo(billing.getBillNo());
        setBillReff(billing.getBillReff());
        setBillDate(billing.getBillDate());
        setBillExpired(billing.getBillExpired());
        setBillDesc(billing.getBillDesc());
        setBillCurrency(billing.getBillCurrency());
        setBillGross(billing.getBillGross());
        
        setBillMiscfee(billing.getBillMiscfee());
        
        setBillTotal(billing.getBillTotal());
        setCustNo(userData.getCustNo());
        setCustName(userData.getCustName());
        setPaymentChannel(mFaspayPaymentChannel.getPg_code());
        setBankUserid(userData.getBankUserid());
        setMsisdn(userData.getMsisdn());
        setEmail(userData.getEmail());
        setTerminal(userData.getTerminal());
        setBillingName(billing.getBillingName());
        setBillingLastname(billing.getBillingLastname());
        setBillingAddress(billing.getBillingAddress());
        setBillingAddressCity(billing.getBillingAddressCity());
        setBillingAddressRegion(billing.getBillingAddressRegion());
        setBillingAddressState(billing.getBillingAddressState());
        setBillingAddressPoscode(billing.getBillingAddressPoscode());
        setBillingMsisdn(billing.getBillingMsisdn());
        setBillingAddressCountryCode(billing.getBillingAddressCountryCode());
        setReceiverNameForShipping(mShippingData.getReceiver_name_for_shipping());
        setShippingLastname(mShippingData.getShipping_lastname());
        setShippingAddress(mShippingData.getShipping_address());
        setShippingAddressCity(mShippingData.getShipping_address_city());
        setShippingAddressRegion(mShippingData.getShipping_address_region());
        setShippingAddressState(mShippingData.getShipping_address_state());
        setShippingAddressPoscode(mShippingData.getShipping_address_poscode());
        setShippingMsisdn(mShippingData.getShipping_msisdn());
        setShippingAddressCountryCode(mShippingData.getShipping_address_country_code());
        setItem(billing.getItem());
        setReserve1("");
        
        setReserve2("");
        setRequest("");
        setPayType(String.valueOf(billing.getPay_type()));
        String userAndPass = new StringBuilder(mFaspayConfig.getFaspayUser().getUserId()).append(mFaspayConfig.getFaspayUser().getPassword()).append(getBillNo()).toString();
        System.out.println("UPASS "+userAndPass);
        char[] md5 = Hex.encodeHex(DigestUtils.md5(userAndPass));
        byte[] data = DigestUtils.sha1(new String(md5));
        char[] sha1 = Hex.encodeHex(data);
        setSignature(new String(sha1));

    }
    public static void main(String[] args) {
        String e = "1231233";
        
    }
    

}
