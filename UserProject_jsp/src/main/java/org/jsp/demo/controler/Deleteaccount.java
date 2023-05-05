package org.jsp.demo.controler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsp.demo.dao.Useraccess;
@WebServlet("/delete")
public class Deleteaccount extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id=Integer.parseInt(req.getParameter("id"));
	Useraccess a=new Useraccess();
	if(req.getSession().getAttribute("user")!=null) {
	a.DeleteUserbyid(id);
	PrintWriter out=resp.getWriter();
	out.print("<html><body><h1>your account deleted</h1></body></html>");
	RequestDispatcher disp=req.getRequestDispatcher("login.jsp");
	disp.include(req, resp);
	req.getSession().invalidate();
}else {
	resp.sendRedirect("login.jsp");
}
	
	
	
}
}
