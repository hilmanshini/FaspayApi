/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faspayapi.debit.rest.inquiry;

import faspayapi.debit.FaspayConfigDebit;
import faspayapi.debit.entity.FaspayPaymentChannel;
import faspayapi.rest.ApiServiceImpl;
import faspayapi.rest.UnregisteredErrorCallback;
import java.util.List;

/**
 *
 * @author hilmananwarsah
 */
public interface FaspayInquiryPCService {

    public void inquiryPaymentChannel(FaspayInquiryServiceCallback mCallback);
    

    public interface FaspayInquiryServiceCallback extends  UnregisteredErrorCallback {

        public void onGetPaymentChannel(List<FaspayPaymentChannel> channel);

        void onErrorGetPaymentChannel(Exception e);
    }
    
}
