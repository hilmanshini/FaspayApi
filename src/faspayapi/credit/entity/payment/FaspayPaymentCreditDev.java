/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faspayapi.credit.entity.payment;

public class FaspayPaymentCreditDev extends FaspayPaymentCredit{
    
    String pymt_ind = "";
    String pymt_criteria = "";
    String pymt_token = "";

    @Override
    String getUrl() {
        return  "https://fpgdev.faspay.co.id/payment";
    }
    
}
