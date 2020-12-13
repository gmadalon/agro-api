package br.com.mgn.agro;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


@SpringBootApplication
@EnableCaching
public class AgroApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgroApiApplication.class, args);
	}
	@Bean
	public Docket swagger() {
		ApiInfo apiInfo = new ApiInfo ("Agro API", "Methods of agro API.", "0.0.1", "", ApiInfo.DEFAULT_CONTACT,
		"", "", new ArrayList<>());
    return new Docket(DocumentationType.OAS_30)
			.apiInfo(apiInfo)
			.select()
		    .apis(RequestHandlerSelectors.basePackage("br.com.mgn.agro"))
            .paths(PathSelectors.any())
            .build()
            .useDefaultResponseMessages(false);
	}

}
