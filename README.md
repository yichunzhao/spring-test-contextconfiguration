Spring Boot can automatically create the schema (DDL scripts) of your DataSource and initialize it (DML scripts). 
It loads SQL from the standard root classpath locations: **schema.sql** and **data.sql**, respectively. In addition, 
Spring Boot processes the schema-${platform}.sql and data-${platform}.sql files (if present), where platform is the 
value of **spring.datasource.platform**. This allows you to switch to database-specific scripts if necessary. For example, 
you might choose to set it to the vendor name of the database (hsqldb, h2, oracle, mysql, postgresql, and so on).

Spring Boot automatically creates the schema of an embedded DataSource. This behavior can be customized by using 
the **spring.datasource.initialization-mode** property. For instance, if you want to always initialize the DataSource 
regardless of its type:

**spring.datasource.initialization-mode=always**

By default, Spring Boot enables the fail-fast feature of the Spring JDBC initializer. This means that, if the scripts 
cause exceptions, the application fails to start. You can tune that behavior by setting spring.datasource.continue-on-error.

In a JPA-based app, you can choose to let Hibernate create the schema or use schema.sql, but you cannot do both. 
Make sure to disable spring.jpa.hibernate.ddl-auto if you use schema.sql.