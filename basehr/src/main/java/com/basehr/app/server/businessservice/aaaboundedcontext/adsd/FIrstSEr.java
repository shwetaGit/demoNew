package com.basehr.app.server.businessservice.aaaboundedcontext.adsd;
import org.springframework.stereotype.Service;
import com.athena.deo.camel.utility.ExternalIntegrationCaller;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class FIrstSEr {

    @Autowired
    private ExternalIntegrationCaller externalIntegrationCaller;

    public void getData() throws Exception {
        try {
            java.util.HashMap map = new java.util.HashMap();
            externalIntegrationCaller.executeRoute("77F0FD97-8096-4CD3-A811-606C5F07884B", map);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
