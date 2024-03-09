package com.app.ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.model.ShopModel;
import com.app.pojo.Shop;

@WebServlet("/ShopIns")
public class ShopIns extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("trxt/html");
		PrintWriter out = response.getWriter();

		int id = Integer.parseInt(request.getParameter("id"));
		String shopName = request.getParameter("shopName");
		String shopOwner = request.getParameter("shopOwner");
		String shopEmail = request.getParameter("shopEmail");
		String shopAddress = request.getParameter("shopAddress");

		ShopModel sm = new ShopModel();
		Shop s = new Shop(id, shopName, shopOwner, shopEmail, shopAddress);
		int i = sm.insertShop(s);
		if (i != 0) {
			RequestDispatcher rd = request.getRequestDispatcher("shopReg.jsp");
			request.setAttribute("msg", "Record Inserted Successfully");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("shopReg.jsp");
			request.setAttribute("msg", "Record Not Inserted");
			rd.forward(request, response);
		}
	}

}
