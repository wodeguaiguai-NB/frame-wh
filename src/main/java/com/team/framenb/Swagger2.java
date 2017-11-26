package com.team.framenb;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger2配置类
 *
 * @author haohao
 * @create 2017/11/25 下午2:55
 **/
@Configuration
@EnableSwagger2
public class Swagger2 {

    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                        .apiInfo(apiInfo())
                        .select()
                        .apis(RequestHandlerSelectors.basePackage("com.team.framenb.controller"))
                        .paths(PathSelectors.any())
                        .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                        .title("Spring Boot中使用Swagger2构建RESTful APIs")
                        .description("frame-nb RESTApi")
                        .contact("我得怪怪")
                        .version("1.0")
                        .build();
    }
}
