package com.twrog.ui;

import java.util.Scanner;

import com.twrog.dto.Card;

public class CardUI_Console implements CardUI {
	@Override
	public void open() {
		System.out.println("Welcome to Notecards with Spaced Repetition!");
	}
	@Override
	public void close() {}
	@Override
	public int mainMenu() {
		System.out.println("\n===MAIN MENU===");
		return readInt("1. Open new deck \n2. Reverse card sides \n3. Exit program", 1, 3);
	}
	@Override
	public String getCardDeckName() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\nWhich notecard deck would you like to practice? (Or press \"Enter\" to exit the program.)");
		String input = sc.nextLine();
		if (input.equals("\n")) { return null; }
		else { return input; }
	}
	@Override
	public int testCard(Card card, boolean frontToBack) {
		String side1 = null;
		String side2 = null;
		if (frontToBack) {
			side1 = card.getFront();
			side2 = card.getBack();
		} else {
			side1 = card.getBack();
			side2 = card.getFront();
		}
		System.out.println("\n" + side1);
		readString("\nPress any key to flip card.");
		System.out.println("\n" + side2);
		return readInt("\nDid you get it right? \n1. Yes \n2. No \n3. Exit to main menu", 1, 3);
	}
	@Override
	public void displayErrorMessage(String message) {
		System.out.println(message);
	}
	
	private static String readString(String prompt) {
        Scanner sc = new Scanner(System.in);
        System.out.println(prompt);
        return sc.nextLine();
    }
	private static int readInt(String prompt, int min, int max) {
        boolean isValid;
        int input = 0;
        do {
            isValid = true;
            try {
            input = Integer.parseInt(readString(prompt));
            if (input < min || input > max) {
                System.out.println("\nError: input is out of range.");
                isValid = false;
            }
            } catch (NumberFormatException e) {
            	System.out.println("\nError: input cannot be parsed.");
            	isValid = false;
            }            
        } while (!isValid);
        return input;
    }
	
}
