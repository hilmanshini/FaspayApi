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
import faspayapi.credit.entity.void_transaction.VoidRequestWrapperDev;
import faspayapi.credit.entity.void_transaction.VoidRequestWrapperProd;
import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;
import org.junit.Test;

/**
 *
 * @author hilmananwarsah
 */
public class TestVoidPayment extends InBrowserTest{
    @Test
    public void e(){
        String html = new VoidRequestWrapperProd(new TetsUser2(), "5a49f6787ae2405d9be2733fb2f46b82", "315F1D29-3760-46FB-9406-6D1EC3C38B03", 100000, "merhcant test CC", "haha@haha.com", "ddddd ", "https://programmermiskin.chickenkiller.com/faspay/api/notify").generateHtml();
        try {
            File temp = File.createTempFile(UUID.randomUUID().toString(), ".html");

            FileOutputStream fos = new FileOutputStream(temp);
            fos.write(html.getBytes());
            fos.flush();
            fos.close();
            System.out.println();
            openFile(temp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
