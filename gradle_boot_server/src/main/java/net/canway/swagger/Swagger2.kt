package net.canway.swagger

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

/**
 * @author eltons
 */
@Configuration
//启用swagger2的注解
@EnableSwagger2
open class Swagger2 {

    @Bean
    open fun createRestApi(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()         // 选择那些路径和api会生成document
                //                .apis(RequestHandlerSelectors.basePackage("net.canway.controller"))
                .apis(RequestHandlerSelectors.any()) // 对所有api进行监控
                .paths(PathSelectors.any())   // 对所有路径进行监控
                .build()
    }

    private fun apiInfo(): ApiInfo {
        return ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建RESTful APIs")
                .description("定义了一些简单的接口来实现Springboot+Jersey+swagger")
                .termsOfServiceUrl("localhost:7070")
                .contact("elton")
                .version("1.0")
                .build()
    }
}
