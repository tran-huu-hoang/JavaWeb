package hoang.jdbc;

import java.sql.*;

public class ConnectUtils {
	public static Connection getMySQLConnection()
			throws SQLException, ClassNotFoundException {
				String userName = "db_account";
				String password = "hoang1407";
				String connectionURL = "jdbc:sqlserver://localhost:1433"+";databaseName=CustomerManager";
				Connection conn = DriverManager.getConnection(connectionURL,userName,password);
				
				return conn;
			}
}