package hu.schonherz.java.training.kovtamas.data.datasource;

import javax.sql.DataSource;
import org.postgresql.ds.PGSimpleDataSource;

public class DataSourceManager {

    private static PGSimpleDataSource dataSource = null;

    static {
        createDataSource();
    }

    private static void createDataSource() {
        dataSource = new PGSimpleDataSource();

        dataSource.setServerName("localhost");
        dataSource.setDatabaseName("postgres");
        dataSource.setPortNumber(5432);
        dataSource.setUser("postgres");
        dataSource.setPassword("pass");
    }

    public static DataSource getDataSource() {
        return dataSource;
    }

    private DataSourceManager() {
    }

}
