package com.twrog.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twrog.dao.CardDao;
import com.twrog.dao.CardDaoInMem;
import com.twrog.dto.Card;

public class CardServiceTest {
	private List<Card> cards;

	@Before
	public void setUp() {
		cards = new ArrayList<>();
		Card c1 = new Card("1Front", "1Back");
		c1.setCycleCounter(1);
		c1.setCycleThreshold(2);
		c1.setPriority(3);
		cards.add(c1);
		Card c2 = new Card("2Front", "2Back");
		c2.setCycleCounter(3);
		c2.setCycleThreshold(3);
		c2.setPriority(2);
		cards.add(c2);
		Card c3 = new Card("3Front", "3Back");
		c3.setCycleCounter(4);
		c3.setCycleThreshold(1);
		c3.setPriority(1);
		cards.add(c3);
		Card c4 = new Card("4Front", "4Back");
		c4.setCycleCounter(0);
		c4.setCycleThreshold(0);
		c4.setPriority(1);
		cards.add(c4);
		Card c5 = new Card("5Front", "5Back");
		c5.setCycleCounter(1);
		c5.setCycleThreshold(5);
		c5.setPriority(1);
		cards.add(c5);
		Card c6 = new Card("6Front", "6Back");
		c6.setCycleCounter(1);
		c6.setCycleThreshold(2);
		c6.setPriority(2);
		cards.add(c6);
		CardDao dao = new CardDaoInMem(cards);
	}

	@After
	public void tearDown() {
	}

	/**
	 * Test of getNextCard method, of class CardService.
	 */
	@Test
	public void testGetNextCard() {
		
	}

}
