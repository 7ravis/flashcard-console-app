package com.twrog.app;

import com.twrog.controller.CardController;
import com.twrog.dao.CardDao;
import com.twrog.dao.CardDao_FileIO;
import com.twrog.service.CardService;
import com.twrog.ui.CardUI_Console;

public class App {

	public static void main(String[] args) {
			CardDao cardDao = new CardDao_FileIO();
			CardService cardService = new CardService(cardDao);
			CardController cardController = new CardController(cardService, new CardUI_Console());
			cardController.run();
	}

}
