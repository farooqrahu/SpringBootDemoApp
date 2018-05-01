package com.app.login.config;

import org.apache.commons.lang3.CharEncoding;
import org.springframework.context.annotation.*;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

/**
 * ThymeleafConfiguration
 * @author Megadotnet
 * @date 2018-03-07
 */
@Configuration
public class ThymeleafConfiguration {

    @Bean
    @Description("Thymeleaf template resolver serving HTML 5 emails")
    public ClassLoaderTemplateResolver emailTemplateResolver() {
        ClassLoaderTemplateResolver emailTemplateResolver = new ClassLoaderTemplateResolver();
        emailTemplateResolver.setPrefix("mails/");
        emailTemplateResolver.setSuffix(".html");
        emailTemplateResolver.setTemplateMode("HTML5");
        emailTemplateResolver.setCharacterEncoding(CharEncoding.UTF_8);
        emailTemplateResolver.setOrder(1);
        return emailTemplateResolver;
    }
}
