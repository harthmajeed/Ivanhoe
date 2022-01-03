package Iteration2Tests;
import static org.junit.Assert.*;

import java.util.ArrayList;

import objects.Card;
import objects.Game;

import org.junit.Test;

public class test2red1 {

	@Test
	public void test() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("kevin");
		names.add("ali");
		names.add("harth");
		Game game = new Game(3, names);
		game.startGame();
		assertEquals(true, game.getPlayerArray().get(0).isMyTurn());
		Card p1card1 = new Card("Red", 3, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card p2card1 = new Card("Red", 4, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		game.getPlayerArray().get(0).getHand().add(p1card1);
		game.getPlayerArray().get(1).getHand().add(p2card1);
        game.update(0, "Red");
		assertEquals ("Red", game.getCurrTournamentColor());
		assertEquals (10, game.getPlayerArray().get(0).getHand().size());
		game.update(0, 9);
		game.update(0, true);
		assertEquals(true, game.getPlayerArray().get(1).isMyTurn());
		assertEquals (10, game.getPlayerArray().get(1).getHand().size());
		game.update(1, 8);
		game.update(1, true);
		assertEquals(true, game.getPlayerArray().get(2).isMyTurn());
		assertEquals (9, game.getPlayerArray().get(2).getHand().size());
		game.update(2, false);
		assertEquals(true, game.getPlayerArray().get(0).isMyTurn());
	}

}
