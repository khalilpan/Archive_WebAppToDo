package com.khalilpan;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//to use swagger in browser==> http://localhost:8080/swagger-ui.html#/
//and to get all the documentation of api  ==> http://localhost:8080/v2/api-docs

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	//Bean Docket
		@Bean
		public Docket api() {
			return new Docket(DocumentationType.SWAGGER_2);
		}
	
}
