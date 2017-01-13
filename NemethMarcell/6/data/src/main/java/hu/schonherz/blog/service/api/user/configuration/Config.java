package hu.schonherz.blog.service.api.user.configuration;

import org.postgresql.ds.PGPoolingDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "hu.schonherz.blog")
public class Config {
    @Bean
    public DataSource DataSource() {
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
