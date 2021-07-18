package com.ynz.demo.springtestcontextconfiguration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

@Slf4j
public class ExternalResource implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        log.info("external init. for the test context");

        log.info("application context"+applicationContext.getApplicationName());
    }

}
