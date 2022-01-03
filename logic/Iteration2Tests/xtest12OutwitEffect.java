package Iteration2Tests;


import static org.junit.Assert.*;

import java.util.ArrayList;

import objects.Card;
import objects.Game;

import org.junit.Test;

public class xtest12OutwitEffect {

	@Test
	public void test() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("kevin");
		names.add("james");
		Game game = new Game(2, names);
		ArrayList<Card> p1Hand = new ArrayList<Card>();
		ArrayList<Card> p2Hand = new ArrayList<Card>();
		Card p1Card1 = new Card("Blue", 4, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card p1Card2 = new Card("Blue", 5, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card p2Card1 = new Card("Action", 0, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true);
		Card p2Card2 = new Card("Blue", 2, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card p2Card3 = new Card("Blue", 2, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		p1Hand.add(p1Card1);
		p1Hand.add(p1Card2);
		p2Hand.add(p2Card1);
		p2Hand.add(p2Card2);
		p2Hand.add(p2Card3);
		
		game.startGame();
		game.getPlayerArray().get(0).setHand(p1Hand);
		game.getPlayerArray().get(1).setHand(p2Hand);
		game.update(0, "Blue");
		
		game.update(0, 0);
		game.update(0, 0);
	
		assertEquals(9, game.getPlayerArray().get(0).getPlayedValue());
		
		game.update(0, true);
		
		game.getPlayerArray().get(1).setTargetPlayer(0);
		game.getPlayerArray().get(1).setChosenCard(1);
		game.getPlayerArray().get(1).setGivenCard(0);
		
		game.update(1, 1);
		game.update(1, 1);
		
		assertEquals(4, game.getPlayerArray().get(1).getPlayedValue());
		
		game.update(1, 0);
		
		assertEquals(6, game.getPlayerArray().get(0).getPlayedValue());
		assertEquals(7, game.getPlayerArray().get(1).getPlayedValue());
	}

}
