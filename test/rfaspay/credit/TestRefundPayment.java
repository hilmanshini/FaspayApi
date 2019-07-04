/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rfaspay.credit;

import faspayapi.credit.TetsUser;
import faspayapi.credit.TetsUser2;
import faspayapi.credit.entity.capture.CaptureRequestWrapperDev;
import faspayapi.credit.entity.refund.RefundRequestWrapperDev;
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
        String html = new RefundRequestWrapperDev(new TetsUser2(), "d5868d24410a4238ab9938f8527c83f7", "35124DAD-BD95-4B6E-9B71-6C8B45BC5147", 100000, "merhcant test CC", "haha@haha.com", "ddddd ", "https://programmermiskin.chickenkiller.com/faspay/api/notify",10000).generateHtml();
        try {
            File temp = File.createTempFile(UUID.randomUUID().toString(), ".html");

            FileOutputStream fos = new FileOutputStream(temp);
            fos.write(html.getBytes());
            fos.flush();
            fos.close();
            System.out.println(temp.getAbsolutePath());
            openFile(temp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
