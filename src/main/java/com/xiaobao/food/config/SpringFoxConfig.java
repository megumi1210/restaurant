package com.xiaobao.food.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SpringFoxConfig {


    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.xiaobao.food"))  //需要扫描的包路径
                .paths(PathSelectors.ant("/**"))  //url匹配规则
                .build()
                .apiInfo(getApiInfo());  //api信息说明
    }

    private ApiInfo getApiInfo() {

        return new ApiInfo(
                "Xiaobao swagger Application",  //title
                "Xiaobao swagger Application.", //description
                "1.0.0",                        //version
                "TERMS OF SERVICE URL",
                new Contact("ChenJ", "http://www.xiaobaoonline.com/", "chenjinguo1210@gmail.com"),
                "MIT License",
                "LICENSE URL",
                Collections.emptyList()
        );
    }
}
