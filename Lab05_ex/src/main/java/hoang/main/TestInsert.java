package hoang.main;

import java.math.BigInteger;
import java.util.Calendar;

import hoang.dao.EmployeeDAOImpl;
import hoang.entity.Employee;

public class TestInsert {
	public static void main(String[] args) {
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 1999);
		cal.set(Calendar.MONTH, Calendar.JANUARY);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		
		Employee p = new Employee();
		p.setEmpId(new BigInteger("7779"));
		p.setEmpName("Sasuke");
		p.setEmpNo("SSK5");	
		p.setHireDate(cal.getTime());
		p.setImage(null);
		p.setJob("NINJA");
		p.setSalary(1000);
		p.setDeptId(10);
		p.setMngId(new BigInteger("7777"));
		
		boolean flag = new EmployeeDAOImpl().insertEmployee(p);
		if(flag==true) {
			System.out.println("Thêm mới thành công!");
		}else {
			System.out.println("Sảy ra lỗi thêm mới sản phẩm");
		}
	}

}
