package testprj.app.server.service.defaultcontext.defaultdomain.service;
import com.athena.framework.server.bean.ResponseBean;
import com.athena.framework.server.exception.biz.SpartanBusinessValidationFailedException;
import com.athena.framework.server.exception.biz.SpartanDataNotFoundException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import testprj.app.server.businessservice.defaultcontext.defaultdomain.UpdateDateService;
import testprj.app.shared.defaultdomain.PersonalInfo;

@RestController
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@RequestMapping("/UpdateDateServiceWS")
public class UpdateDateServiceWS {

    @Autowired
    private UpdateDateService updatedateservice;

    @RequestMapping(value = "/updateDateMethod", consumes = "application/json", method = RequestMethod.POST)
    public HttpEntity<ResponseBean> updateDateMethod(@RequestBody PersonalInfo entity) throws Exception, SpartanBusinessValidationFailedException, SpartanDataNotFoundException, SpartanIncorrectDataException, SpartanPersistenceException {
        com.athena.framework.server.bean.ResponseBean responseBean = new com.athena.framework.server.bean.ResponseBean();
        org.springframework.http.HttpStatus httpStatus = org.springframework.http.HttpStatus.CREATED;
        updatedateservice.updateDateMethod(entity);
        responseBean.add("success", true);
        responseBean.add("message", "Successfully executed ");
        return new org.springframework.http.ResponseEntity<com.athena.framework.server.bean.ResponseBean>(responseBean, httpStatus);
    }
}
