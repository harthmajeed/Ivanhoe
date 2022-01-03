package Iteration2Tests;


import static org.junit.Assert.*;

import java.util.ArrayList;

import objects.Card;
import objects.Game;

import org.junit.Test;

public class zztestRobustPlayingOutOfTurnIvanhoe {

	@Test
	public void test() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("kevin");
		names.add("james");
		Game game = new Game(2, names);
		ArrayList<Card> p1Hand = new ArrayList<Card>();
		ArrayList<Card> p2Hand = new ArrayList<Card>();
		Card p1Card1 = new Card("Blue", 4, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card p1Card2 = new Card("Action", 0, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card p2Card1 = new Card("Action", 0, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false);
		
		p1Hand.add(p1Card1);
		p1Hand.add(p1Card2);
		p2Hand.add(p2Card1);
		
		game.startGame();
		game.getPlayerArray().get(0).setHand(p1Hand);
		game.getPlayerArray().get(1).setHand(p2Hand);
		
		game.update(0, "Blue");
		
		//player 1 plays drop weapon
		game.update(0, 1);
		assertEquals("Green", game.getCurrTournamentColor());
		
		assertEquals(1, game.getPlayerArray().get(1).getHand().size());
		assertEquals(false, game.getPlayerArray().get(1).isMyTurn());
		//player 2 tries to play ivanhoe out of turn
		game.update(1, 0);
		
		//ivanhoe tooke effect
		assertEquals("Blue", game.getCurrTournamentColor());
		//ivanhoe removed from player 2's hand
		assertEquals(0, game.getPlayerArray().get(1).getHand().size());
		
		
	}

}
