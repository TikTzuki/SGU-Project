package com.javabyexamples.spring.core.componentscan.scan;

import com.javabyexamples.spring.core.componentscan.level1.level2.MockRepository;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(
          DefaultComponentScanConfiguration.class);

        applicationContext.getBean(MockRepository.class);

        applicationContext.close();
    }
}
