package com.twrog.service;

import java.util.ArrayList;
import java.util.List;

import com.twrog.dao.CardDao;
import com.twrog.dao.DataPersistenceException;
import com.twrog.dto.Card;

public class CardService {
	private CardDao dao;
	private Card[] nextCardDeck;
	
	public CardService(CardDao dao) {
		this.dao = dao;
	}
	
	public void open(String cardDeck) throws DataPersistenceException {
		dao.open(cardDeck);
	}
	
	public void close(String cardDeck) throws DataPersistenceException {
		dao.close(cardDeck);
	}
	
	public void updateCards(Card card, boolean isCorrect) {
		List<Card> cards = dao.getCards();
		cards.remove(card);
		card.setCycleCounter(0);
		if (isCorrect == false) {
			card.setPriority(1);
			card.setCycleThreshold(10);
		} else {
			int currentPriority = card.getPriority();
			if (currentPriority != 5) {
				card.setPriority(currentPriority + 1);
			}
			card.setCycleThreshold(15);
		}
		cards.add(card);
	}
	
	public Card getNextCard() {
		List<Card> cards = dao.getCards();
		if (cards == null || cards.size() == 0) {
			return null;
		} 
		nextCardDeck = new Card[5];
		for (int i = 0; i < cards.size(); i++) {
			Card card = cards.get(i);
			if (card.getCycleCounter() >= card.getCycleThreshold()) {
				switch (card.getPriority()) {
					case 1:
						if (nextCardDeck[0] == null) {
							nextCardDeck[0] = card;
						};
						break;
					case 2:
						if (nextCardDeck[1] == null) {
							nextCardDeck[1] = card;
						}
						break;
					case 3:
						if (nextCardDeck[2] == null) {
							nextCardDeck[2] = card;
						}
						break;
					case 4:
						if (nextCardDeck[3] == null) {
							nextCardDeck[3] = card;
						}
						break;
					case 5:
						if (nextCardDeck[4] == null) {
							nextCardDeck[4] = card;
						}
						break;
					default:
						System.out.println("Card priority value is not 1-5.");
				}
			}
			card.setCycleCounter(card.getCycleCounter() + 1);
		}
		for (int i = 0; i < nextCardDeck.length; i++) {
			if (nextCardDeck[i] != null) {
				return nextCardDeck[i];
			}
		}
		return cards.get(0);
	}
}
