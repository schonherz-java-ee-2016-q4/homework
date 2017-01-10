package hu.schonherz.blog.data.datasource;

/**
 * Created by Geri on 2017. 01. 03..
 */
import javax.sql.DataSource;

import org.postgresql.ds.PGPoolingDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
//@ComponentScan(basePackages = "hu.schonherz.blog.data")
public class DatasourceManager {
    @Bean
    public DataSource createDataSource() {
        PGPoolingDataSource dataSource = new PGPoolingDataSource();
        dataSource.setServerName("localhost");
        dataSource.setPortNumber(5432);
        dataSource.setDatabaseName("postgres");
        dataSource.setUser("postgres");
        dataSource.setPassword("pass");
        dataSource.setInitialConnections(10);
        dataSource.setMaxConnections(20);
        return dataSource;
    }
}