package com.twrog.ui;

import com.twrog.dto.Card;

public interface CardUI {

	void open();

	void close();
	
	int mainMenu();

	String getCardDeckName();

	int testCard(Card card, boolean frontToBack);
	
	public void displayErrorMessage(String message);

}