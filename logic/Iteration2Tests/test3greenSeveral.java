package Iteration2Tests;
import static org.junit.Assert.*;

import java.util.ArrayList;

import objects.Card;
import objects.Game;

import org.junit.Test;

public class test3greenSeveral {

	@Test
	public void test() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("kevin");
		names.add("ali");
		names.add("harth");
		names.add("james");
		Game game = new Game(4, names);
		game.startGame();
		assertEquals(true, game.getPlayerArray().get(0).isMyTurn());
		Card p1card1 = new Card("Green", 1, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card p2card1 = new Card("Green", 1, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card p2card2 = new Card("Green", 1, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card p3card1 = new Card("Green", 2, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);		
		Card p3card2 = new Card("Green", 2, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		game.getPlayerArray().get(0).getHand().add(p1card1);
		game.getPlayerArray().get(1).getHand().add(p2card1);
		game.getPlayerArray().get(1).getHand().add(p2card2);
		game.getPlayerArray().get(2).getHand().add(p3card1);
		game.getPlayerArray().get(2).getHand().add(p3card2);
        game.update(0, "Green");
		assertEquals ("Green", game.getCurrTournamentColor());
		assertEquals (10, game.getPlayerArray().get(0).getHand().size());
		game.update(0, 9);
		game.update(0, true);
		assertEquals(true, game.getPlayerArray().get(1).isMyTurn());
		assertEquals (11, game.getPlayerArray().get(1).getHand().size());
		game.update(1, 8);
		game.update(1, 8);
		game.update(1, true);
		assertEquals(true, game.getPlayerArray().get(2).isMyTurn());
		assertEquals (11, game.getPlayerArray().get(2).getHand().size());
		game.update(2, 8);
		game.update(2, 8);
		game.update(2, true);
		game.update(3, false);
		assertEquals(true, game.getPlayerArray().get(0).isMyTurn());
	}
}