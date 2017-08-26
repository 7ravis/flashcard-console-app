package com.twrog.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twrog.dto.Card;

public class CardDao_FileIOTest {

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	/**
	 * Test of open method, of class CardDao_FileIOTest
	 */
	@Test
	public void testOpen() {
		CardDao dao = new CardDao_FileIO();
		dao.open("fileOpenMethodTestFile");
		List<Card> cards = dao.getCards();
		assertEquals("one", cards.get(0).getFront());
		assertEquals("card one", cards.get(0).getBack());
		assertEquals(0, cards.get(0).getCycleCounter());
		assertEquals(0, cards.get(0).getCycleThreshold());
		assertEquals(1, cards.get(0).getPriority());
		
		assertEquals("two", cards.get(1).getFront());
		assertEquals("card two", cards.get(1).getBack());
		assertEquals(2, cards.get(1).getCycleCounter());
		assertEquals(3, cards.get(1).getCycleThreshold());
		assertEquals(1, cards.get(1).getPriority());
		
		assertEquals(2, cards.size());
	}

}
