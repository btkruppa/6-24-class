package com.revature.prompts;

import java.util.Scanner;

import com.revature.daos.CardDao;
import com.revature.models.Card;

public class SellCardPrompt implements Prompt {
	private Scanner scan = new Scanner(System.in);
	private CardDao cardDao = CardDao.currentImplementation;

	@Override
	public Prompt run() {
		System.out.println("Enter card name: ");
		String name = scan.nextLine();

		double value;
		while (true) {
			try {
				System.out.println("Enter card value: ");
				value = Double.valueOf(scan.nextLine());
				break; // exit while loop
			} catch (NumberFormatException e) {
				System.out.println("that is not a valid number, try again");
			}
		}

		System.out.println("Enter card's game: ");
		String game = scan.nextLine();

		System.out.println("Enter card description: ");
		String description = scan.nextLine();

		System.out.println("Enter card condition: ");
		String condition = scan.nextLine();

		Card c = new Card(name, value, game, description, condition);

		String option;
		do {
			System.out.println("Are you sure you want to sell this card? y/n\n " + c);
			option = scan.nextLine();
			if (option.equals("y")) {
				cardDao.save(c);
			}
		} while (!(option.equalsIgnoreCase("y") || option.equalsIgnoreCase("n")));
		return new HomePrompt();
	}

}
