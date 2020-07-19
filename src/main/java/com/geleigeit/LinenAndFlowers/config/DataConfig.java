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
@EnableJpaRepositories("com.geleigeit.LinenAndFlowers.repositories")
public class DataConfig {

        @Bean
        public DataSource getDataSource() {
            DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
            dataSourceBuilder.driverClassName("spring.datasource.driver-class-name");
            dataSourceBuilder.username("spring.datasource.username");
            dataSourceBuilder.password("spring.datasource.password");
            dataSourceBuilder.url("spring.datasource.url");

            return DataSourceBuilder.create().build();
        }

        @Bean
        public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
            LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
            entityManagerFactoryBean.setDataSource(getDataSource());
            entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
            entityManagerFactoryBean.setPackagesToScan("EM_package_to_scan");

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
            properties.put("driver_class", "hibernate.connection.driver_class");
            properties.put("show_sql", "spring.jpa.show-sql");
            properties.put("hbm2ddl", "hibernate.hbm2ddl.auto");

            return properties;
        }
}
