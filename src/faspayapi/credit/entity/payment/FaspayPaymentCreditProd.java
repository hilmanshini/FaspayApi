/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faspayapi.credit.entity.payment;

public class FaspayPaymentCreditProd extends FaspayPaymentCredit{
    String pymt_ind = "card_range_ind";
    String pymt_criteria = "credit_card";
    String pymt_token = "";

    public String getPymt_token() {
        return pymt_token;
    }

    public void setPymt_token(String pymt_token) {
        this.pymt_token = pymt_token;
    }
    

    public String getPymt_ind() {
        return pymt_ind;
    }

    public void setPymt_ind(String pymt_ind) {
        this.pymt_ind = pymt_ind;
    }

    public String getPymt_criteria() {
        return pymt_criteria;
    }

    public void setPymt_criteria(String pymt_criteria) {
        this.pymt_criteria = pymt_criteria;
    }

    @Override
    String getUrl() {
        return  "https://fpg.faspay.co.id/payment";
    }
    
}