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
public class FaspayConfigDebitProd extends FaspayConfigDebit {

    public FaspayConfigDebitProd(FaspayUserDebit mFaspayUser) {
        super(mFaspayUser);
    }

    @Override
    public String getInquiryPaymentChannelUrl() {
        return "https://web.faspay.co.id/cvr/100001/10";
    }

    @Override
    public String getCreateBillingUrl() {
        return "https://web.faspay.co.id/cvr/300011/10";
    }

    @Override
    public String getInqueryPaymentStatusUrl() {
        return "https://web.faspay.co.id/cvr/100004/10";
    }

    @Override
    public String getCancelTransactionUrl() {
        return "https://web.faspay.co.id/cvr/100005/10";
    }

    

}
