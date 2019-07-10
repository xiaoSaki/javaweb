package service;

import java.util.List;

import po.Employee;
import po.EmployeeExample;

public interface EmployeeService {
	public List<Employee> findAllEmployee(EmployeeExample employeeExample);
	public Integer deleteEmployeeByEid(String eid);
	public Integer insertEmployee(Employee record);
	public Integer updateEmployee(Employee record);
	public Integer login(Employee record);
}
