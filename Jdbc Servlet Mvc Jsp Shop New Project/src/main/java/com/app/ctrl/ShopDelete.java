package com.app.ctrl;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.model.ShopModel;
import com.app.pojo.Shop;

@WebServlet("/ShopDelete")
public class ShopDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		int i = new ShopModel().shopDelete(id);
		ArrayList<Shop> s = new ShopModel().getAllShop();
		if (i != 0) {
			RequestDispatcher rd = request.getRequestDispatcher("shopDetail.jsp");
			request.setAttribute("SHOP", s);
			request.setAttribute("msg", "Shop Data Deleted Successfully");
			rd.forward(request, response);
		} else {
			System.out.println("Shop Data Not Deleted");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
