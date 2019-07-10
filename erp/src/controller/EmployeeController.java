package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import po.Employee;
import service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@RequestMapping("/findAllEmployee")
	public ModelAndView findAllEmployee() {
		
		List<Employee> list = employeeService.findAllEmployee(null);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("list",list);
		modelAndView.setViewName("employee");
		return modelAndView;
	}

	@RequestMapping("/deleteEmployeeByEid")
	public ModelAndView deleteEmployeeByEid(HttpServletRequest request, HttpServletResponse response) {
		
		String eid = request.getParameter("eid");
		
		employeeService.deleteEmployeeByEid(eid);
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("redirect:/findAllEmployee.action");
		return modelAndView;
	}
	
	@RequestMapping("/insertEmployee")
	public ModelAndView insertEmployee(Employee employee) {
		
		employeeService.insertEmployee(employee);
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("redirect:/findAllEmployee.action");
		return modelAndView;
	}
	
	@RequestMapping("/updateEmployee")
	public ModelAndView updateEmployee(Employee employee) {
		
		employeeService.updateEmployee(employee);
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("redirect:/findAllEmployee.action");
		return modelAndView;
	}
	
	@RequestMapping("/login")
	public ModelAndView login(Employee employee,HttpSession session) {
		int power = employeeService.login(employee);
		ModelAndView modelAndView = new ModelAndView();
		if(power == 1) {				
			session.setAttribute("eid", employee.getEid());
			modelAndView.setViewName("redirect:/findAllEmployee.action");
			return modelAndView;
		}
		else {
			modelAndView.setViewName("redirect:/login.html");
			return modelAndView;
		}
			
	}
	
	@RequestMapping("/register")
	public ModelAndView register(Employee employee) {
		
		employeeService.insertEmployee(employee);
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("redirect:/login.html");
		return modelAndView;
	}
}
