/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faspayapi.rest;

import faspayapi.debit.entity.err.UnregisteredError;

/**
 *
 * @author hilmananwarsah
 */
public interface UnregisteredErrorCallback {
    public void onUserNotRegistered(UnregisteredError mUnregisteredError);
    
}
