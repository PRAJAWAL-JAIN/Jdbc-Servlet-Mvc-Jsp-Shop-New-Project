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

@WebServlet("/ShopUpdate")
public class ShopUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		Shop sh = new ShopModel().getShopDetail(id);

		RequestDispatcher rd = request.getRequestDispatcher("shopUpdate.jsp");
		request.setAttribute("SHOP", sh);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		String shopName = request.getParameter("shopName");
		String shopOwner = request.getParameter("shopOwner");
		String shopEmail = request.getParameter("shopEmail");
		String shopAddress = request.getParameter("shopAddress");

		Shop sp = new Shop(id, shopName, shopOwner, shopEmail, shopAddress);
		int i = new ShopModel().updateShop(sp);
		if (i != 0) {
			ArrayList<Shop>so=new ShopModel().getAllDetails();
			RequestDispatcher rd=request.getRequestDispatcher("shopDetail.jsp");
			request.setAttribute("SHOP", so);
			request.setAttribute("msg", "Shop Details Updated Successfully");
			rd.forward(request, response);
		}
	}

}
