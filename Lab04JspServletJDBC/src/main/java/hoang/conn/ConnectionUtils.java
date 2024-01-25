package hoang.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
	public static Connection getMSSQLConnection() throws SQLException, ClassNotFoundException {
        String hostName = "localhost";
        String sqlInstanceName = "SQLEXPRESS";
        String dbName = "Lab04JspServletJDBC";
        String userName = "sa";
        String password = "hoang1407";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionURL = "jdbc:sqlserver://" + hostName + ":1433;instance=" + sqlInstanceName + ";databaseName="+dbName + ";encrypt=true;trustServerCertificate=true";
        // Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         //DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());  
        Connection conn = DriverManager.getConnection(connectionURL, userName, password);
        return conn;
    }
}