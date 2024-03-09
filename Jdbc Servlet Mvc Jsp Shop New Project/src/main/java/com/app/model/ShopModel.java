package com.app.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.app.pojo.Shop;

public class ShopModel {
	public static Connection start() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vickey", "root", "root");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;

	}

	public int logShop(String name, String password) {
		int i = 0;
		Connection con = null;
		try {
			con = start();
			PreparedStatement pst = con.prepareStatement("select * from login where name=? and password=?");
			pst.setString(1, name);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				i = 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public int insertShop(Shop s) {
		int i = 0;
		Connection con = null;
		try {
			con = start();
			PreparedStatement pst = con.prepareStatement("insert into shop values(?,?,?,?,?)");
			pst.setInt(1, s.getId());
			pst.setString(2, s.getShopName());
			pst.setString(3, s.getShopOwner());
			pst.setString(4, s.getShopEmail());
			pst.setString(5, s.getShopAddress());

			i = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public int shopDelete(int id) {
		int i = 0;
		Connection con = null;
		try {
			con = start();
			PreparedStatement pst = con.prepareStatement("delete from shop where id=?");
			pst.setInt(1, id);

			i = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public ArrayList<Shop> getAllShop() {
		ArrayList<Shop> al = new ArrayList<Shop>();
		Connection con = null;
		try {
			con = start();
			PreparedStatement pst = con.prepareStatement("select * from shop");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Shop sh = new Shop(rs.getInt("id"), rs.getString("shopName"), rs.getString("shopOwner"),
						rs.getString("shopEmail"), rs.getString("shopAddress"));
				al.add(sh);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return al;
	}

	public ArrayList<Shop> getAllDetails() {
		ArrayList<Shop> list = new ArrayList<Shop>();
		Connection con = null;
		try {
			con = start();
			PreparedStatement pst = con.prepareStatement("select * from shop");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Shop s = new Shop(rs.getInt("id"), rs.getString("shopName"), rs.getString("shopOwner"),
						rs.getString("shopEmail"), rs.getString("shopAddress"));
				list.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public Shop getShopDetail(int id) {
		Shop s = null;
		Connection con = null;
		try {
			con = start();
			PreparedStatement pst = con.prepareStatement("select * from shop where id=?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				s = new Shop(rs.getInt("id"), rs.getString("shopName"), rs.getString("shopOwner"),
						rs.getString("shopEmail"), rs.getString("shopAddress"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

	public int updateShop(Shop sp) {
		int i = 0;
		Connection con = null;
		try {
			con = start();
			PreparedStatement pst = con
					.prepareStatement("update shop set shopName=?,shopOwner=?,shopEmail=?,shopAddress=? where id=?");
			pst.setString(1, sp.getShopName());
			pst.setString(2, sp.getShopOwner());
			pst.setString(3, sp.getShopEmail());
			pst.setString(4, sp.getShopAddress());
			pst.setInt(5, sp.getId());

			i = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

}
