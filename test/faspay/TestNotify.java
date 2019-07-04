/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faspay;

import faspayapi.debit.entity.notify.NotifyHandler;
import java.io.StringWriter;
import org.junit.Test;

/**
 *
 * @author hilmananwarsah
 */
public class TestNotify {

    String requestFromFaspay = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
            + "<faspay>\n"
            + "<request>Payment Notification</request>\n"
            + "<trx_id>8985310250011254</trx_id>\n"
            + "<merchant_id>31025</merchant_id>\n"
            + "<merchant>Faspay Online</merchant>\n"
            + "<bill_no>300134486</bill_no>\n"
            + "<payment_reff>null</payment_reff>\n"
            + "<payment_date>2017-08-10 11:43:18</payment_date>\n"
            + "<payment_status_code>2</payment_status_code>\n"
            + "<payment_status_desc>Payment Sukses</payment_status_desc>\n"
            + "<bill_total>5000000</bill_total>\n"
            + "<payment_total>5000000</payment_total>\n"
            + "<payment_channel_uid>402</payment_channel_uid>\n"
            + "<payment_channel>Permata Virtual Account</payment_channel>\n"
            + "<signature>9ed18926fa88f83b469f3ae73ef71ef2a4835c03</signature>\n"
            + "</faspay>";

    @Test

    public void test() {
        StringWriter st = new StringWriter();
        new NotifyHandler().handle(requestFromFaspay, st);
        System.out.println(st.toString());

    }
}
