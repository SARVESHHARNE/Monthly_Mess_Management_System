package com.core.enums;

public enum Plan {
	MONTHLY(3000, 1), QUARTERLY(11700, 3), HALFYEAR(17500, 6), YEARLY(32000, 12);

	private double price;
	private int months;

	private Plan(double price, int months) {
		this.price = price;
		this.months = months;
	}

	public double getPrice() {
		return price;
	}

	public int getMonths() {
		return months;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
