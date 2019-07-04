/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rfaspay.credit;

import faspayapi.credit.TetsUser;
import faspayapi.credit.TetsUser2;
import faspayapi.credit.entity.capture.CaptureRequestWrapperDev;
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void hello() {
        CaptureRequestWrapperDev x = new CaptureRequestWrapperDev(new TetsUser2(), "5a49f6787ae2405d9be2733fb2f46b82", "315F1D29-3760-46FB-9406-6D1EC3C38B03", 100000, "merhcant test CC", "haha@haha.com", "ddddd ", "https://programmermiskin.chickenkiller.com/faspay/api/notify");
        System.out.println(x.getSignature());
        String html = x.generateHtml();
        try {
            File temp = File.createTempFile(UUID.randomUUID().toString(), ".html");
            
            FileOutputStream fos = new FileOutputStream(temp);
            fos.write(html.getBytes());
            fos.flush();
            fos.close();
            System.out.println(html);
            openFile(temp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
