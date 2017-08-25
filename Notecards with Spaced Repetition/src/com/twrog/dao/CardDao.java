package com.twrog.dao;

import java.util.List;

import com.twrog.dto.Card;

public interface CardDao {

	void open();

	void close();

	List<Card> getCards();

}