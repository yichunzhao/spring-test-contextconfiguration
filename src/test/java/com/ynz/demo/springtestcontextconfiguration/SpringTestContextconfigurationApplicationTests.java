package com.ynz.demo.springtestcontextconfiguration;

import lombok.RequiredArgsConstructor;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * for webApplication, @ContextConfiguration is used to initialise ApplicationContext programmatically
 *
 * An initializer is a callback class, leaving client an entry point to configure the application context.
 */

@SpringBootTest
@ContextConfiguration(initializers = {ExternalResource.class})
@RequiredArgsConstructor
class SpringTestContextconfigurationApplicationTests {

    private final ConfigurableApplicationContext context;

    @Test
    void contextLoads() {
        assertThat(context, Matchers.notNullValue());
    }

    @Test
    void shouldExternalResourceCreated(){
        List<String> beanNames =  Arrays.asList(context.getBeanDefinitionNames());


        assertThat(beanNames, Matchers.hasItem("externalResource"));
    }

}
