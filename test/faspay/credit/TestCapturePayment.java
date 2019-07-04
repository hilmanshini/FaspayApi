/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faspay.credit;

import faspayapi.credit.TetsUser;
import faspayapi.credit.TetsUser2;
import faspayapi.credit.entity.capture.CaptureRequestWrapperDev;
import faspayapi.credit.entity.capture.CaptureRequestWrapperProd;
import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hilmananwarsah
 */
public class TestCapturePayment extends InBrowserTest {

    public TestCapturePayment() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {

    }
    public void TestUserBaruCredit() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void hello() {
        //String html = new CaptureRequestWrapperDev(new TetsUser2(), "c0f4dbe47d27490e81a03ee771be6b47", "110B90DB-DA6C-4FEC-8ACD-C1DBF78A2E61", 100000, "merhcant test CC", "haha@haha.com", "ddddd ", "https://programmermiskin.chickenkiller.com/faspay/api/notify").generateHtml();
        String html = new CaptureRequestWrapperProd(new TestUserBaruCredit(), "c0f4dbe47d27490e81a03ee771be6b47", "110B90DB-DA6C-4FEC-8ACD-C1DBF78A2E61", 10000, "ha", "haha@haha.com", "ddddd ", "https://programmermiskin.chickenkiller.com/faspay/api/notify").generateHtml();
        try {
            File temp = File.createTempFile(UUID.randomUUID().toString(), ".html");

            FileOutputStream fos = new FileOutputStream(temp);
            fos.write(html.getBytes());
            fos.flush();
            fos.close();
            System.out.println();
            System.out.println(temp.getAbsolutePath());
           // openFile(temp);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
