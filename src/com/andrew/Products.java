package com.andrew;

public class Products {

	private String productName;
	private int productPrice;

	public Products(String productName, int productPrice) {
		this.productName = productName;
		this.productPrice = productPrice;
	}

	public String getProductName() {
		return productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

}
