package org.jsp.demo.controler;

import java.io.IOException;


import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jsp.demo.dao.Useraccess;
import org.jsp.demo.dto.User;
@WebServlet("/reg")
public class Registerservlet extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String name=req.getParameter("nm");
	long phone=Long.parseLong(req.getParameter("ph"));
	String password=req.getParameter("ps");
	
	User u=new User();
	u.setName(name);
	u.setPassword(password);
	u.setPhone(phone);
	Useraccess s=new Useraccess();
	u=s.SaveUser(u);
	RequestDispatcher red = null;
	
		red = req.getRequestDispatcher("welcome.jsp");
		HttpSession session = req.getSession();
		session.setAttribute("user", u);
		red.forward(req, resp);
//	PrintWriter out=resp.getWriter();
//	out.write("<html><body><h1>your registration successfull</h1></body></html>");

	
	
}
}
