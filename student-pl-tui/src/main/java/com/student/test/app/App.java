package com.student.test.app;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.student.test.service.AppService;

public class App {

	public static void main(String[] args) {
		System.out.println("Welcome to the Student App!");
		AppService service = new AppService();

		try (Scanner scan = new Scanner(System.in)) {
			while (true) {
				System.out.println("\n1 Add student ");
				System.out.println("2 Update student ");
				System.out.println("3 List all students ");
				System.out.println("4 Search student ");
				System.out.println("5 Delete student ");
				System.out.println("6 Exit ");
				System.out.print("Choose your option: ");
				try {
					int i = Integer.parseInt(scan.next());

					if (i == 1) {
						service.add(scan);
					} else if (i == 2) {
						service.update(scan);
					} else if (i == 3) {
						service.searchAll();
					} else if (i == 4) {
						service.searchById(scan);
					} else if (i == 5) {
						service.delete(scan);
					} else if (i == 6) {
						System.out.println("Thanks for using the application...\nBye bye!");
						break;
					} else if (i != 0) {
						System.out.println("!Invalid input, please try again.");
					}
				} catch (InputMismatchException e) {
					System.out.println("!Invalid input, please try again.");
					scan.next();
				} catch (NumberFormatException e) {
					System.out.println("!Invalid digit: " + e.getMessage());
				} catch (Exception e) {
					System.out.println("Exception occurred: " + e.getMessage());
				}

			}
		}
	}
}
