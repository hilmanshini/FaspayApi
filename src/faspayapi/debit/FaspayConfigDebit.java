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
public abstract class FaspayConfigDebit {

    int dayIntervalDateExpired = 30;

    public int getDayIntervalDateExpired() {
        return dayIntervalDateExpired;
    }

    public void setDayIntervalDateExpired(int dayIntervalDateExpired) {
        this.dayIntervalDateExpired = dayIntervalDateExpired;
    }
    

    FaspayUserDebit mFaspayUser;

    public FaspayConfigDebit(FaspayUserDebit mFaspayUser) {
        this.mFaspayUser = mFaspayUser;
    }

    public FaspayUserDebit getFaspayUser() {
        return mFaspayUser;
    }

    public abstract String getInquiryPaymentChannelUrl();

    public abstract String getCreateBillingUrl();

    public abstract String getInqueryPaymentStatusUrl();

    public abstract String getCancelTransactionUrl();

}
