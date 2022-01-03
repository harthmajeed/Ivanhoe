package Iteration2Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import objects.Card;
import objects.Game;

import org.junit.Test;

public class test6yellow {

	@Test
	public void test() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("kevin");
		names.add("ali");
		Game game = new Game(2, names);
		game.startGame();
		assertEquals(true, game.getPlayerArray().get(0).isMyTurn());
		Card p1card1 = new Card("White", 2, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card p1card2 = new Card("White", 2, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card p1card3 = new Card("White", 2, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card p2card1 = new Card("White", 3, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card p2card2 = new Card("White", 2, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card p2card3 = new Card("White", 6, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		ArrayList<Card> p1Hand = new ArrayList<Card>();
		ArrayList<Card> p2Hand = new ArrayList<Card>();
		p1Hand.add(p1card1);
		p1Hand.add(p1card2);
		p1Hand.add(p1card3);
		p2Hand.add(p2card1);
		p2Hand.add(p2card2);
		p2Hand.add(p2card3);
		game.getPlayerArray().get(0).setHand(p1Hand);
		game.getPlayerArray().get(1).setHand(p2Hand);
        game.update(0, "Yellow");
		game.update(0, 0);
		game.update(0, true);
		game.update(1, 0);
		game.update(1, true);
		game.update(0, 0);
		game.update(0, 0);
		game.update(0, true);
		game.update(1, 0);
		game.update(1, 0);
		game.update(0, true);
		assertEquals(6, game.getPlayerArray().get(0).getPlayedValue());
		assertEquals(11, game.getPlayerArray().get(1).getPlayedValue());
		
	}

}
