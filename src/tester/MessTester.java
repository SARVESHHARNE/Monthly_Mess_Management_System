package tester;

import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import static com.utils.CustUtils.populateMap;
import static com.validations.CustValidation.*;
import com.core.Customer;
import com.core.enums.Plan;

public class MessTester {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			Map<String, Customer> custMap = populateMap();
			boolean exit = false;
			while (!exit) {
				System.out.println("1. Sign up Customer\r\n" + "2. If already register then sign in\r\n"
						+ "3. Change Password\r\n" + "4. Sort Customer as per \r\n"
						+ "5. Unsubscribe customer according plan duration (month wise (1, 3, 6, 12))\r\n"
						+ "6. Display all Customers\r\n"
						+ "7) Modify all customers first name (make first Letter capital of customers first name)\r\n"
						+ "8) Display email addresses of the customers who did registration in month of January\r\n"
						+ "9)Display count of the Customerswho have register for plan:Monthly\r\n"
						+ "10) Search the Customer who lived in Akurdi.\r\n"
						+ "11) Give the 20% discount to the customers who have selected plan for 1 year.\r\n"
						+ "0) exit");
				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println("custId,  fName, lName,email, password, address,"
								+ "	 regDate,  phoneNO,  plan(MONTHLY(3000)|QUARTERLY(11700)|HALFYEAR(17500)|YEARLY(32000)),final_amt");
						Customer c = parseAndValidateCustomer(sc.nextInt(), sc.next(), sc.next(), sc.next(), sc.next(),
								sc.next(), sc.next(), sc.next(), sc.next(), sc.nextDouble(), custMap);
						custMap.put(c.getEmail(), c);
						break;
					case 2:
						System.out.println("enter email : ");
						String email = sc.next();
						validateEmail(email);
						c = custMap.get(email);
						if (c != null) {
							System.out.println("enter Password: ");
							if (c.getPassword().equals(sc.next()))
								System.out.println("sign in succesful");
							else
								System.out.println("wrong password");
						} else
							System.out.println("no such customer exists ");
						break;
					case 3:
						System.out.println("enter email : ");
						email = sc.next();
						validateEmail(email);
						c = custMap.get(email);
						if (c != null) {
							System.out.println("enter old Password: ");
							if (c.getPassword().equals(sc.next())) {
								System.out.println("enter new password:  ");
								c.setPassword(sc.next());
							} else
								System.out.println("wrong password");
						}
						break;
					case 4:
						System.out.println("A) First name \r\n" + "B) According to plan\r\n"
								+ "C) According to date of registration\r\n" + "");
						switch (sc.next().charAt(0)) {
						case 'A':
						case 'a':
							custMap.values().stream().sorted((c1, c2) -> c1.getfName().compareTo(c2.getfName()))
									.forEach(System.out::println);
							break;
						case 'B':
						case 'b':
							custMap.values().stream().sorted((c1, c2) -> c1.getPlan().compareTo(c2.getPlan()))
									.forEach(System.out::println);
							break;
						case 'C':
						case 'c':
							custMap.values().stream().sorted((c1, c2) -> c1.getRegDate().compareTo(c2.getRegDate()))
									.forEach(System.out::println);
							break;

						}
						break;
					case 5:
						System.out.println("Enter no of months : ");
						int n = sc.nextInt();
						custMap = custMap.values().stream().filter(s -> s.getPlan().getMonths() != n)
								.collect(Collectors.toMap(s -> s.getEmail(), s -> s));
						System.out.println("removed ");
						break;
					case 7:
						custMap = custMap.values().stream()
								.peek(s -> s.setfName(s.getfName().replaceFirst("" + s.getfName().charAt(0),
										("" + s.getfName().charAt(0)).toUpperCase())))

								.collect(Collectors.toMap(s -> s.getEmail(), s -> s));
						break;
					case 6:
						custMap.forEach((k, v) -> System.out.println(v));
						break;
					case 8:
						custMap.values().stream()
								.filter(s -> s.getRegDate().getMonth().name().equals("January".toUpperCase()))
								.map(s -> s.getEmail()).forEach(System.out::println);
						break;
					case 9:
						System.out.println("Count for monthly cust :"
								+ custMap.values().stream().filter(s -> s.getPlan().getMonths() == 1).count());
						break;
					case 10:
						custMap.values().stream()
								.filter(s -> s.getAddress().toUpperCase().contains("akurdi".toUpperCase()))
								.forEach(System.out::println);
						break;
					case 11:
						custMap.values().stream().filter(s -> s.getPlan().getMonths() == 12)
								.peek(s -> s.setFinal_amt(s.getFinal_amt() * 0.8)).forEach(System.out::println);
						break;
					case 0:
						exit = true;
						break;
					}
				} catch (Exception e) {
					sc.nextLine();
					System.out.println(e);
				}
			}
		}
	}
}
