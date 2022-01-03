package Iteration2Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import objects.Card;
import objects.Game;

import org.junit.Test;

public class xtest12StunnedIvanhoed {

	@Test
	public void test() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("kevin");
		names.add("james");
		Game game = new Game(2, names);
		ArrayList<Card> p1Hand = new ArrayList<Card>();
		ArrayList<Card> p2Hand = new ArrayList<Card>();
		Card p1Card1 = new Card("Action", 0, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false);
		Card p1Card2 = new Card("Blue", 5, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card p2Card1 = new Card("Blue", 4, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card p2Card2 = new Card("Blue", 4, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card p2Card3 = new Card("Action", 0, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false);
		p1Hand.add(p1Card1);
		p1Hand.add(p1Card2);
		p2Hand.add(p2Card1);
		p2Hand.add(p2Card2);
		p2Hand.add(p2Card3);
		
		game.startGame();
		game.getPlayerArray().get(0).setHand(p1Hand);
		game.getPlayerArray().get(1).setHand(p2Hand);
		game.update(0, "Blue");
		
		game.update(0, 1);
		game.getPlayerArray().get(0).setTargetPlayer(1);
		//player 1 stuns player 2
		game.update(0, 0);
		game.update(0, true);
		assertEquals(true, game.getPlayerArray().get(1).isStunned());
	
		//player 2 plays ivanhoe
		game.update(1, 2);
		//stunned undone
		assertEquals(false, game.getPlayerArray().get(1).isStunned());
		//player can play more than one card
		game.update(1, 0);
		assertEquals(4, game.getPlayerArray().get(1).getPlayedValue());
		assertEquals(1, game.getPlayerArray().get(1).getDisplay().size());
		assertEquals(1, game.getPlayerArray().get(1).getHand().size());
		
		game.update(1, 0);
		assertEquals(8, game.getPlayerArray().get(1).getPlayedValue());
		assertEquals(2, game.getPlayerArray().get(1).getDisplay().size());
		assertEquals(0, game.getPlayerArray().get(1).getHand().size());
	}

}
