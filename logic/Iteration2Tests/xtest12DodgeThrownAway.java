package Iteration2Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import objects.Card;
import objects.Game;

import org.junit.Test;

public class xtest12DodgeThrownAway {

	@Test
	public void test() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("kevin");
		names.add("james");
		Game game = new Game(2, names);
		ArrayList<Card> p1Hand = new ArrayList<Card>();
		ArrayList<Card> p2Hand = new ArrayList<Card>();
		Card p1Card = new Card("Purple", 4, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card p1Card2 = new Card("Purple", 5, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card p2Card = new Card("Action", 0, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false);
		p1Hand.add(p1Card);
		p1Hand.add(p1Card2);
		p2Hand.add(p2Card);
		
		game.startGame();
		game.getPlayerArray().get(0).setHand(p1Hand);
		game.getPlayerArray().get(1).setHand(p2Hand);
		game.update(0, "Purple");
		
		game.update(0, 0);
		game.update(0, 0);
	
		assertEquals(9, game.getPlayerArray().get(0).getPlayedValue());
		
		game.update(0, true);
		
		game.getPlayerArray().get(1).setTargetPlayer(0);
		game.getPlayerArray().get(1).setChosenCard(0);
		
		
		game.update(1, 0);
		
		assertEquals(5, game.getPlayerArray().get(0).getPlayedValue());
		
		//player 2 only has the card he drew when he started his turn left in his hand
		assertEquals(1, game.getPlayerArray().get(1).getHand().size());
		//player 2 has no cards in his display or face up
		assertEquals(0, game.getPlayerArray().get(1).getDisplay().size());
		assertEquals(0, game.getPlayerArray().get(1).getFaceUpCards().size());
	}

}
