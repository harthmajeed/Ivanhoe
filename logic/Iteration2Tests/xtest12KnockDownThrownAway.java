package Iteration2Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import objects.Card;
import objects.Game;

import org.junit.Test;

public class xtest12KnockDownThrownAway {

	@Test
	public void test() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("kevin");
		names.add("james");
		Game game = new Game(2, names);
		ArrayList<Card> p1Hand = new ArrayList<Card>();
		ArrayList<Card> p2Hand = new ArrayList<Card>();
		Card p1Card1 = new Card("Action", 0, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false);
		Card p1Card2 = new Card("Blue", 4, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card p2Card1 = new Card("Blue", 4, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card p2Card2 = new Card("Blue", 5, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		p1Hand.add(p1Card1);
		p1Hand.add(p1Card2);
		p2Hand.add(p2Card1);
		p2Hand.add(p2Card2);
		
		game.startGame();
		game.getPlayerArray().get(0).setHand(p1Hand);
		game.getPlayerArray().get(1).setHand(p2Hand);
		game.update(0, "Blue");
		
		assertEquals(2, game.getPlayerArray().get(0).getHand().size());
		assertEquals(2, game.getPlayerArray().get(1).getHand().size());
		assertEquals(0, game.getPlayerArray().get(0).getDisplay().size());
		
		game.getPlayerArray().get(0).setTargetPlayer(1);
		game.update(0, 0);
	
		//player 1 has his original blue card and the card he took from player 2 in his hand
		//player 1 has no cards in his display or face up
		assertEquals(2, game.getPlayerArray().get(0).getHand().size());
		assertEquals(1, game.getPlayerArray().get(1).getHand().size());
		assertEquals(0, game.getPlayerArray().get(0).getDisplay().size());
		assertEquals(0, game.getPlayerArray().get(0).getFaceUpCards().size());
		
	}

}
