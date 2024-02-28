package hoang.dao;

import java.math.BigInteger;
import java.util.List;

import hoang.entity.Employee;

public interface EmployeeDAO {
	public List<Employee> getAllEmployee();
	public Employee getEmployeeById(BigInteger id);
	public boolean insertEmployee(Employee employee);
	public boolean updateEmployee(Employee employee);
	public boolean deleteEmployee(BigInteger id);
	public List<Employee> searchEmployeeByName(String id); 
}
