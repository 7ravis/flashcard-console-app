package com.twrog.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.twrog.dto.Card;

public class CardDao_FileIO implements CardDao {
	private List<Card> cards;
	private final String DELIM = "::";
	
	@Override
	public void open(String cardDeck) throws DataPersistenceException {
		Scanner sc = null;
		try {
			sc = new Scanner(new FileReader(cardDeck + ".txt"));
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
		} catch (FileNotFoundException e) {
			throw new DataPersistenceException("Error: " + cardDeck + ".txt not found.");
		}
		
	}

	@Override
	public void close(String cardDeck) throws DataPersistenceException {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(cardDeck + ".txt");
			for (Card card : cards) {
				pw.println(String.join(DELIM, card.getFront(), card.getBack(), String.valueOf(card.getCycleCounter()), String.valueOf(card.getCycleThreshold()), String.valueOf(card.getPriority())));
			}
			pw.flush();
			pw.close();
			cards = null;
		} catch (FileNotFoundException e) {
			throw new DataPersistenceException("Error: session data for " + cardDeck + " could not be persisted");
		}
	}

	@Override
	public List<Card> getCards() {
		return cards;
	}
	
}
