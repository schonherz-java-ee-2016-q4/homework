package hu.schonherz.blog.service.api.user.datasource;

import javax.sql.DataSource;

import org.postgresql.ds.PGPoolingDataSource;

public final class DataSourceManager {

  private static PGPoolingDataSource dataSource = null;
    
    private DataSourceManager(){}
    
    
    public static DataSource getDataSource(){
        if(dataSource == null){
            createDataSource();
        }
       return dataSource;
    }
    
    private static void createDataSource(){
        dataSource = new PGPoolingDataSource();
        dataSource.setServerName("localhost");
        dataSource.setPortNumber(5432);
        
        
        dataSource.setDatabaseName("postgres");
        dataSource.setUser("postgres");
        dataSource.setPassword("pass");
        dataSource.setInitialConnections(10); // Pool kiinduló mérete
        dataSource.setMaxConnections(20); // meddig nőhet maximum a pool mérete
        
        
    }
}