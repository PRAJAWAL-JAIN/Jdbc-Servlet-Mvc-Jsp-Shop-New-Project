package com.app.ctrl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.model.ShopModel;

@WebServlet("/LoginShop")
public class LoginShop extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String password = request.getParameter("password");

		ShopModel sm = new ShopModel();
		int i = sm.logShop(name, password);
		if (i != 0) {
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(10000);
			session.setAttribute("user", name);
			session.setAttribute("msg", "Welcome To Admin Home");
			response.sendRedirect("adminHome.jsp");
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("shopLogin.jsp");
			request.setAttribute("msg", "Incorrect UserName or Password");
			rd.forward(request, response);
		}
	}

}
