package hu.schonherz.blog.data.config;

import javax.sql.DataSource;

import org.postgresql.ds.PGPoolingDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringJdbcConfig {

    @Bean
    public DataSource createDataSource() {
        PGPoolingDataSource inst = new PGPoolingDataSource();
        inst.setServerName("localhost");
        inst.setDatabaseName("postgres");
        inst.setPortNumber(5432);
        inst.setUser("postgres");
        inst.setPassword("pass");
        
        inst.setInitialConnections(10);
        inst.setMaxConnections(20);
        
        return inst;
    }
    
}
