/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.schonherz.blog.data.config;

import javax.sql.DataSource;
import org.postgresql.ds.PGPoolingDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"hu.schonherz.blog.data"})
public class BlogAppDataModuleConfig {

    @Bean
    public DataSource createDataSource() {
        PGPoolingDataSource dataSource = new PGPoolingDataSource();

        dataSource.setServerName("localhost");
        dataSource.setDatabaseName("postgres");
        dataSource.setInitialConnections(10);
        dataSource.setMaxConnections(20);
        dataSource.setPortNumber(5432);
        dataSource.setUser("postgres");
        dataSource.setPassword("pass");

        return dataSource;
    }
}
