package com.UploadDir.Configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*- Adding this annotation to a @Configuration class imports the Spring MVC configuration from WebMvcConfigurationSupport which is the main class providing the configuration behind the MVC Java config.
note:@EnableWebMvc and <mvc:annotation-driven /> have the same purpose.

- To customize the configuration imported by @EnableWebMvc, we should extend the class WebMvcConfigurerAdapter and override the methods we want to do related customization with. Our extended WebMvcConfigurerAdapter methods
are called back from WebMvcConfigurationSupport during configuration stage. Note that WebMvcConfigurerAdapter has been deprecated since 5.0, so there we should implement WebMvcConfigurer alternatively.

- configureViewResolvers Resolves view names to views.
- We register the Spring DispatcherServlet to the / path. This replaces the DefaultServlet; therefore we have to register a default servlet handler in the configuration file.
The configureDefaultServletHandling() configures a DefaultServletHttpRequestHandler with a URL mapping of /** and the lowest priority relative to other URL mappings. This way the static resource requests are handled by the
container's default Servlet.

-MultipartResolver Bean: to Parse the given HTTP request into multipart files and parameters, and wrap the request inside a MultipartHttpServletRequest object that provides access to file descriptors and makes contained parameters accessible via the standard ServletRequest methods.
because There is no default resolver implementation used for Spring DispatcherServlets, as an application might choose to parse its multipart requests itself. To define an implementation, create a bean with the id "multipartResolver" in a DispatcherServlet's application context. Such a resolver gets applied to all requests handled by that DispatcherServlet.
for more info check https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/web/multipart/MultipartResolver.html
-setMaxUploadSize : Set the maximum allowed size (in bytes) before an upload gets rejected. -1 indicates no limit (the default).
-setMaxUploadSizePerFile : Set the maximum allowed size (in bytes) for each individual file before an upload gets rejected. -1 indicates no limit (the default).


 */

@Configuration
@EnableWebMvc
@ComponentScan(value = {"com.UploadDir"})
@PropertySource("classpath:Application.properties")
public class WebMvcConfiguration implements WebMvcConfigurer {

    private static final String VIEWS = "/WEB-INF/views/";

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp(VIEWS, ".jsp");
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver multipartResolver() {
    CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
    multipartResolver.setMaxUploadSize(100000);
    return multipartResolver;
    }


}
