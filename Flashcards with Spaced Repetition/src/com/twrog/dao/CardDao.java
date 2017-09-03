package com.twrog.dao;

import java.util.List;

import com.twrog.dto.Card;

public interface CardDao {

	void open(String cardDeck) throws DataPersistenceException;

	void close(String cardDeck) throws DataPersistenceException;

	List<Card> getCards();

}