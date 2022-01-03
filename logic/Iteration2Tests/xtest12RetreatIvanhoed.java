package Iteration2Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import objects.Card;
import objects.Game;

import org.junit.Test;

public class xtest12RetreatIvanhoed {

	@Test
	public void test() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("kevin");
		names.add("james");
		Game game = new Game(2, names);
		ArrayList<Card> p1Hand = new ArrayList<Card>();
		Card p1Card = new Card("Blue", 4, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card p1Card2 = new Card("Blue", 5, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card p1Card3 = new Card("Action", 0, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false);
		Card p1Card4 = new Card("Action", 0, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false);
		
		p1Hand.add(p1Card);
		p1Hand.add(p1Card2);
		p1Hand.add(p1Card3);
		p1Hand.add(p1Card4);
		
		game.startGame();
		game.getPlayerArray().get(0).setHand(p1Hand);
		game.update(0, "Blue");
		
		game.update(0, 0);
		game.update(0, 0);
		
		assertEquals(9, game.getPlayerArray().get(0).getPlayedValue());
		
		game.getPlayerArray().get(0).setChosenCard(1);
		//player 1 plays retreat
		game.update(0, 0);
		
		assertEquals(4, game.getPlayerArray().get(0).getPlayedValue());
		assertEquals(2, game.getPlayerArray().get(0).getHand().size());
		assertEquals(p1Card2, game.getPlayerArray().get(0).getHand().get(1));
		
		//player 1 plays ivanhoe
		game.update(0, 0);
		// retreat undone
		assertEquals(9, game.getPlayerArray().get(0).getPlayedValue());
		//all cards including ivanhoe are now gone from player 1's hand
		assertEquals(0, game.getPlayerArray().get(0).getHand().size());
		
	}

}
