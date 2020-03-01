package com.UploadDir.Configurations;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/*
- DispatcherServlet can be configured programmatically by implementing or extending either of these three support classes provided by Spring:

1/WebAppInitializer interface
2/AbstractDispatcherServletInitializer abstract class
3/AbstractAnnotationConfigDispatcherServletInitializer abstract class

- by using the last one web application context +root application context will be created automatically without many lines of code.

-configure root application context by getRootConfigClasses()

-configure web application context using getServletConfigClasses()

-we configure the Spring dispatcher servlet to the / path, which rewrites the default servlet's one. We enable the default servlet with DefaultServletHandlerConfigurer.

 */
public class WebIntializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{com.UploadDir.Configurations.AppConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{com.UploadDir.Configurations.WebMvcConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
            return new String[] { "/" };
    }
}
