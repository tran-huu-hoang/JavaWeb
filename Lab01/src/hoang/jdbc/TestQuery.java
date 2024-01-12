package hoang.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TestQuery {
	public static void main(String[] args)
			throws ClassNotFoundException, SQLException {

			String sql = "Select * from product";
				ResultSet rs = QueryDataUtils.getAll(sql);
				while (rs.next()) {

					int proId = rs.getInt(1);
					String proName = rs.getString("ProName");
					int proQty = rs.getInt("ProQty");
					float proPrice = rs.getFloat("ProPrice");
					System.out.println("-------------------------------------");

					System.out.printf("%-5d",proId);
					System.out.printf("%15s" ,proName);
					System.out.printf("%5d" ,proQty);
					System.out.printf("%10.2f" ,proPrice);
				}
				rs.close();
	}
}