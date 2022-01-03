package testing;

import static org.junit.Assert.*;

import java.util.ArrayList;

import objects.Card;
import objects.Game;

import org.junit.Test;

public class IvanhoeActionTest2 {

	@Test
	public void test() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("kevin");
		names.add("james");
		Game game = new Game(2, names);
		ArrayList<Card> p1Hand = new ArrayList<Card>();
		ArrayList<Card> p2Hand = new ArrayList<Card>();
		Card p1Card0 = new Card("Red", 4, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card p1Card1 = new Card("Blue", 5, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card p1Card2 = new Card("Action", 0, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card p2Card0 = new Card("Action", 0, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false);
		p1Hand.add(p1Card0);
		p1Hand.add(p1Card1);
		p1Hand.add(p1Card2);
		p2Hand.add(p2Card0);
		
		game.startGame();
		game.getPlayerArray().get(0).setHand(p1Hand);
		game.getPlayerArray().get(1).setHand(p2Hand);
		
		
		game.update(0, "Red");
		
		game.update(0, 0);
		
		game.getPlayerArray().get(0).setNewTournamentColor("Blue");
		game.update(0, 1);
		
		assertEquals("Blue", game.getCurrTournamentColor());
		
		game.update(1, 0);
		
		assertEquals("Red", game.getCurrTournamentColor());
	}

}
