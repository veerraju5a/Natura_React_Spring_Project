package com.natura.entities;

import jakarta.persistence.*;


import java.util.Arrays;
import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ProductId;
    @Column
    private String ProductName;

    private String Description;
    private Float Price;
    private Float Weight;
//    @Column(length = 65555)
//    private byte[] Img;
    private String Img;

    @OneToMany(mappedBy = "products")
    private List<CartDetalis> list;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int productId, String productName, String description, Float price, Float weight, String img,
			List<CartDetalis> list) {
		super();
		ProductId = productId;
		ProductName = productName;
		Description = description;
		Price = price;
		Weight = weight;
		Img = img;
		this.list = list;
	}

	public int getProductId() {
		return ProductId;
	}

	public void setProductId(int productId) {
		ProductId = productId;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Float getPrice() {
		return Price;
	}

	public void setPrice(Float price) {
		Price = price;
	}

	public Float getWeight() {
		return Weight;
	}

	public void setWeight(Float weight) {
		Weight = weight;
	}

	public String getImg() {
		return Img;
	}

	public void setImg(String img) {
		Img = img;
	}

	public List<CartDetalis> getList() {
		return list;
	}

	public void setList(List<CartDetalis> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Product [ProductId=" + ProductId + ", ProductName=" + ProductName + ", Description=" + Description
				+ ", Price=" + Price + ", Weight=" + Weight + ", Img=" + Img + ", list=" + list + "]";
	}

}
