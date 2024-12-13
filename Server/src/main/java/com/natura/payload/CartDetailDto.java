package com.natura.payload;

public class CartDetailDto {

    private int CartDetalisId;
    private ProductDto products;
    private int Quantity;
    private int Amount;
	public CartDetailDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CartDetailDto(int cartDetalisId, ProductDto products, int quantity, int amount) {
		super();
		CartDetalisId = cartDetalisId;
		this.products = products;
		Quantity = quantity;
		Amount = amount;
	}
	public int getCartDetalisId() {
		return CartDetalisId;
	}
	public void setCartDetalisId(int cartDetalisId) {
		CartDetalisId = cartDetalisId;
	}
	public ProductDto getProducts() {
		return products;
	}
	public void setProducts(ProductDto products) {
		this.products = products;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public int getAmount() {
		return Amount;
	}
	public void setAmount(int amount) {
		Amount = amount;
	}
	@Override
	public String toString() {
		return "CartDetailDto [CartDetalisId=" + CartDetalisId + ", products=" + products + ", Quantity=" + Quantity
				+ ", Amount=" + Amount + "]";
	}

//    private CartDto cart;
    
}
