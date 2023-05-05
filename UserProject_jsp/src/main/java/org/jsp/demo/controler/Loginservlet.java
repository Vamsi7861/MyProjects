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

@WebServlet("/log")
public class Loginservlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		long phone = Long.parseLong(req.getParameter("ph"));
		String password = req.getParameter("ps");
		Useraccess s = new Useraccess();
		User u = s.verifyuser(phone, password);
		PrintWriter out = resp.getWriter();
		RequestDispatcher red = null;
		if (u != null) {
			red = req.getRequestDispatcher("home.jsp");
			HttpSession session = req.getSession();
			session.setAttribute("user", u);
			red.forward(req, resp);
			
		} else {
			out.write("<html><body><h1>invalid phone number or password</h1></body></html");
			red = req.getRequestDispatcher("login.jsp");
			red.include(req, resp);

		}

	}
}
