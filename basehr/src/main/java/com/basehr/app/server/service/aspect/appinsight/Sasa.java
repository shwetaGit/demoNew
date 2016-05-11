package com.basehr.app.server.service.aspect.appinsight;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import com.athena.server.email.dsservice.NotificationDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
@Component
public class Sasa {

    @Autowired
    private NotificationDomainService notificationdomainservice;

    @Before("beforeauthenticate()")
    public void beforeAuthenticateServiceauthenticate(JoinPoint joinPoint) throws Throwable {
        notificationdomainservice.sendMail();
    }

    @Pointcut("execution(* com.spartan.shield.server.service.AuthenticateService.authenticate(..))")
    public void beforeauthenticate() {
    }
}
