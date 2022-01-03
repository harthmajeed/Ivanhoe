package Iteration2Tests;


import static org.junit.Assert.*;

import java.util.ArrayList;

import objects.Card;
import objects.Game;

import org.junit.Test;

public class ztest7 {

	@Test
	public void test() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("kevin");
		names.add("james");
		Game game = new Game(2, names);
		ArrayList<Card> p1Hand = new ArrayList<Card>();
		ArrayList<Card> p2Hand = new ArrayList<Card>();
		Card p1Card1 = new Card("Blue", 4, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card p3Card1 = new Card("Action", 0, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false);
		Card p3Card2 = new Card("Action", 0, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false);
		Card p3Card3 = new Card("Action", 0, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false);
		Card p3Card4 = new Card("Action", 0, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false);
		
		
		p1Hand.add(p1Card1);
		p2Hand.add(p3Card1);
		p2Hand.add(p3Card2);
		p2Hand.add(p3Card3);
		p2Hand.add(p3Card4);
		
		game.startGame();
		game.getPlayerArray().get(0).setHand(p1Hand);
		game.getPlayerArray().get(1).setHand(p2Hand);
		
		game.update(0, "Blue");
		
		game.update(0, 0);
		game.update(0, true);
		
		//player 2 tries to play 4 outmaneuvers
		game.update(1, 3);
		game.update(1, 2);
		game.update(1, 1);
		game.update(1, 0);
		
		//player 1 still has the one card in his display, you cant get rid of it!!!!
		assertEquals(1, game.getPlayerArray().get(0).getDisplay().size());
		
	}

}
