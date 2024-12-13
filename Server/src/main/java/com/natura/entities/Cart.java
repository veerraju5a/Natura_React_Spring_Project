package com.natura.entities;

import jakarta.persistence.*;


import java.util.List;

@Entity
//@NoArgsConstructor
//@AllArgsConstructor
//@Data
//@ToString
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    private float TotalAmount;


    public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Cart(int id, User user, float totalAmount, List<CartDetalis> cartDetalis) {
		super();
		Id = id;
		this.user = user;
		TotalAmount = totalAmount;
		this.cartDetalis = cartDetalis;
	}


	public int getId() {
		return Id;
	}


	public void setId(int id) {
		Id = id;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "Cart [Id=" + Id + ", user=" + user + ", TotalAmount=" + TotalAmount + ", cartDetalis=" + cartDetalis
				+ "]";
	}


	public float getTotalAmount() {
		return TotalAmount;
	}


	public void setTotalAmount(float totalAmount) {
		TotalAmount = totalAmount;
	}


	public List<CartDetalis> getCartDetalis() {
		return cartDetalis;
	}


	@OneToMany(cascade = CascadeType.ALL,mappedBy = "cart")
    private List<CartDetalis> cartDetalis;


    public void setCartDetalis(List<CartDetalis> pro) {
    }
}
