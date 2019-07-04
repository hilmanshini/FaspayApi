/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rfaspay.credit;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hilmananwarsah
 */
public class InBrowserTest {

    protected void openFile(File temp) throws IOException {
        String OS = System.getProperty("os.name").toLowerCase();

        if ((OS.indexOf("win") >= 0)) {
            File htmlFile = new File(temp.getAbsolutePath());
            Desktop.getDesktop().browse(htmlFile.toURI());
            Runtime.getRuntime().exec("start " + temp.getAbsolutePath());
        } else if ((OS.indexOf("mac") >= 0)) {
            Runtime.getRuntime().exec("open " + temp.getAbsolutePath());
        } else if ((OS.indexOf("nix") >= 0)) {
            Runtime.getRuntime().exec("chrome " + temp.getAbsolutePath());
        }

//        try (final WebClient webClient = new WebClient()) {
//
//            // Get the first page
//             HtmlPage page1 = webClient.getPage("file://" + temp.getAbsolutePath());
//            System.out.println( page1.getElementByName("cardName").getClass());
//            HtmlTextInput e = page1.getElementByName("cardName");
//            
//            e.setText("5123456789012346");
//            
//            e = page1.getElementByName("cardNo");
//            e.setText("5123456789012346");
//            
//            e = page1.getElementByName("expiry");
//            e.setText("05/21");
//
//            HtmlPasswordInput p = page1.getElementByName("cvv2");
//            p.setText("105");
//            HtmlSubmitInput button =  (HtmlSubmitInput) page1.getElementById("sbmtbutton");
//            page1 = button.click();
//            
//            // Get the form that we are dealing with and within that form, 
//            // find the submit button and the field that we want to change.
//            System.out.println(page1.getWebResponse().getContentAsString());
//        } catch (IOException ex) {
//            Logger.getLogger(TestCreatePayment.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (FailingHttpStatusCodeException ex) {
//            Logger.getLogger(TestCreatePayment.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    protected void openHtml(String html) {
        try {
            File temp = File.createTempFile(UUID.randomUUID().toString(), ".html");

            FileOutputStream fos = new FileOutputStream(temp);
            fos.write(html.getBytes());
            fos.flush();
            fos.close();
            openFile(temp);
        } catch (IOException ex) {
            Logger.getLogger(TestCreatePayment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
