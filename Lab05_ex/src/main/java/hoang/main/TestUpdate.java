package hoang.main;

import hoang.entity.Employee;

import java.math.BigInteger;
import java.util.Calendar;

import hoang.dao.EmployeeDAOImpl;

public class TestUpdate {
	public static void main(String[] args) {
		Employee p = new EmployeeDAOImpl().getEmployeeById(new BigInteger("7779"));
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 1999);
		cal.set(Calendar.MONTH, Calendar.JANUARY);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		
		p.setEmpId(new BigInteger("7779"));
		p.setEmpName("NARUTO");
		p.setEmpNo("SSK5");	
		p.setHireDate(cal.getTime());
		p.setImage(null);
		p.setJob("NINJA");
		p.setSalary(1000);
		p.setDeptId(10);
		p.setMngId(new BigInteger("7777"));
		
		boolean flag = new EmployeeDAOImpl().updateEmployee(p);
		if(flag==true) {
			System.out.println("Sửa đổi dữ liệu thành công!");
		}else {
			System.out.println("Sảy ra lỗi khi sửa sản phẩm");
		}
}

}
