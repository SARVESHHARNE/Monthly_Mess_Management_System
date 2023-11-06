package com.utils;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import com.core.Customer;
import com.core.enums.Plan;
import com.exception.InvalidInputException;

public interface CustUtils {
	static Map<String, Customer> populateMap() {
		Map<String, Customer> custMap = new HashMap<>();
		custMap.put("sarvesh@gmail.com",
				new Customer(1, "sarvesh", "harne", "sarvesh@gmail.com", "password", "amt 444605",
						LocalDate.parse("2023-01-01"), LocalDate.parse("2023-02-01"), "00000", Plan.MONTHLY, 3000));
		custMap.put("ram@gmail.com", new Customer(1, "ram", "harne", "ram@gmail.com", "password", "akurdi 444605",
				LocalDate.parse("2023-02-01"), LocalDate.parse("2023-05-01"), "00000", Plan.QUARTERLY, 11700));
		custMap.put("sham@gmail.com", new Customer(1, "sham", "harne", "sham@gmail.com", "password", "amt 444605",
				LocalDate.parse("2023-01-01"), LocalDate.parse("2024-01-01"), "00000", Plan.YEARLY, 32000));
		return custMap;
	}

}
