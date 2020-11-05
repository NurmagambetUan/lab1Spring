//package net.alterapp.miniproject.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//@Configuration
//@EnableSwagger2
//public class Swagger {
//    /**
//     * Create configuration for Swagger UI. You can change configuration of generation doc view.
//     *
//     * <p>FHtml page is available on "/swagger-ui.html". Swagger api_doc is on "/v2/api-docs"</p>
//     *
//     * @return Docket config
//     */
//    @Bean
//    public Docket productApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .useDefaultResponseMessages(false)
//                .select()
//                .paths(PathSelectors.any())
//                .apis(RequestHandlerSelectors.basePackage("net.alterapp.miniproject.controller"))
//                .build();
//    }
//}