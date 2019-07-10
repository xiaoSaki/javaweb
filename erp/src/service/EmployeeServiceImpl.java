package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapper.EmployeeMapper;
import po.Employee;
import po.EmployeeExample;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeMapper employeeMapper;
	
	
	public EmployeeMapper getEmployeeMapper() {
		return employeeMapper;
	}

	public void setEmployeeMapper(EmployeeMapper employeeMapper) {
		this.employeeMapper = employeeMapper;
	}

	@Override
	public List<Employee> findAllEmployee(EmployeeExample employeeExample) {
		return employeeMapper.selectByExample(employeeExample);
	}

	@Override
	public Integer deleteEmployeeByEid(String eid) {
		return employeeMapper.deleteByPrimaryKey(eid);
	}

	@Override
	public Integer insertEmployee(Employee record) {
		return employeeMapper.insert(record);
	}

	@Override
	public Integer updateEmployee(Employee record) {
		return employeeMapper.updateByPrimaryKey(record);
	}

	@Override
	public Integer login(Employee record) {
		Employee e = employeeMapper.selectByPrimaryKey(record.getEid());
		if(e != null) {
			if(e.getPwd().equals(record.getPwd()))
				return e.getPower();
			else
				return 0;
		}
		else
			return -1;
	}

}
