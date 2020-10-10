package com.seenda.basic.member.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${swagger.config.basePackage}")
    private String basePackage;

    @Value("${swagger.config.title}")
    private String title;

    @Value("${swagger.config.description}")
    private String description;

    @Value("${swagger.config.version}")
    private String version;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)    //指定API类型为swagger2
                .apiInfo(apiInfo())                        //用于定义API文档的相关信息
                .select()//
                .apis(RequestHandlerSelectors.basePackage(basePackage)) //指定controller层包名
                .paths(PathSelectors.any())                //应用于所有的controller
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()//
                .title(title)                //API文档的标题
                .description(description)    //关于这个文档作用的描述
                .version(version)            //设置当前API文档的版本号
                .build();
    }
}
