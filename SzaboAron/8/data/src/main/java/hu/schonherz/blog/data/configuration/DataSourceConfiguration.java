package hu.schonherz.blog.data.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;

import javax.sql.DataSource;

/**
 * Created by Áron on 2017. 01. 21..
 */
public class DataSourceConfiguration {
    @Bean
    public DataSource getDataSource() {
        final JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
        dsLookup.setResourceRef(true);
        DataSource dataSource = dsLookup.getDataSource("java:jboss/jdbc/postgres");
        return dataSource;
    }
}
