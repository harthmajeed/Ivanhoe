package Iteration2Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import objects.Card;
import objects.Game;

import org.junit.Test;

public class xtest12ChangeWeaponThrownAway {

	@Test
	public void test() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("kevin");
		names.add("james");
		Game game = new Game(2, names);
		ArrayList<Card> sHand = new ArrayList<Card>();
		Card sCard = new Card("Red", 5, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card sCard2 = new Card("Action", 0, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		sHand.add(sCard);
		sHand.add(sCard2);
		
		game.startGame();
		game.getPlayerArray().get(0).setHand(sHand);
		
		game.update(0, "Red");
		
		game.getPlayerArray().get(0).setNewTournamentColor("Blue");
		game.update(0, 1);
		
		assertEquals("Blue", game.getCurrTournamentColor());
		
		// make sure Change weapon was thrown away.
		//only the red card left in player 1's hand 
		assertEquals(1, game.getPlayerArray().get(0).getHand().size());
		// no cards in player 1's display or face up cards
		assertEquals(0, game.getPlayerArray().get(0).getDisplay().size());
		assertEquals(0, game.getPlayerArray().get(0).getFaceUpCards().size());
		
	}

}
