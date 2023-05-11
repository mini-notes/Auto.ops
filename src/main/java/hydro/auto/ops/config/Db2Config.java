package hydro.auto.ops.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
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

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EntityScan(basePackages = "hydro.auto.ops.model.db2")
@EnableJpaRepositories(
        entityManagerFactoryRef = "db2EntityManagerFactory",
        transactionManagerRef = "db2TransactionManager",
        basePackages = "hydro.auto.ops.repository.db2")
public class Db2Config {
    @Bean(name="db2Props")
    @ConfigurationProperties("spring.db2.datasource")
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name="db2Datasource")
    @ConfigurationProperties(prefix = "spring.db2.datasource")
    public DataSource datasource(@Qualifier("db2Props") DataSourceProperties properties){
        return properties.initializeDataSourceBuilder().build();
    }

    @Bean(name="db2EntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean
            (EntityManagerFactoryBuilder builder,
             @Qualifier("db2Datasource") DataSource dataSource){
        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.dialect", "hydro.auto.ops.dialect.SQLiteDialect");
        return builder.dataSource(dataSource)
                .packages("hydro.auto.ops.model.db2")
                .properties(properties)
                .persistenceUnit("db2").build();
    }

    @Primary
    @Bean(name = "db2TransactionManager")
    @ConfigurationProperties("spring.db2.jpa")
    public PlatformTransactionManager transactionManager(
            @Qualifier("db2EntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
