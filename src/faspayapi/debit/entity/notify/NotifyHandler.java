/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faspayapi.debit.entity.notify;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author hilmananwarsah
 */
public class NotifyHandler {
    
    public void handle(String raw, Writer res) {
        try {
            FaspayXMLResponse e = new XmlMapper().readValue((raw), FaspayXMLResponse.class);
            new XmlMapper().writeValue(res, new FaspayTraceSuccessXMLResponse(e));
        } catch (IOException ex) {
            Logger.getLogger(NotifyHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void handle(InputStream raw, Writer res) {
        try {
            handle(IOUtils.toString(raw), res);
        } catch (IOException ex) {
            Logger.getLogger(NotifyHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
;
        
    }
}
