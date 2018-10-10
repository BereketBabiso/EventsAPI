package com.events.access.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	 private static final String SWAGGER_API_VERSION = "1.0";
	    private static final String LICENCE_TEXT = "LICENCE";
	    private static final String TITLE = "Events REST API";
	    private static final String DESCRIPTION = "RESTful API for Events Happening in Specific City";
	    private static final Contact CONTACT = new Contact("Bereket","http://www.altimetric.com","bereketb.y@gmail.com");
	    
	    
	    @Bean
	    public Docket swaggerDoc() {
	    	return new Docket(DocumentationType.SWAGGER_2)
    				.select()
    				.apis(RequestHandlerSelectors.basePackage("com.events.access"))
    				.paths(PathSelectors.regex("/api.*"))
    				.build()
    				.apiInfo(metaInfo());
	    	
	    }
	    
	    private ApiInfo metaInfo() {
	    	
	    	return new ApiInfo(TITLE,DESCRIPTION,SWAGGER_API_VERSION,"Terms of Service",CONTACT,LICENCE_TEXT,"https://www.apache.org/license");
	    }

}
