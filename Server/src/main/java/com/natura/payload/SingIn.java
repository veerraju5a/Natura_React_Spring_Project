package com.natura.payload;


public class SingIn {

    private String Email;
    private String Password;
    private String jwt;
    private String role;
	public SingIn() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SingIn(String email, String password, String jwt, String role) {
		super();
		Email = email;
		Password = password;
		this.jwt = jwt;
		this.role = role;
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
	public String getJwt() {
		return jwt;
	}
	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "SingIn [Email=" + Email + ", Password=" + Password + ", jwt=" + jwt + ", role=" + role + "]";
	}
    
	}
