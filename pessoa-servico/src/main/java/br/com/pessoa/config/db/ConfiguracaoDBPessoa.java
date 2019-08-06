package com.kodinor.configuration;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages ="br.com.pessoa.dbpessoa.repository", entityManagerFactoryRef = "userDSEmFactory", transactionManagerRef = "userDSTransactionManager")
public class ConfiguracaoDBPessoa {

    @Primary
    @Bean
    @ConfigurationProperties("spring.datasource")
    public DataSourceProperties pessoaDB() {
        return new DataSourceProperties();
    }

    @Primary
    @Bean
    public DataSource pessoaDS(@Qualifier("pessoaDB") DataSourceProperties pessoaDB) {
        return pessoaDB.initializeDataSourceBuilder().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean pessoaDSEmFactory(@Qualifier("pessoaDS") DataSource pessoaDS, EntityManagerFactoryBuilder builder) {
        return builder.dataSource(pessoaDS).packages("br.com.pessoa.dbpessoa.model").build();
    }

    @Primary
    @Bean
    public PlatformTransactionManager pessoaDSTransactionManager(EntityManagerFactory pessoaDSEmFactory) {
        return new JpaTransactionManager(pessoaDSEmFactory);
    }

}
