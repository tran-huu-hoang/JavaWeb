package hoang.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateData {
	public static void main(String[] args)
			throws ClassNotFoundException, SQLException {
		Connection connection = ConnectionUtils.getMySQLConnection();

		String sql = "UPDATE product" + " SET ProName = ?," + " ProQty = ?," + " ProPrice =? " + " WHERE ProID = ? ";

		PreparedStatement pstm = connection.prepareStatement(sql);
		pstm.setInt(4, 3);
		pstm.setString(1,"HP Pavilion dv4t - BTO");
		pstm.setInt(2, 150);
		pstm.setFloat(3, 2500);
		int rowCount = pstm.executeUpdate();
		System.out.println("Đã cập nhật bản ghi: " + rowCount);
	}
}