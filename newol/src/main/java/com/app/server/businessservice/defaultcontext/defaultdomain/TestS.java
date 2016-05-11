package com.app.server.businessservice.defaultcontext.defaultdomain;
import com.app.server.repository.organizationboundedcontext.location.StateRepository;
import com.app.shared.organizationboundedcontext.location.State;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.spartan.shield.sessionService.SessionDataMgtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.athena.framework.server.exception.biz.SpartanDataNotFoundException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;
import java.util.List;

@Component
public class TestS {

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private SessionDataMgtService sessionService;

    public List<State> proTestS() throws SpartanPersistenceException, SpartanDataNotFoundException, Exception {
        java.lang.String countryIdFromSession = (java.lang.String) sessionService.getSessionData("countryId");
        if (countryIdFromSession == null) {
            throw new com.athena.framework.server.exception.biz.SpartanDataNotFoundException("Data not found in session");
        }
        java.util.List<com.app.shared.organizationboundedcontext.location.State> stateList = stateRepository.findByCountryId(countryIdFromSession);
        return stateList;
    }
}
