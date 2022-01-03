package Iteration2Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import objects.Card;
import objects.Game;

import org.junit.Test;

public class xtest12AdaptThrownAway {

	@Test
	public void test() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("kevin");
		names.add("james");
		names.add("harth");
		Game game = new Game(3, names);
		ArrayList<Card> p1Hand = new ArrayList<Card>();
		ArrayList<Card> p2Hand = new ArrayList<Card>();
		ArrayList<Card> p3Hand = new ArrayList<Card>();
		Card p1Card1 = new Card("Blue", 4, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card p1Card2 = new Card("Blue", 4, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card p1Card3 = new Card("Blue", 5, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card p2Card1 = new Card("Blue", 4, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card p2Card2 = new Card("Blue", 5, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card p2Card3 = new Card("Blue", 5, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card p3Card1 = new Card("Action", 0, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false);
		Card p3Card2 = new Card("Blue", 4, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card p3Card3 = new Card("Blue", 4, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		p1Hand.add(p1Card1);
		p1Hand.add(p1Card2);
		p1Hand.add(p1Card3);
		p2Hand.add(p2Card1);
		p2Hand.add(p2Card2);
		p2Hand.add(p2Card3);
		p3Hand.add(p3Card1);
		p3Hand.add(p3Card2);
		p3Hand.add(p3Card3);
		
		game.startGame();
		game.getPlayerArray().get(0).setHand(p1Hand);
		game.getPlayerArray().get(1).setHand(p2Hand);
		game.getPlayerArray().get(2).setHand(p3Hand);
		
		game.update(0, "Blue");
		
		game.update(0, 0);
		game.update(0, 0);
		game.update(0, 0);
		game.update(0, true);
		
		game.update(1, 0);
		game.update(1, 0);
		game.update(1, 0);
		game.update(1, true);
		
		game.update(2, 1);
		game.update(2, 1);
		
		assertEquals(13, game.getPlayerArray().get(0).getPlayedValue());
		assertEquals(14, game.getPlayerArray().get(1).getPlayedValue());
		assertEquals(8, game.getPlayerArray().get(2).getPlayedValue());
		assertEquals(3, game.getPlayerArray().get(0).getDisplay().size());
		assertEquals(3, game.getPlayerArray().get(1).getDisplay().size());
		assertEquals(2, game.getPlayerArray().get(2).getDisplay().size());
		
		ArrayList<Card> p1Kept = new ArrayList<Card>();
		ArrayList<Card> p2Kept = new ArrayList<Card>();
		ArrayList<Card> p3Kept = new ArrayList<Card>();
		
		p1Kept.add(p1Card1);
		p1Kept.add(p1Card3);
		p2Kept.add(p2Card1);
		p2Kept.add(p2Card2);
		p3Kept.add(p3Card3);
		
		game.update(2, 0);
		
		game.getPlayerArray().get(0).setKeptCards(p1Kept);
		game.getPlayerArray().get(1).setKeptCards(p2Kept);
		game.getPlayerArray().get(2).setKeptCards(p3Kept);
		
		game.afterAdaptPopup();
		
		assertEquals(9, game.getPlayerArray().get(0).getPlayedValue());
		assertEquals(9, game.getPlayerArray().get(1).getPlayedValue());
		assertEquals(4, game.getPlayerArray().get(2).getPlayedValue());
		assertEquals(2, game.getPlayerArray().get(0).getDisplay().size());
		assertEquals(2, game.getPlayerArray().get(1).getDisplay().size());
		assertEquals(1, game.getPlayerArray().get(2).getDisplay().size());
		
		//adapt is gone from player 3's hand, obviously not in display from above assertions
		//only card left in player 3's hand is the card he drew when he started his turn.
		assertEquals(1, game.getPlayerArray().get(2).getHand().size());
	}

}
