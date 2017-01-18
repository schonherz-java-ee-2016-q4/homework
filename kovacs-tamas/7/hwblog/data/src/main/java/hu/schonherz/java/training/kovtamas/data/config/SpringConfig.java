package hu.schonherz.java.training.kovtamas.data.config;

import javax.sql.DataSource;
import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class SpringConfig {

    @Bean
    public JdbcTemplate setJdbcTemplate() {
        return new JdbcTemplate(createDataSource());
    }

    private DataSource createDataSource() {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();

        dataSource.setServerName("localhost");
        dataSource.setDatabaseName("postgres");
        dataSource.setPortNumber(5432);
        dataSource.setUser("postgres");
        dataSource.setPassword("pass");

        return dataSource;
    }

}
