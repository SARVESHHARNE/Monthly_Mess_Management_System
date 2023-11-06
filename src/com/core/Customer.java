package com.core;

import java.time.LocalDate;

import com.core.enums.Plan;

public class Customer {
	// Customer id(int) ,first name(String), last name
	// (String),email(String),password(String),Address
	// String,RegisterDate(LocalDate),planEndDate(LocalDate), Address(String),Phone
	// No(String),plan Enum, final_amount double

	private int custId;
	private String fName;
	private String lName;
	private String email;
	private String password;
	private String address;
	private LocalDate regDate;
	private LocalDate endDate;
	private String phoneNO;
	private Plan plan;
	private double final_amt;

	public Customer(int custId, String fName, String lName, String email, String password, String address,
			LocalDate regDate, LocalDate endDate, String phoneNO, Plan plan, double final_amt) {
		super();
		this.custId = custId;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.password = password;
		this.address = address;
		this.regDate = regDate;
		this.phoneNO = phoneNO;
		this.plan = plan;
		this.final_amt = final_amt;
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", fName=" + fName + ", lName=" + lName + ", email=" + email
				+ ", password=" + password + ", address=" + address + ", regDate=" + regDate + ", endDate=" + endDate
				+ ", phoneNO=" + phoneNO + ", plan=" + plan + ", final_amt=" + final_amt + "]";
	}

	public Customer(String email) {
		super();
		this.email = email;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}

	public String getPhoneNO() {
		return phoneNO;
	}

	public void setPhoneNO(String phoneNO) {
		this.phoneNO = phoneNO;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	public double getFinal_amt() {
		return final_amt;
	}

	public void setFinal_amt(double final_amt) {
		this.final_amt = final_amt;
	}

	@Override
	public int hashCode() {
		return this.email.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Customer)
			return this.email.equals(email);
		return false;

	}

}
