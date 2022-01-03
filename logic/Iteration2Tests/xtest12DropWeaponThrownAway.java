package Iteration2Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import objects.Card;
import objects.Game;

import org.junit.Test;

public class xtest12DropWeaponThrownAway {

	@Test
	public void test() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("kevin");
		names.add("james");
		Game game = new Game(2, names);
		ArrayList<Card> sHand = new ArrayList<Card>();
		Card sCard = new Card("Yellow", 3, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card sCard2 = new Card("Action", 0, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		sHand.add(sCard);
		sHand.add(sCard2);
		
		game.startGame();
		game.getPlayerArray().get(0).setHand(sHand);
		
		game.update(0, "Yellow");
		
		
		game.update(0, 1);
		
		assertEquals("Green", game.getCurrTournamentColor());
		
		//player 1 only has the yellow card left in his hand
		assertEquals(1, game.getPlayerArray().get(0).getHand().size());
		//player 1 has no cards in display or face up
		assertEquals(0, game.getPlayerArray().get(0).getDisplay().size());
		assertEquals(0, game.getPlayerArray().get(0).getFaceUpCards().size());
	}

}
