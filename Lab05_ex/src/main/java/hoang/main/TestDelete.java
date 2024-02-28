package hoang.main;

import java.math.BigInteger;

import hoang.dao.EmployeeDAOImpl;

public class TestDelete {
public static void main(String[] args) {
		
		boolean flag = new EmployeeDAOImpl().deleteEmployee(new BigInteger("7777"));
		if(flag==true) {
			System.out.println("Đã xóa sản phẩm có mã 7777!");
		}else {
			System.out.println("Sảy ra lỗi khi xóa sản phẩm");
		}

}

}
