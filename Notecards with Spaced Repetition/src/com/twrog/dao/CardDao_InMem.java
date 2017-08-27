package com.twrog.dao;

import java.util.ArrayList;
import java.util.List;

import com.twrog.dto.Card;

public class CardDao_InMem implements CardDao {
	private List<Card> cards;
	
	public CardDao_InMem(List<Card> cards) {
		this.cards = cards;
	}
	
	@Override
	public void open(String cardDeck) throws DataPersistenceException {
		
	}

	@Override
	public void close(String cardDeck) throws DataPersistenceException {
		
	}

	@Override
	public List<Card> getCards() {
		return cards;
	}

}
