package hu.schonherz.blog.service.api.user.service.data.datasource;

import javax.sql.DataSource;

import org.postgresql.ds.PGPoolingDataSource;

public class DataSourceManager {
    private static PGPoolingDataSource inst = null;
    
    private DataSourceManager() {}
    
    public static DataSource getDataSource() {
        if (inst != null)
            return inst;
        
        inst = new PGPoolingDataSource();
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
