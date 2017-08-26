package com.twrog.dao;

import java.util.ArrayList;
import java.util.List;

import com.twrog.dto.Card;

public class CardDao_FileIO implements CardDao {
	private String dataSource;
	private List<Card> cards;
	
	public CardDao_FileIO(String dataSource) {
		this.dataSource = dataSource;
		cards = new ArrayList<>();
	}
	
	@Override
	public void open(String cardDeck) {
		
	}

	@Override
	public void close(String cardDeck) {
		
	}

	@Override
	public List<Card> getCards() {
		return cards;
	}
	
}
