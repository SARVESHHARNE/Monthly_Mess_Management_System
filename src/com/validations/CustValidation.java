package com.validations;

import java.time.LocalDate;
import java.util.Map;

import com.core.Customer;
import com.core.enums.Plan;
import com.exception.InvalidInputException;

public class CustValidation {
	public static void checkDuplicte(Map<String, Customer> custMap, String email) throws InvalidInputException {
		validateEmail(email);
		if (custMap.containsKey(email))
			throw new InvalidInputException("already exists !!!!!");
	}

	public static void validateEmail(String email) throws InvalidInputException {
		if (!email.matches("[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}"))
			throw new InvalidInputException("Enter email properly");
	}

	public static void validateMobileNo(String no) throws InvalidInputException {
		if (!no.matches("[0-9]{10}")) {
			throw new InvalidInputException("Enter mobile no properly!!!!");
		}
	}

	public static Plan parseAndValidatePlan(String plan, double amt) throws InvalidInputException {
		Plan p = Plan.valueOf(plan.toUpperCase());
		if (p.getPrice() != amt)
			throw new InvalidInputException("invalid amount ");
		return p;
	}

	public static LocalDate parseAndValidateDate(String date) {
		return LocalDate.parse(date);
	}

	public static Customer parseAndValidateCustomer(int custId, String fName, String lName, String email,
			String password, String address, String regDate, String phoneNO, String plan, double final_amt,
			Map<String, Customer> custMap) throws InvalidInputException {
		validateEmail(email);
		checkDuplicte(custMap, email);
		validateMobileNo(phoneNO);
		LocalDate reg = parseAndValidateDate(regDate);
		Plan p = parseAndValidatePlan(plan, final_amt);
		return new Customer(custId, fName, lName, email, password, address, reg, reg.plusMonths(p.getMonths()), phoneNO,
				p, final_amt);
	}

}
