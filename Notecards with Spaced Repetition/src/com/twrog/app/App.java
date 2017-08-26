package com.twrog.app;

import com.twrog.controller.CardController;
import com.twrog.dao.CardDao;
import com.twrog.dao.CardDao_FileIO;
import com.twrog.service.CardService;

public class App {

	public static void main(String[] args) {
		if (args.length == 1) {
			CardDao cardDao = new CardDao_FileIO(args[0]);
			CardService cardService = new CardService(cardDao);
			CardController cardController = new CardController(cardService);
			cardController.run();
		} else {
			System.out.println("Error: expected 1 argument. Found " + args.length);
		}
	}

}
