package com.twrog.controller;

import java.util.List;

import com.twrog.dao.DataPersistenceException;
import com.twrog.dto.Card;
import com.twrog.service.CardService;
import com.twrog.ui.CardUI;

public class CardController {
	private static CardService service;
	private static CardUI view;
	private String cardDeck;
	private static boolean frontToBack = true;
	
	public CardController(CardService service, CardUI view) {
		this.service = service;
		this.view = view;
	}
	
	public void run() {
		view.open();
		boolean keepRunning = true;
		while (keepRunning) {
			switch (view.mainMenu()) {
			case 1: //Open new deck
				cardDeck = view.getCardDeckName();
				if (cardDeck == null) { return; }
				try {
				service.open(cardDeck);
				runDeck();
				} catch (DataPersistenceException e) {
					view.displayErrorMessage(e.getMessage());
					cardDeck = null;
				}
				break;
			case 2: //Return to current deck
				if (cardDeck != null) {
				runDeck();
				} else { view.displayErrorMessage("Error: no deck is loaded."); }
				break;
			case 3: //Reverse card sides
				frontToBack = !frontToBack;
				break;
			case 4: //Exit program
				try {
				service.close(cardDeck);
				} catch (DataPersistenceException e) {
					view.displayErrorMessage(e.getMessage());
				}
				keepRunning = false;
				break;
			default:
				view.displayErrorMessage("Error: A navigation problem was encountered. Exiting program.");
				try {
					service.close(cardDeck);
					} catch (DataPersistenceException e) {
						view.displayErrorMessage(e.getMessage());
					}
				keepRunning = false;
			}			
		}
	}
	
	private static void runDeck() {
		boolean keepRunning = true;
		while (keepRunning) {
			Card card = service.getNextCard();
			switch (view.testCard(card, frontToBack)) {
				case 1: //Answered correctly
					service.updateCards(card, true);
					break;
				case 2: //Answered incorrectly
					service.updateCards(card, false);
					break;
				case 3: //Exit to main menu
					keepRunning = false;
					break;
				default:				
					view.displayErrorMessage("Error: the program encountered a problem. Returning to main menu.");
					keepRunning = false;
			}
		}
	}
}
