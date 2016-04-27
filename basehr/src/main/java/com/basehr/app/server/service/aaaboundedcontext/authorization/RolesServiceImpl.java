package com.basehr.app.server.service.aaaboundedcontext.authorization;
import org.springframework.web.bind.annotation.RestController;
import com.athena.annotation.Complexity;
import com.athena.annotation.SourceCodeAuthorClass;
import com.basehr.app.server.businessservice.aaaboundedcontext.authorization.RolesBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import com.spartan.pluggable.logger.alarms.AppAlarm;
import com.spartan.pluggable.logger.api.LogManagerFactory;
import com.spartan.pluggable.logger.api.LogManager;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.basehr.app.server.repository.aaaboundedcontext.authorization.RolesRepository;
import com.basehr.app.shared.aaaboundedcontext.authorization.Roles;
import org.springframework.web.bind.annotation.RequestMapping;
import com.athena.framework.server.bean.ResponseBean;
import java.lang.Override;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.PathVariable;
import com.athena.framework.server.bean.FindByBean;

@RestController
@SourceCodeAuthorClass(createdBy = "root", updatedBy = "", versionNumber = "1", comments = "Service for Roles Transaction table", complexity = Complexity.MEDIUM)
@RequestMapping("/Roles")
public class RolesServiceImpl extends RolesService {

    @Autowired
    private RolesBusinessService rolesbz;

    private LogManager Log = LogManagerFactory.getInstance(System.getProperty("LOGGER_ID"));

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private RolesRepository<Roles> rolesrepo;

    @RequestMapping(value = "/findAll", consumes = "application/json", method = RequestMethod.GET)
    @Override
    public HttpEntity<ResponseBean> findAll() throws Exception {
        java.util.List<com.basehr.app.shared.aaaboundedcontext.authorization.Roles> lstroles = rolesrepo.findAll();
        AppAlarm appAlarm = Log.getAlarm("null");
        ResponseBean responseBean = new ResponseBean(appAlarm);
        responseBean.add("message", String.format(appAlarm.getMessage(), "Roles"));
        responseBean.add("data", lstroles);
        Log.out.println(appAlarm.getAlarmID(), runtimeLogInfoHelper.getRequestHeaderBean(), "RolesServiceImpl", "findAll", "Roles");
        return new org.springframework.http.ResponseEntity<ResponseBean>(responseBean, HttpStatus.valueOf(appAlarm.getAlarmStatus()));
    }

    @RequestMapping(consumes = "application/json", method = RequestMethod.POST)
    @Override
    public HttpEntity<ResponseBean> save(@RequestBody Roles entity) throws Exception {
        rolesrepo.save(entity);
        AppAlarm appAlarm = Log.getAlarm("null");
        ResponseBean responseBean = new ResponseBean(appAlarm);
        responseBean.add("message", String.format(appAlarm.getMessage(), "Roles"));
        responseBean.add("data", entity);
        Log.out.println(appAlarm.getAlarmID(), runtimeLogInfoHelper.getRequestHeaderBean(), "RolesServiceImpl", "save", "Roles");
        return new org.springframework.http.ResponseEntity<ResponseBean>(responseBean, HttpStatus.valueOf(appAlarm.getAlarmStatus()));
    }

    @RequestMapping(consumes = "application/json", headers = { "isArray" }, method = RequestMethod.POST)
    @Override
    public HttpEntity<ResponseBean> save(@RequestBody List<Roles> entity, @RequestHeader("isArray") boolean request) throws Exception {
        rolesrepo.save(entity);
        AppAlarm appAlarm = Log.getAlarm("null");
        ResponseBean responseBean = new ResponseBean(appAlarm);
        responseBean.add("message", String.format(appAlarm.getMessage(), "Roles"));
        Log.out.println(appAlarm.getAlarmID(), runtimeLogInfoHelper.getRequestHeaderBean(), "RolesServiceImpl", "save", "Roles");
        return new org.springframework.http.ResponseEntity<ResponseBean>(responseBean, HttpStatus.valueOf(appAlarm.getAlarmStatus()));
    }

    @RequestMapping(value = "/{cid}", consumes = "application/json", method = RequestMethod.DELETE)
    @Override
    public HttpEntity<ResponseBean> delete(@PathVariable("cid") String entity) throws Exception {
        rolesrepo.delete(entity);
        AppAlarm appAlarm = Log.getAlarm("null");
        ResponseBean responseBean = new ResponseBean(appAlarm);
        responseBean.add("message", String.format(appAlarm.getMessage(), "Roles"));
        Log.out.println(appAlarm.getAlarmID(), runtimeLogInfoHelper.getRequestHeaderBean(), "RolesServiceImpl", "delete", "Roles");
        return new org.springframework.http.ResponseEntity<ResponseBean>(responseBean, HttpStatus.valueOf(appAlarm.getAlarmStatus()));
    }

    @RequestMapping(consumes = "application/json", method = RequestMethod.PUT)
    @Override
    public HttpEntity<ResponseBean> update(@RequestBody Roles entity) throws Exception {
        rolesbz.update(entity);
        AppAlarm appAlarm = Log.getAlarm("null");
        ResponseBean responseBean = new ResponseBean(appAlarm);
        responseBean.add("message", String.format(appAlarm.getMessage(), "Roles"));
        responseBean.add("data", entity._getPrimarykey());
        Log.out.println(appAlarm.getAlarmID(), runtimeLogInfoHelper.getRequestHeaderBean(), "RolesServiceImpl", "update", "Roles");
        return new org.springframework.http.ResponseEntity<ResponseBean>(responseBean, HttpStatus.valueOf(appAlarm.getAlarmStatus()));
    }

    @RequestMapping(consumes = "application/json", headers = { "isArray" }, method = RequestMethod.PUT)
    @Override
    public HttpEntity<ResponseBean> update(@RequestBody List<Roles> entity, @RequestHeader("isArray") boolean request) throws Exception {
        rolesbz.update(entity);
        AppAlarm appAlarm = Log.getAlarm("null");
        ResponseBean responseBean = new ResponseBean(appAlarm);
        responseBean.add("message", String.format(appAlarm.getMessage(), "Roles"));
        Log.out.println(appAlarm.getAlarmID(), runtimeLogInfoHelper.getRequestHeaderBean(), "RolesServiceImpl", "update", "Roles");
        return new org.springframework.http.ResponseEntity<ResponseBean>(responseBean, HttpStatus.valueOf(appAlarm.getAlarmStatus()));
    }

    @RequestMapping(value = "/findById", method = RequestMethod.POST)
    @Override
    public HttpEntity<ResponseBean> findById(@RequestBody FindByBean findByBean) throws Exception {
        org.springframework.http.HttpStatus httpStatus = org.springframework.http.HttpStatus.OK;
        com.basehr.app.shared.aaaboundedcontext.authorization.Roles lstroles = rolesrepo.findById((java.lang.String) findByBean.getFindKey());
        AppAlarm appAlarm = Log.getAlarm("null");
        com.athena.framework.server.bean.ResponseBean responseBean = new ResponseBean(appAlarm);
        responseBean.add("message", String.format(appAlarm.getMessage(), "Roles"));
        responseBean.add("data", lstroles);
        Log.out.println("null", runtimeLogInfoHelper.getRequestHeaderBean(), "RolesServiceImpl", "save", "Roles");
        return new org.springframework.http.ResponseEntity<ResponseBean>(responseBean, HttpStatus.valueOf(appAlarm.getAlarmStatus()));
    }
}
