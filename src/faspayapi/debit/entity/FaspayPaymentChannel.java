/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faspayapi.debit.entity;

/**
 *
 * @author hilmananwarsah
 */
public class FaspayPaymentChannel {
    String pg_code = "",pg_name = "";

    public String getPg_code() {
        return pg_code;
    }

    public void setPg_code(String pg_code) {
        this.pg_code = pg_code;
    }

    public String getPg_name() {
        return pg_name;
    }

    public void setPg_name(String pg_name) {
        this.pg_name = pg_name;
    }
    
    
    
}
