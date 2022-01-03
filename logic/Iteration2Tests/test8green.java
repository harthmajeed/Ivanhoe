package Iteration2Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import objects.Card;
import objects.Game;

import org.junit.Test;

public class test8green {

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
		Card card2 = new Card("White", 6, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		ArrayList<Card> p1Hand = new ArrayList<Card>();
		p1Hand.add(card1);
		p1Hand.add(card2);
		game.getPlayerArray().get(0).setHand(p1Hand);
        game.update(0, "Green");
        assertEquals(0, game.getPlayerArray().get(0).getPlayedValue());
		assertEquals(2, game.getPlayerArray().get(0).getHand().size());
		//player 1 plays one maiden.
		game.update(0, 0);
		assertEquals(1, game.getPlayerArray().get(0).getPlayedValue());
		assertEquals(1, game.getPlayerArray().get(0).getHand().size());
		//player 1 tries to play another maiden.
		game.update(0, 0);
		//hand size and played value remain the same, maiden not played.
		assertEquals(1, game.getPlayerArray().get(0).getPlayedValue());
		assertEquals(1, game.getPlayerArray().get(0).getHand().size());
	}

}
