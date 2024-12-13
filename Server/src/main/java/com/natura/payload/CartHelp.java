package com.natura.payload;


public class CartHelp {
    private String UserEmail;
    private int ProductId;
    private int Quantity;
	public CartHelp() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CartHelp(String userEmail, int productId, int quantity) {
		super();
		UserEmail = userEmail;
		ProductId = productId;
		Quantity = quantity;
	}
	public String getUserEmail() {
		return UserEmail;
	}
	public void setUserEmail(String userEmail) {
		UserEmail = userEmail;
	}
	public int getProductId() {
		return ProductId;
	}
	public void setProductId(int productId) {
		ProductId = productId;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	@Override
	public String toString() {
		return "CartHelp [UserEmail=" + UserEmail + ", ProductId=" + ProductId + ", Quantity=" + Quantity + "]";
	}
    
}
