package org.jsp.demo.controler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsp.demo.dao.Useraccess;
import org.jsp.demo.dto.User;
@WebServlet("/edit")
public class Updateuser extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("nm");
		long phone=Long.parseLong(req.getParameter("ph"));
		String password=req.getParameter("ps");
		
		User u=new User();
		u.setId(id);
		u.setName(name);
		u.setPassword(password);
		u.setPhone(phone);
		Useraccess s=new Useraccess();
		u=s.UpdateUser(u);
		PrintWriter out=resp.getWriter();
		out.write("<html><body><h1>your detais updated</h1></body></html>");
		
		
	}
}
