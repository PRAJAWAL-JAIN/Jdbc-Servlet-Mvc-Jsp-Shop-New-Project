package com.app.pojo;

public class Shop {
	private int id;
	private String shopName;
	private String shopOwner;
	private String shopEmail;
	private String shopAddress;

	public Shop() {

	}

	public Shop(int id, String shopName, String shopOwner, String shopEmail, String shopAddress) {
		this.id = id;
		this.shopName = shopName;
		this.shopOwner = shopOwner;
		this.shopEmail = shopEmail;
		this.shopAddress = shopAddress;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopOwner() {
		return shopOwner;
	}

	public void setShopOwner(String shopOwner) {
		this.shopOwner = shopOwner;
	}

	public String getShopEmail() {
		return shopEmail;
	}

	public void setShopEmail(String shopEmail) {
		this.shopEmail = shopEmail;
	}

	public String getShopAddress() {
		return shopAddress;
	}

	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}

}
