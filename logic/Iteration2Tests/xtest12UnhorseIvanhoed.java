package Iteration2Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import objects.Card;
import objects.Game;

import org.junit.Test;

public class xtest12UnhorseIvanhoed {

	@Test
	public void test() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("kevin");
		names.add("james");
		Game game = new Game(2, names);
		ArrayList<Card> sHand = new ArrayList<Card>();
		Card sCard = new Card("Purple", 5, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card sCard2 = new Card("Action", 0, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card sCard3 = new Card("Action", 0, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false);
		sHand.add(sCard);
		sHand.add(sCard2);
		sHand.add(sCard3);
		
		game.startGame();
		game.getPlayerArray().get(0).setHand(sHand);
		
		game.update(0, "Purple");
		
		game.getPlayerArray().get(0).setNewTournamentColor("Red");
		//player 1 plays unhorse
		game.update(0, 1);
		assertEquals("Red", game.getCurrTournamentColor());
		//player 1 plays ivanhoe
		game.update(0, 1);
		//unhorse undone
		assertEquals("Purple", game.getCurrTournamentColor());
	}

}
