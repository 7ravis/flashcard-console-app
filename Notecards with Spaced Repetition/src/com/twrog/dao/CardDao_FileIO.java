package com.twrog.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.twrog.dto.Card;

public class CardDao_FileIO implements CardDao {
	private List<Card> cards;
	private final String DELIM = "::";
	
	@Override
	public void open(String cardDeck) {
		Scanner sc = null;
		try {
			sc = new Scanner(new FileReader(cardDeck + ".txt"));
		} catch (FileNotFoundException e) {
			System.out.println("Error: " + cardDeck + ".txt not found.");
			e.printStackTrace();
		}
		cards = new ArrayList<>();
		while (sc.hasNextLine()) {
			String[] input = sc.nextLine().split(DELIM);
			Card card = new Card(input[0], input[1]);
			if (input.length == 5) {
				card.setCycleCounter(Integer.parseInt(input[2]));
				card.setCycleThreshold(Integer.parseInt(input[3]));
				card.setPriority(Integer.parseInt(input[4]));
			}
			cards.add(card);
		}
	}

	@Override
	public void close(String cardDeck) {
		
	}

	@Override
	public List<Card> getCards() {
		return cards;
	}
	
}
