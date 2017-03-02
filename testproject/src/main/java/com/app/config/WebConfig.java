package com.app.config;
import com.app.config.appSetup.model.AppConfiguration;

import com.app.config.appSetup.xmlParser.AppXMLLoader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy
@ImportResource({ "classpath:springConfig.xml" })
public class WebConfig extends WebMvcConfigurerAdapter {

	@Autowired
	private ResourceLoader resourceLoader;

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	}

	/**
	 * Bean to create ContentNegotiatingViewResolver object
	 */
	@Override
   	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
   		super.configureContentNegotiation(configurer);
   		configurer.mediaType("html", org.springframework.http.MediaType.TEXT_HTML);
   		configurer.mediaType("json", org.springframework.http.MediaType.APPLICATION_JSON);
   	}

	/**
	 * Bean to create PropertySourcesPlaceholderConfigurer object
	 */
	@Bean
	public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	/**
	 * Bean to create AppConfiguration object by parsing appConfiguration.xml
	 * file
	 **/
	@Bean(name = "appConfig")
	public AppConfiguration appConfiguration() throws IOException {
		AppXMLLoader xmlLoader = new AppXMLLoader();
		final File appSetup = resourceLoader.getResource("WEB-INF/conf/appConfiguration.xml").getFile();
		xmlLoader.loadAppProperties(appSetup);
		return xmlLoader.getAppConfiguration();
	}

	/**
	 * Bean to create basic data source
	 * 
	 * @param AppConfiguration
	 */
	@Bean(destroyMethod = "close")
	public BasicDataSource dataSource(@Qualifier("appConfig") AppConfiguration appConfig) throws IOException {
		AppBasicDataSource myDs = new AppBasicDataSource(appConfig.getDatabaseConfig().getConnectionConfig().getDriverName(), appConfig.getDatabaseConfig().getConnectionConfig()
				.getUrl().trim(), appConfig.getDatabaseConfig().getConnectionConfig().getUserName(), appConfig.getDatabaseConfig().getConnectionConfig().getPassword());
		return myDs;
	}

}
