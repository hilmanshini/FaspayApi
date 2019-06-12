/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faspayapi.debit.entity.err;

/**
 *
 * @author hilmananwarsah
 */
public class UnregisteredError extends Error{
    UnregisteredErrorDef response_error;

    public UnregisteredErrorDef getResponse_error() {
        return response_error;
    }

    public void setResponse_error(UnregisteredErrorDef response_error) {
        this.response_error = response_error;
    }
    
}
