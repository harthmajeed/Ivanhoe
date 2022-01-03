package Iteration2Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import objects.Card;
import objects.Game;

import org.junit.Test;

public class test5redSeveral {

	@Test
	public void test() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("kevin");
		names.add("ali");
		names.add("harth");
		Game game = new Game(3, names);
		game.startGame();
		assertEquals(true, game.getPlayerArray().get(0).isMyTurn());
		Card card1 = new Card("White", 2, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card card2 = new Card("White", 3, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card card3 = new Card("White", 6, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		ArrayList<Card> p1Hand = new ArrayList<Card>();
		p1Hand.add(card1);
		p1Hand.add(card2);
		p1Hand.add(card3);
		game.getPlayerArray().get(0).setHand(p1Hand);
        game.update(0, "Red");
		assertEquals ("Red", game.getCurrTournamentColor());
		assertEquals (3, game.getPlayerArray().get(0).getHand().size());
		game.update(0, 0);
		game.update(0, 0);
		game.update(0, 0);
		game.update(0, true);
		
		
	}

}
