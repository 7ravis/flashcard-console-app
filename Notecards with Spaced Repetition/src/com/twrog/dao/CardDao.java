package com.twrog.dao;

import java.util.List;

import com.twrog.dto.Card;

public interface CardDao {

	void open(String cardDeck);

	void close(String cardDeck);

	List<Card> getCards();

}