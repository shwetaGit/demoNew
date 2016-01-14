package com.app.config;
import java.io.File;
import java.util.EnumSet;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.SessionTrackingMode;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import com.athena.config.appsetUp.model.AppConfiguration;

/**
 *
 *
 * @author Anant
 *
 */
@Configuration
public class WebInitializer implements WebApplicationInitializer {

    private final String APP_PKG = getPackage();

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        WebApplicationContext context = getContext();
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("DispatcherServlet", new DispatcherServlet(context));
        dispatcher.setAsyncSupported(true);
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/secure/*");
        servletContext.addListener(new ContextLoaderListener(context));
        servletContext.setSessionTrackingModes(EnumSet.of(SessionTrackingMode.COOKIE));
    }

    private AnnotationConfigWebApplicationContext getContext() {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setConfigLocation(APP_PKG);
        return context;
    }

    public void setSystemProperty(String propertyName, String propertyValue) {
        System.setProperty(propertyName, propertyValue);
    }

    public void setSolrDispatcher(ServletContext servletContext) {
        FilterRegistration.Dynamic dynaFilterReg = servletContext.addFilter("SolrRequestFilter", "org.apache.solr.servlet.SolrDispatchFilter");
        dynaFilterReg.addMappingForUrlPatterns(null, true, "/*");
    }

    public AppConfiguration appSetup(ServletContext servletContext) {
        com.athena.config.app.xmlParser.AppXMLLoader appXMLLoader = null;
        try {
            appXMLLoader = new com.athena.config.app.xmlParser.AppXMLLoader();
            appXMLLoader.loadAppProperties(new File(servletContext.getRealPath("/WEB-INF/conf/appConfiguration.xml")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return appXMLLoader.getAppConfiguration();
    }

    public String getSolrHome() {
        return "/home/applifire/workspace/customers/A1A4C59B-426C-4BCC-9018-F26D5BF4DF83/user/41268682-574E-47B9-B689-837647591A45/ZFXGXKLJJBAP6OPSUORG/solr-4.9.0";
    }

    public String getPackage() {
        return "com.app";
    }
}
