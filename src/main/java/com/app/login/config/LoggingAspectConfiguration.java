package com.app.login.config;

import com.app.login.aop.logging.LoggingAspect;

import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

/**
 * LoggingAspectConfiguration
 * @author Megadotnet
 * @date 2018-03-07
 */
@Configuration
@EnableAspectJAutoProxy
public class LoggingAspectConfiguration {

    @Bean
    public LoggingAspect loggingAspect(Environment env) {
        return new LoggingAspect(env);
    }
}
