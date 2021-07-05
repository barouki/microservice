package com.test.springbdd;

public class Administrator {
	String name;
	String Email;
	String Username;

	public String getEmail() {
		return Email;
	}

	public void setEmail(String Email) {
		this.Email = Email;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String Username) {
		this.name = Username;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Administrator(String name, String Email, String Username) {
		super();
		this.name = name;
		this.Email = Email;
		this.Username = Username;
	}

}
