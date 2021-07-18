## ContextConfiguration

_@ContextConfiguration_ defines class-level metadata that is used to determine how to load and configure an ApplicationContext for **integration tests**.

The application context initializer classes implement Callback methods for initializing a ConfigurableApplicationContext. They leave entry points to configure the application 
context during an application context start up stage. The initializer can only work with a ConfigurableApplicationContext.

````
 static class TestResources implements ApplicationContextInitializer<ConfigurableApplicationContext> {

        @Override
        public void initialize(ConfigurableApplicationContext applicationContext) {
            TestPropertyValues.of(
                    "spring.datasource.url=" + postgreSQLContainer.getJdbcUrl(),
                    "spring.datasource.username=" + postgreSQLContainer.getUsername(),
                    "spring.datasource.password=" + postgreSQLContainer.getPassword()
            ).applyTo(applicationContext.getEnvironment());
        }
    }
````
Within callback method, we may re-config data source properties in a run time. 

## DB init
Spring Boot can automatically create the schema (DDL scripts) of your DataSource and initialize it (DML scripts). 
It loads SQL from the standard root classpath locations: **schema.sql** and **data.sql**, respectively. In addition, 
Spring Boot processes the schema-${platform}.sql and data-${platform}.sql files (if present), where platform is the 
value of **spring.datasource.platform**. This allows you to switch to database-specific scripts if necessary. For example, 
you might choose to set it to the vendor name of the database (hsqldb, h2, oracle, mysql, postgresql, and so on).

Spring Boot automatically creates the schema of an embedded DataSource. This behavior can be customized by using 
the **spring.datasource.initialization-mode** property. For instance, if you want to always initialize the DataSource 
regardless of its type:

**spring.datasource.initialization-mode=always**

Enum DataSourceInitializationMode: 
* ALWAYS:Always initialize the datasource.
* EMBEDDED:Only initialize an embedded datasource.
* NEVER:Do not initialize the datasource.

By default, Spring Boot enables the fail-fast feature of the Spring JDBC initializer. This means that, if the scripts 
cause exceptions, the application fails to start. You can tune that behavior by setting spring.datasource.continue-on-error.

In a JPA-based app, you can choose to let Hibernate create the schema or use schema.sql, but you cannot do both. 
Make sure to disable spring.jpa.hibernate.ddl-auto if you use schema.sql.
