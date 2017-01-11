package homework5_data.source;

import javax.sql.DataSource;

import org.postgresql.ds.PGPoolingDataSource;

public final class DataSourceManager {
    private DataSourceManager(){}
    private static PGPoolingDataSource dataSource = null;
    
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
        dataSource.setInitialConnections(10); 
        dataSource.setMaxConnections(20); 
        
        
    }
}
