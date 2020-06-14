package org.dev.application.config;

import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CxfConfiguration {
    private static final String URL_MAPPING = "/*";

    @Bean
    public ServletRegistrationBean<?> cxfServlet() {
        return new ServletRegistrationBean<>(new CXFServlet(), URL_MAPPING);
    }
}
