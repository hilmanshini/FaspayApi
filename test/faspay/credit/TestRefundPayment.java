/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faspay.credit;

import faspayapi.credit.TetsUser2;
import faspayapi.credit.TetsUser;
import faspayapi.credit.entity.capture.CaptureRequestWrapperDev;
import faspayapi.credit.entity.refund.RefundRequestWrapperDev;
import faspayapi.credit.entity.refund.RefundRequestWrapperProd;
import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;
import org.junit.Test;

/**
 *
 * @author hilmananwarsah
 */
public class TestRefundPayment extends InBrowserTest{
    @Test
   public void e(){
//       let merchant_tranId = "64ddf6a2dc1347dca59c029e8ea52e30";
//        let tranId = "FA9A8C87-A5C0-480C-88E2-1C48DC0D55B9";
        String html = new RefundRequestWrapperProd(new TetsUser2(), "64ddf6a2dc1347dca59c029e8ea52e30", "FA9A8C87-A5C0-480C-88E2-1C48DC0D55B9", 100000, "merhcant test CC", "haha@haha.com", "ddddd ", "https://programmermiskin.chickenkiller.com/faspay/api/notify", 100000).generateHtml();
        try {
            File temp = File.createTempFile(UUID.randomUUID().toString(), ".html");

            FileOutputStream fos = new FileOutputStream(temp);
            fos.write(html.getBytes());
            fos.flush();
            fos.close();
            System.out.println();
            System.out.println(temp.getAbsolutePath());
            openFile(temp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
