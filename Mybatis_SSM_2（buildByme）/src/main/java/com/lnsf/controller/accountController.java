package com.lnsf.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lnsf.entities.account;
import com.lnsf.service.accountService;


@Controller
public class accountController {
	@Autowired
	private accountService as;
    @RequestMapping("account")
  	public ModelAndView showAccount(){
	   //account at= null;
  		ModelAndView modelAndView = new ModelAndView("list");
  	     //at = as.selectByPrimaryKey("111");
  	    List<account> at = as.selectByExample(null);
  		modelAndView.addObject("account", at);
  		return modelAndView;
  	}
  

}

/*
 * @Controller
 * 
 * @RequestMapping("/user1") // /user/** public class TestController { private
 * static Logger log = LoggerFactory.getLogger(TestController.class); //
 * /user1/test1?id=1001
 * 
 * @Autowired private UserService userService;
 * 
 * @RequestMapping(value = "/test1", method = RequestMethod.GET)
 * public @ResponseBody User test(HttpServletRequest request, Model model) {
 * ModelAndView modelAndView = new ModelAndView(); int userId =
 * Integer.parseInt(request.getParameter("id")); User user =
 * userService.getUserById(userId); modelAndView.addObject("user", user); return
 * user; }
 */



