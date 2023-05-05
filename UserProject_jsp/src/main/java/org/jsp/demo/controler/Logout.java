package org.jsp.demo.controler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/logout")
public class Logout  extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	req.getSession().invalidate();
	PrintWriter out=resp.getWriter();
	out.print("<html><body><h1>you have been logged out</h1></body></html>");
	RequestDispatcher disp=req.getRequestDispatcher("login.jsp");
	disp.include(req, resp);
	
}
}
