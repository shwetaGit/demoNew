package com.app.server.service.appinsight.health;
import com.app.server.businessservice.appinsight.health.DnewQDs;
import com.app.shared.appinsight.health.Adto;
import com.athena.server.pluggable.utils.bean.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@RequestMapping("/DnewQDsWS")
public class DnewQDsWS {

    @Autowired
    private DnewQDs dnewqds;

    @RequestMapping(value = "/proDnewQDs", consumes = "application/json", method = RequestMethod.POST)
    public HttpEntity<ResponseBean> proDnewQDs(@RequestBody Adto ss) throws Exception {
        com.athena.server.pluggable.utils.bean.ResponseBean responseBean = new com.athena.server.pluggable.utils.bean.ResponseBean();
        org.springframework.http.HttpStatus httpStatus = org.springframework.http.HttpStatus.CREATED;
        com.app.shared.appinsight.DNewQ _ruleOutput = dnewqds.proDnewQDs(ss);
        responseBean.add("success", true);
        responseBean.add("message", "Successfully executed ");
        responseBean.add("data", _ruleOutput);
        return new org.springframework.http.ResponseEntity<com.athena.server.pluggable.utils.bean.ResponseBean>(responseBean, httpStatus);
    }
}
