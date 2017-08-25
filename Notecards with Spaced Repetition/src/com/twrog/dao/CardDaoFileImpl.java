package com.twrog.dao;

import java.util.ArrayList;
import java.util.List;

import com.twrog.dto.Card;

public class CardDaoFileImpl implements CardDao {
	private String dataSource;
	private List<Card> cards;
	
	public CardDaoFileImpl(String dataSource) {
		this.dataSource = dataSource;
		cards = new ArrayList<>();
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
