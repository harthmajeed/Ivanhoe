package Iteration2Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import objects.Card;
import objects.Game;

import org.junit.Test;

public class xtest12ShieldNoEffect {

	@Test
	public void test() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("kevin");
		names.add("james");
		Game game = new Game(2, names);
		ArrayList<Card> p1Hand = new ArrayList<Card>();
		Card p1Card1 = new Card("Action", 0, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card p1Card2 = new Card("Blue", 4, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		p1Hand.add(p1Card1);
		p1Hand.add(p1Card2);
	
		
		game.startGame();
		game.getPlayerArray().get(0).setHand(p1Hand);
		
		game.update(0, "Blue");
		//Set player 1 to sheilded
		game.getPlayerArray().get(0).setSheilded(true);
		
		assertEquals(2, game.getPlayerArray().get(0).getHand().size());
		//try to play sheild
		game.update(0, 0);
		//sheild has no effect since already sheilded. sheild not played
		assertEquals(2, game.getPlayerArray().get(0).getHand().size());
	
		
	
	}

}
