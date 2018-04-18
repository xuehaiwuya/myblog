package com.studyinghome.myblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author tt
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.studyinghome.myblog"})
@ServletComponentScan(basePackages = {"com.studyinghome.myblog"})
public class Application {
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
