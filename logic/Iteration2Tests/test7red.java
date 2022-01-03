package Iteration2Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import objects.Card;
import objects.Game;

import org.junit.Test;

public class test7red {

	@Test
	public void test() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("kevin");
		names.add("ali");
		Game game = new Game(2, names);
		game.startGame();
		assertEquals(true, game.getPlayerArray().get(0).isMyTurn());
		Card p1card1 = new Card("Red", 4, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card p2card1 = new Card("Red", 3, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
        ArrayList<Card> p1Hand = new ArrayList<Card>();
		ArrayList<Card> p2Hand = new ArrayList<Card>();
		p1Hand.add(p1card1);
		p2Hand.add(p2card1);
		game.getPlayerArray().get(0).setHand(p1Hand);
		game.getPlayerArray().get(1).setHand(p2Hand);
        game.update(0, "Red");
		game.update(0, 0);
		game.update(0, true);
		game.update(1, 0);
		//player 2 tries to end his turn
		game.update(1, true);
		//it is still player 2's turn, he cannot end his turn not having played the highest value
		assertEquals(true, game.getPlayerArray().get(1).isMyTurn());
	}

}
