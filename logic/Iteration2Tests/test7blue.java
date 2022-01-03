package Iteration2Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import objects.Card;
import objects.Game;

import org.junit.Test;

public class test7blue {

	@Test
	public void test() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("kevin");
		names.add("ali");
		Game game = new Game(2, names);
		//start game, it is player 1's turn.
		game.startGame();
		assertEquals(true, game.getPlayerArray().get(0).isMyTurn());
		//create card for p1
		Card p1card1 = new Card("Blue", 3, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		//create card for p2
		Card p2card1 = new Card("Blue", 2, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		//create new card arrays to hold the supporters for p1 and p2.
		ArrayList<Card> p1Hand = new ArrayList<Card>();
		ArrayList<Card> p2Hand = new ArrayList<Card>();
		//add cards to arrays
		p1Hand.add(p1card1);
		p2Hand.add(p2card1);
		//set players hands
		game.getPlayerArray().get(0).setHand(p1Hand);
		game.getPlayerArray().get(1).setHand(p2Hand);
		//player 1 starts a blue tournament
        game.update(0, "Blue");
		//player 1 plays 3.
		game.update(0, 0);
		//player 1 ends his turn
		game.update(0, true);
		//player 2 plays 2.
		game.update(1, 0);
		//player 2 tries to end his turn
		game.update(1, true);
		//it is still player 2's turn, he cannot end his turn not having played more than 3
		assertEquals(true, game.getPlayerArray().get(1).isMyTurn());
	}

}