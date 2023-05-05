package org.jsp.user.cotroller;

import org.jsp.user.dto.User;

import org.jsp.user.service.userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes(names = { "us" })
public class Test {
	@Autowired
	userservice service;
//	@RequestMapping(value = "/log", method = RequestMethod.POST)
//	public ModelAndView log(@ModelAttribute User user, ModelAndView m) {
//
//		 user = service.verifyuser(user.getPhone(),user.getPassword());
//		if (user != null) {
//			m.setViewName("home");
//			m.addObject("user", user);
//			return m;
//		} else {
//			m.addObject("message", "invalid user name or password");
//			m.setViewName("index");
//			return m;
//		}
//	}

//	@RequestMapping(value = "/log", method = RequestMethod.POST)
//	public ModelAndView log(@RequestParam long phone, @RequestParam String password, ModelAndView m) {
//
//		User user = service.verifyuser(phone, password);
//		if (user != null) {
//			m.setViewName("home");
//			m.addObject("user", user);
//			return m;
//		} else {
//	m.addObject("message", "invalid user name or password");
//			m.setViewName("index");
//			return m;
//		}
//	}

	@RequestMapping(value = "/log", method = RequestMethod.POST)
	public String log(@RequestParam long phone, @RequestParam String password, Model m) {

		User user = service.verifyuser(phone, password);
		if (user != null) {
			m.addAttribute("us", user);
			return "home";
		} else {
			m.addAttribute("message", "invalid user name or password");
			return "index";
		}
	}

	@RequestMapping("/load")
	public ModelAndView load(ModelAndView m, @RequestParam int choice) {
		if (choice == 1)
			m.setViewName("register");
		else if (choice == 2)
			m.setViewName("edit");
		else if (choice == 3)
			m.setViewName("index");
		m.addObject("user", new User());
		return m;

	}

	@RequestMapping(value = "/reg", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute User user, ModelAndView m) {

		service.saveUser(user);

		m.setViewName("print");

		m.addObject("message", "user registered with id " + user.getId());
		return m;

	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public ModelAndView update(@ModelAttribute User user, ModelAndView m) {
		service.updateuser(user);
		m.addObject("us", user);
		m.setViewName("print");
		m.addObject("message", "user " + user.getName() + "updated");
		return m;
	}

}
