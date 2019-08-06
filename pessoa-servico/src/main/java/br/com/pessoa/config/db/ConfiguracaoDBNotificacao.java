//package br.com.pessoa.config.db;
//
//import javax.persistence.EntityManagerFactory;
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(basePackages ="br.com.pessoa.dbnotificacao.repository", entityManagerFactoryRef = "productDSEmFactory", transactionManagerRef = "productDSTransactionManager")
//public class ConfiguracaoDBNotificacao {
//
//    @Bean
//    @ConfigurationProperties("spring.datasource2")
//    public DataSourceProperties productDSProperties() {
//        return new DataSourceProperties();
//    }
//
//    @Bean
//    public DataSource productDS(@Qualifier("productDSProperties") DataSourceProperties productDSProperties) {
//        return productDSProperties.initializeDataSourceBuilder().build();
//    }
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean productDSEmFactory(@Qualifier("productDS") DataSource productDS, EntityManagerFactoryBuilder builder) {
//        return builder.dataSource(productDS).packages("br.com.pessoa.dbnotificacao.model").build();
//    }
//
//    @Bean
//    public PlatformTransactionManager productDSTransactionManager(EntityManagerFactory productDSEmFactory) {
//        return new JpaTransactionManager(productDSEmFactory);
//    }
//
//}
