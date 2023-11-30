package com.example.servicebase;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration//配置类
@EnableSwagger2 //swagger注解
public class SwaggerConfig {

    @Bean
    public Docket webApiConfig(){
//        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        //API帮助文档的描述信息 =>  information
        ApiInfo apiInfo = new ApiInfoBuilder()
                //配置swagger文档主体内容 文档发布者名称、文档发布者的网站地址，请求路径、文档发布者的email点击可以发邮件
                .contact(new Contact(
                        "Swagger - 学习 ",
                        "http://localhost:8001/swagger-ui.html",
                        "test@xxx.com")
                )
                .title("Swagger 开发帮助文档 ")
                .description("Swagger 框架学习帮助文档详细描述：Swagger是一套围绕Open API 规范构建的开源工具，可以帮助设计，构建，记录和使用REST API...")
                .version("1.1")
                .build();
        //给docket上下文配置api描述信息
//        docket.apiInfo(apiInfo);
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .groupName("webApi")
                .apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors
                                //.any() // 扫描全部的接口，默认
                                //.none() // 全部不扫描
//                                .basePackage("com.example.eduservice.controller") // 扫描指定包下的接口，最为常用
                                .basePackage("com.example") // 扫描指定包下的接口，最为常用
                        //.withClassAnnotation(RestController.class) // 扫描带有指定注解的类下所有接口
                        //.withMethodAnnotation(PostMapping.class) // 扫描带有只当注解的方法接口

                )
                .paths(PathSelectors
                                .any() // 满足条件的路径，该断言总为true
                        //.none() // 不满足条件的路径，该断言总为false（可用于生成环境屏蔽 swagger）
                        //.ant("/user/**") // 满足字符串表达式路径
                        //.regex("") // 符合正则的路径
                )
                .paths(Predicates.not(PathSelectors.regex("/admin/.*")))
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build();
        return docket;
    }

//        return new Docket(DocumentationType.SWAGGER_2)
//                .groupName("webApi")
//                .apiInfo(webApiInfo())
//                .select()
//                .apis(RequestHandlerSelectors
//                                //.any() // 扫描全部的接口，默认
//                                //.none() // 全部不扫描
//                                .basePackage("com.example.eduservice.controller") // 扫描指定包下的接口，最为常用
//                        //.withClassAnnotation(RestController.class) // 扫描带有指定注解的类下所有接口
//                        //.withMethodAnnotation(PostMapping.class) // 扫描带有只当注解的方法接口
//
//                )
//                .paths(PathSelectors
//                                .any() // 满足条件的路径，该断言总为true
//                        //.none() // 不满足条件的路径，该断言总为false（可用于生成环境屏蔽 swagger）
//                        //.ant("/user/**") // 满足字符串表达式路径
//                        //.regex("") // 符合正则的路径
//                )
//                .paths(Predicates.not(PathSelectors.regex("/admin/.*")))
//                .paths(Predicates.not(PathSelectors.regex("/error.*")))
//                .build();
//
//    }

//    private ApiInfo webApiInfo(){
//
//        return new ApiInfoBuilder()
//                .title("网站-课程中心API文档")
//                .description("本文档描述了课程中心微服务接口定义")
//                .version("1.0")
//                .contact(new Contact("java", "http://example.com", "1123@qq.com"))
//                .build();
//    }
}
