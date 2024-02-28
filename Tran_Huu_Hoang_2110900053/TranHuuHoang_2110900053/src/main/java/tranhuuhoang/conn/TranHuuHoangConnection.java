package tranhuuhoang.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TranHuuHoangConnection {
	public static Connection getMSSQLConnection() throws SQLException, ClassNotFoundException {
        String hostName = "localhost";
        String sqlInstanceName = "SQLEXPRESS";
        String dbName = "TranHuuHoang_2110900053_db";
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