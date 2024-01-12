package hoang.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteData {
	public static void main(String[] args)
		throws ClassNotFoundException, SQLException {
		Connection connection = ConnectionUtils.getMySQLConnection();
		String sql = "DELETE FROM product WHERE ProID = ? ";
		PreparedStatement pstm = connection.prepareStatement(sql);
		pstm.setInt(1, 3);
		int rowCount = pstm.executeUpdate();
		System.out.println("Đã xóa bản ghi (3): " + rowCount);
	}
}