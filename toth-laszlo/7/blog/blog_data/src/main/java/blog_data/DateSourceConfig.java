package blog_data;

import javax.sql.DataSource;

import org.postgresql.ds.PGPoolingDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DateSourceConfig {
	 @Bean
	    public DataSource createDataSource(){
	        PGPoolingDataSource dataSource = new PGPoolingDataSource();
	        
	        dataSource.setServerName("localhost");
	        dataSource.setPortNumber(5432);
	        dataSource.setDatabaseName("postgres");
	        dataSource.setUser("postgres");
	        dataSource.setPassword("pass");
	        dataSource.setInitialConnections(10); // Pool kiinduló mérete
	        dataSource.setMaxConnections(20); // meddig nőhet maximum a pool mérete
	        
	        return dataSource;
	    }
}
