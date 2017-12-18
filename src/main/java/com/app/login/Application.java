package com.app.login;

import com.app.login.config.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Application
 * @author megadotnet
 * @date 2017-12-15
 */
@SpringBootApplication // 必须标明
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(Application.class);
        Environment env = app.run(args)
            .getEnvironment();
        String protocol = env.getProperty("server.protocol");
        try {
            log.info(Constants.STARTUP_LOG_MSG, env.getProperty("spring.application.name"), protocol, InetAddress.getLocalHost()
                .getHostAddress(), env.getProperty("server.port"));
        } catch (UnknownHostException e) {
            log.error(e.getMessage());
        }
    }
}
