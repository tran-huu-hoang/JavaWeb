package tranhuuhoang.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tranhuuhoang.beans.TranHuuHoang_2110900053_Product;

public class TranHuuHoang_ProductUtils {
			public static List<TranHuuHoang_2110900053_Product> queryProduct(Connection conn) throws SQLException {
				String sql = "Select a.MaSP_2110900053, a.TenSP_2110900053, a.SoLuong_2110900053,"
						+ " a.DonGia_2110900053, a.Anh_2110900053 from TranHuuHoang_2110900053_Product a ";
				PreparedStatement pstm = conn.prepareStatement(sql);
				ResultSet rs = pstm.executeQuery();
				List<TranHuuHoang_2110900053_Product> list = new ArrayList<TranHuuHoang_2110900053_Product>();
				while (rs.next()) {
					String maSP = rs.getString("MaSP_2110900053");
					String tenSP = rs.getString("TenSP_2110900053");
					int soLuong = rs.getInt("SoLuong_2110900053");
					Float donGia = rs.getFloat("DonGia_2110900053");
					String anh = rs.getString("Anh_2110900053");
					
					TranHuuHoang_2110900053_Product product = new TranHuuHoang_2110900053_Product();
					
					product.setMaSP_2110900053(maSP);
					product.setTenSP_2110900053(tenSP);
					product.setSoLuong_2110900053(soLuong);
					product.setDonGia_2110900053(donGia);
					product.setAnh_2110900053(anh);
					
					list.add(product);
				}
				return list;
			}
			
			//Tìm kiếm theo mã product
				public static TranHuuHoang_2110900053_Product findProduct (Connection conn, String maSP) throws SQLException {
						String sql = "Select a.MaSP_2110900053, a.TenSP_2110900053, a.SoLuong_2110900053,"
								+ " a.DonGia_2110900053, a.Anh_2110900053 from TranHuuHoang_2110900053_Product a where a.MaSP_2110900053=?";
						PreparedStatement pstm = conn.prepareStatement(sql);
						pstm.setString(1, maSP);
						ResultSet rs = pstm.executeQuery();
						while (rs.next()) {
							String tenSP = rs.getString("TenSP_2110900053");
							int soLuong = rs.getInt("SoLuong_2110900053");
							Float donGia = rs.getFloat("DonGia_2110900053");
							String anh = rs.getString("Anh_2110900053");
							
							TranHuuHoang_2110900053_Product product = new TranHuuHoang_2110900053_Product(maSP, tenSP, soLuong, donGia, anh);
							
							return product;
						}
						return null;
					}
				
				
			//Thêm mới product
			public static void insertProduct (Connection conn, TranHuuHoang_2110900053_Product product) throws SQLException {
				String sql = "Insert into TranHuuHoang_2110900053_Product (MaSP_2110900053, TenSP_2110900053, SoLuong_2110900053, "
						+ "DonGia_2110900053, Anh_2110900053) values (?,?,?,?,?)";
				PreparedStatement pstm = conn.prepareStatement(sql);
				pstm.setString(1, product.getMaSP_2110900053());
				pstm.setString(2, product.getTenSP_2110900053());
				pstm.setInt(3, product.getSoLuong_2110900053());
				pstm.setFloat(4, product.getDonGia_2110900053());
				pstm.setString(5, product.getAnh_2110900053());
				
				pstm.executeUpdate();
			}
			
			//Cập nhật product
			public static void updateProduct (Connection conn, TranHuuHoang_2110900053_Product product) throws SQLException {
				String sql = "Update TranHuuHoang_2110900053_Product set TenSP_2110900053 =?, SoLuong_2110900053 =?, "
						+ "DonGia_2110900053 =?, Anh_2110900053 =? where MaSP_2110900053=? ";
				PreparedStatement pstm = conn.prepareStatement(sql);
				pstm.setString(5, product.getMaSP_2110900053());
				pstm.setString(1, product.getTenSP_2110900053());
				pstm.setInt(2, product.getSoLuong_2110900053());
				pstm.setFloat(3, product.getDonGia_2110900053());
				pstm.setString(4, product.getAnh_2110900053());
				
				pstm.executeUpdate(); 
			}
			
			//Xóa một product
			public static void deleteProduct (Connection conn, String maSP) throws SQLException {
				String sql = "Delete From TranHuuHoang_2110900053_Product where MaSP_2110900053= ?";
				PreparedStatement pstm = conn.prepareStatement(sql);
				pstm.setString(1, maSP);
				pstm.executeUpdate();
			}
}
