package testing;

import static org.junit.Assert.*;

import java.util.ArrayList;

import objects.Card;
import objects.Game;


import org.junit.Test;

public class unableToStartTournamentTest {

	@Test
	public void test() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("kevin");
		names.add("james");
		Card pCard = new Card("Purple", 3, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		ArrayList<Card> badHand = new ArrayList<Card>();
	    badHand.add(pCard);
		Game game = new Game(2, names);
		
		game.startGame();
		
		game.setLastTournamentColor("Purple");
		game.getPlayerArray().get(0).setHand(badHand);
		assertEquals(true, game.getPlayerArray().get(0).isMyTurn());
		assertEquals(true, game.getPlayerArray().get(0).isTournamentColorNeeded());
		game.update(0, "Purple");
		assertEquals(true, game.getPlayerArray().get(0).isMyTurn());
		assertEquals(true, game.getPlayerArray().get(0).isTournamentColorNeeded());
		game.update(0, "Blue");
		assertEquals(true, game.getPlayerArray().get(0).isMyTurn());
		assertEquals(true, game.getPlayerArray().get(0).isTournamentColorNeeded());
		game.update(0, "Yellow");
		assertEquals(true, game.getPlayerArray().get(0).isMyTurn());
		assertEquals(true, game.getPlayerArray().get(0).isTournamentColorNeeded());
		game.update(0, "Green");
		assertEquals(true, game.getPlayerArray().get(0).isMyTurn());
		assertEquals(true, game.getPlayerArray().get(0).isTournamentColorNeeded());
		game.update(0, "Red");
		assertEquals(true, game.getPlayerArray().get(0).isMyTurn());
		assertEquals(true, game.getPlayerArray().get(0).isTournamentColorNeeded());
		game.update(0, "");
		assertEquals(false, game.getPlayerArray().get(0).isMyTurn());
		assertEquals(false, game.getPlayerArray().get(0).isTournamentColorNeeded());
		assertEquals(true, game.getPlayerArray().get(1).isMyTurn());
		assertEquals(true, game.getPlayerArray().get(1).isTournamentColorNeeded());
		
		
		
	}

}
