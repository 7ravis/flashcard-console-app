package com.twrog.dao;

import java.util.ArrayList;
import java.util.List;

import com.twrog.dto.Card;

public class CardDaoInMem implements CardDao {
	private List<Card> cards;
	
	public CardDaoInMem(List<Card> cards) {
		this.cards = cards;
	}
	
	@Override
	public void open() {
		
	}

	@Override
	public void close() {
		
	}

	@Override
	public List<Card> getCards() {
		return cards;
	}

}
