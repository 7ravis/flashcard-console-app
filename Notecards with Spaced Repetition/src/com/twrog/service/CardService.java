package com.twrog.service;

import java.util.ArrayList;
import java.util.List;

import com.twrog.dao.CardDao;
import com.twrog.dto.Card;

public class CardService {
	private CardDao dao;
	private Card[] nextCardDeck;
	
	public CardService(CardDao dao) {
		this.dao = dao;
	}
	
	public Card getNextCard() {
		List<Card> cards = dao.getCards();
		if (cards == null || cards.size() == 0) {
			return null;
		} 
		nextCardDeck = new Card[4];
		for (int i = 0; i < cards.size(); i++) {
			Card card = cards.get(i);
			if (card.getCycleCounter() >= card.getCycleThreshold()) {
				switch (card.getPriority()) {
					case 1:
						return card;
					case 2:
						if (nextCardDeck[0] == null) {
							nextCardDeck[0] = card;
						}
						break;
					case 3:
						if (nextCardDeck[1] == null) {
							nextCardDeck[1] = card;
						}
						break;
					case 4:
						if (nextCardDeck[2] == null) {
							nextCardDeck[2] = card;
						}
						break;
					case 5:
						if (nextCardDeck[3] == null) {
							nextCardDeck[3] = card;
						}
						break;
					default:
						System.out.println("Card priority value is not 1-5.");
				}
			}
		}
		for (int i = 0; i < nextCardDeck.length; i++) {
			if (nextCardDeck[i] != null) {
				return nextCardDeck[i];
			}
		}
		return cards.get(0);
	}
}
