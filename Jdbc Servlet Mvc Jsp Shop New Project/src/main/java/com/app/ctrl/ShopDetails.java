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

@WebServlet("/ShopDetails")
public class ShopDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ShopModel sm=new ShopModel();
		ArrayList<Shop>al=sm.getAllDetails();
		
		RequestDispatcher rd =request.getRequestDispatcher("shopDetail.jsp");
		request.setAttribute("SHOP", al);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
