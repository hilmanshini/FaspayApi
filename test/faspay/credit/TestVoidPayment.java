/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faspay.credit;

import faspayapi.credit.entity.void_transaction.VoidRequestWrapperProd;
import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;
import org.junit.Test;

/**
 *
 * @author hilmananwarsah
 */
public class TestVoidPayment extends InBrowserTest {

    public TestVoidPayment() {
    }
    public void TestUserBaruCredit() {
    }

    @Test
    public void e(){
        //String html = new VoidRequestWrapperDev(new TestUserBaruCredit(), "c0f4dbe47d27490e81a03ee771be6b47", "110B90DB-DA6C-4FEC-8ACD-C1DBF78A2E61", 10000, "ha", "haha@haha.com", "ddddd ", "https://programmermiskin.chickenkiller.com/faspay/api/notify").generateHtml();
        String html = new VoidRequestWrapperProd(new TestUserBaruCredit(), "e5f95232e08446cabda1b10ce6deb579", "042621B9-0FE3-4FDD-9350-97A4C931FF85", 10000, "ha", "haha@haha.com", "ddddd ", "https://programmermiskin.chickenkiller.com/faspay/api/notify").generateHtml();
        
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
