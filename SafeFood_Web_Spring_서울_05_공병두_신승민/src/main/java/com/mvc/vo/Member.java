package com.mvc.vo;

import java.util.ArrayList;
import java.util.Arrays;

public class Member {
	private String id;
	private String password;
	private String name;
	private String phone;
	private String[] allergies;
	private ArrayList<Food> eats;

	public Member() {
	}
	
	public Member(String id, String password, String name, String phone, String[] allergies) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.allergies = allergies;
	}

	public Member(String id, String password, String name, String phone, String[] allergies, ArrayList<Food> eats) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.allergies = allergies;
		this.eats = eats;
	}

	public ArrayList<Food> getEats() {
		return eats;
	}

	public void setEats(ArrayList<Food> eats) {
		this.eats = eats;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String[] getAllergies() {
		return allergies;
	}

	public void setAllergies(String[] allergies) {
		this.allergies = allergies;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", password=" + password + ", name=" + name + ", phone=" + phone + ", allergies="
				+ Arrays.toString(allergies) + "]";
	}
	
}
