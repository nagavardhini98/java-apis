package com.spring.web.beans;

public class Registration {
	String name;
	String email;
	String organization;
	String password;
	String username;

	public Registration(String name, String email, String organization, String password, String username) {
		super();
		this.name = name;
		this.email = email;
		this.organization = organization;
		this.password = password;
		this.username = username;
	}

	public Registration() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Registration [name=" + name + ", email=" + email + ", organization=" + organization + ",password="
				+ password + ",username=" + username + "]";
	}

}
