//package net.alterapp.miniproject.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class MvcConfig implements WebMvcConfigurer {
//    public void addViewControllers(ViewControllerRegistry registry) {
//       registry.addViewController("/signin").setViewName("Login");
//       registry.addRedirectViewController("/", "/home");
//       registry.addRedirectViewController("/swagger", "/swagger-ui.html");
//    }
//}