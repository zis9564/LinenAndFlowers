package com.geleigeit.LinenAndFlowers.config;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.geleigeit.LinenAndFlowers")
@EnableJpaRepositories("com.geleigeit.repository.LinenAndFlowers")
public class DataConfig {

    private static final String PROP_DATABASE_DRIVER = "DB_driver";
    private static final String PROP_DATABASE_URL = "DB_URL";
    private static final String PROP_DATABASE_USERNAME = "DB_username";
    private static final String PROP_DATABASE_PASSWORD = "DB_password";
    private static final String PROP_HIBERNATE_DIALECT = "Hibernate_dialect";
    private static final String PROP_HIBERNATE_SHOW_SQL = "Hibernate_show_SQL";
    private static final String PROP_HIBERNATE_HBM2DDL_AUTO = "Hibernate_HBM2DDL_auto";
    private static final String PROP_ENTITYMANAGER_PACKAGES_TO_SCAN = "EM_package_to_scan";

    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(PROP_DATABASE_DRIVER);
        dataSourceBuilder.url(PROP_DATABASE_URL);
        dataSourceBuilder.username(PROP_DATABASE_USERNAME);
        dataSourceBuilder.password(PROP_DATABASE_PASSWORD);
        return dataSourceBuilder.build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(getDataSource());
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        entityManagerFactoryBean.setPackagesToScan(PROP_ENTITYMANAGER_PACKAGES_TO_SCAN);

        entityManagerFactoryBean.setJpaProperties(getHibernateProperties());

        return entityManagerFactoryBean;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

        return transactionManager;
    }

    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", PROP_HIBERNATE_DIALECT);
        properties.put("hibernate.show_sql", PROP_HIBERNATE_SHOW_SQL);
        properties.put("hibernate.hbm2ddl.auto", PROP_HIBERNATE_HBM2DDL_AUTO);
        return properties;
    }

}
