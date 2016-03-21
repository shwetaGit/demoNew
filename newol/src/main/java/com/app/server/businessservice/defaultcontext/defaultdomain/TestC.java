package com.app.server.businessservice.defaultcontext.defaultdomain;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.spartan.shield.sessionService.SessionDataMgtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.app.shared.organizationboundedcontext.location.Country;

@Component
public class TestC {

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private SessionDataMgtService sessionService;

    public void proTestC(Country entity) throws Exception {
        sessionService.setSessionAttribute("countryId", entity.getCountryId());
    }
}
