package org.jsp.user.cotroller;

import javax.servlet.http.HttpSession;

import org.jsp.user.dto.User;
import org.jsp.user.service.userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class logout {
	@Autowired
	userservice service;
	@RequestMapping(value = "/logout",method=RequestMethod.GET)
	public String logou( Model m, HttpSession session) {
		session.invalidate();
		m.addAttribute("message", "you havebeen loggedout");

		return "index";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView delete(@ModelAttribute User user, ModelAndView m,HttpSession session) {
		service.deleteuserbyid(user.getId());
		
		m.setViewName("print");
		m.addObject("message", "data deleted " );
		session.invalidate();
		return m;
	}
}
