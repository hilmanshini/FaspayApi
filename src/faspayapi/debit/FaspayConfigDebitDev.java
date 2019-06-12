/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faspayapi.debit;

/**
 *
 * @author hilmananwarsah
 */
public class FaspayConfigDebitDev extends FaspayConfigDebit {

    public FaspayConfigDebitDev(FaspayUserDebit mFaspayUser) {
        super(mFaspayUser);
    }

    @Override
    public String getInquiryPaymentChannelUrl() {
        return "https://dev.faspay.co.id/cvr/100001/10";
    }

    @Override
    public String getCreateBillingUrl() {
        return "https://dev.faspay.co.id/cvr/300011/10";
    }

    @Override
    public String getInqueryPaymentStatusUrl() {
        return "https://dev.faspay.co.id/cvr/100004/10";
    }

    @Override
    public String getCancelTransactionUrl() {
        return "https://dev.faspay.co.id/cvr/100005/10";
    }

}
