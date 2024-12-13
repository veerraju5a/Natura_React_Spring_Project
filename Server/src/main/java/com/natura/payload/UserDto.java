package com.natura.payload;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.natura.entities.Cart;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToOne;


import java.util.Date;

//@ToString
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class UserDto {


    private int Userid;

    private String Name;
    private String Email;
    private String Password;
    private String Contact;


    private Date date;

    private String Role;

//     private CartDto cart;
    
    public UserDto() {
		// TODO Auto-generated constructor stub
	}

	public UserDto(int userid, String name, String email, String password, String contact, Date date, String role) {
		super();
		Userid = userid;
		Name = name;
		Email = email;
		Password = password;
		Contact = contact;
		this.date = date;
		Role = role;
	}

	public int getUserid() {
		return Userid;
	}

	public void setUserid(int userid) {
		Userid = userid;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getContact() {
		return Contact;
	}

	public void setContact(String contact) {
		Contact = contact;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}

	@Override
	public String toString() {
		return "UserDto [Userid=" + Userid + ", Name=" + Name + ", Email=" + Email + ", Password=" + Password
				+ ", Contact=" + Contact + ", date=" + date + ", Role=" + Role + "]";
	}
    

}
