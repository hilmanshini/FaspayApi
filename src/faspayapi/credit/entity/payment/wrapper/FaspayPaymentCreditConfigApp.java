/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faspayapi.credit.entity.payment.wrapper;

/**
 *
 * @author hilmananwarsah
 */
public class FaspayPaymentCreditConfigApp {
    private String response_type;
    private String return_url;
    private String mparam1;
    private String mparam2;
    private String frisk1,frisk2;
    private String handshake_url;
    private String handshake_param;

    public FaspayPaymentCreditConfigApp(String response_type) {
        this.response_type = response_type;
    }

    public FaspayPaymentCreditConfigApp(String response_type, String return_url) {
        this.response_type = response_type;
        this.return_url = return_url;
    }
    
    

    public FaspayPaymentCreditConfigApp(String response_type, String return_url, String mparam1, String mparam2, String frisk1, String frisk2, String handshake_url, String handshake_param) {
        this.response_type = response_type;
        this.return_url = return_url;
        this.mparam1 = mparam1;
        this.mparam2 = mparam2;
        this.frisk1 = frisk1;
        this.frisk2 = frisk2;
        this.handshake_url = handshake_url;
        this.handshake_param = handshake_param;
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

    
            
}
