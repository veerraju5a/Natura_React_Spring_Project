package com.natura.entities;


import jakarta.persistence.*;


import java.util.List;

@Entity
public class CartDetalis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int CartDetalisId;

    @ManyToOne
    private Product products;
    private int Quantity;
    private int Amount;

    @ManyToOne
    private Cart cart;

	public CartDetalis() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartDetalis(int cartDetalisId, Product products, int quantity, int amount, Cart cart) {
		super();
		CartDetalisId = cartDetalisId;
		this.products = products;
		Quantity = quantity;
		Amount = amount;
		this.cart = cart;
	}

	public int getCartDetalisId() {
		return CartDetalisId;
	}

	public void setCartDetalisId(int cartDetalisId) {
		CartDetalisId = cartDetalisId;
	}

	public Product getProducts() {
		return products;
	}

	public void setProducts(Product products) {
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

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	@Override
	public String toString() {
		return "CartDetalis [CartDetalisId=" + CartDetalisId + ", products=" + products + ", Quantity=" + Quantity
				+ ", Amount=" + Amount + ", cart=" + cart + "]";
	}
    





}
