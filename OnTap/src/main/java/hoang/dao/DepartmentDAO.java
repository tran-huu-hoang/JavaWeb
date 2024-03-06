package hoang.dao;

import java.util.List;

import hoang.entity.Department;

public interface DepartmentDAO {
	public List<Department> getAllDepartment();
	public Department getDepartmentById(int id);
	public boolean insertDepartment(Department department);
	public boolean updateDepartment(Department department);
	public boolean deleteDepartment(int id);
}