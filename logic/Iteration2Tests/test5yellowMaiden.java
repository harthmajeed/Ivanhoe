package Iteration2Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import objects.Card;
import objects.Game;

import org.junit.Test;

public class test5yellowMaiden {

	@Test
	public void test() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("kevin");
		names.add("ali");
		names.add("harth");
		Game game = new Game(3, names);
		game.startGame();
		assertEquals(true, game.getPlayerArray().get(0).isMyTurn());
		Card card1 = new Card("White", 6, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		ArrayList<Card> p1Hand = new ArrayList<Card>();
		p1Hand.add(card1);
		game.getPlayerArray().get(0).setHand(p1Hand);
        game.update(0, "Yellow");
		assertEquals ("Yellow", game.getCurrTournamentColor());
		assertEquals (1, game.getPlayerArray().get(0).getHand().size());
		game.update(0, 0);
		game.update(0, true);
		
		
	}

}
