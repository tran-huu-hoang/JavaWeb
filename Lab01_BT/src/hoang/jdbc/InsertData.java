package hoang.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertData {
	public static void main(String[] args)
			throws ClassNotFoundException, SQLException {
		Connection connection = ConnectUtils.getMySQLConnection();

		Statement statement = connection.createStatement();

		String sql = "INSERT INTO product(ProID,ProName,ProQty,ProPrice) ";

		sql += "VALUES(4,'HP Pavilion ??? - BTO',1210,7700)";

		int rowCount = statement.executeUpdate(sql);
		System.out.println("Đã thêm mới 1 bản ghi: " + rowCount);
	}
}
