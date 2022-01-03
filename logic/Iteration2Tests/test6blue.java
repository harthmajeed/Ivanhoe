package Iteration2Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import objects.Card;
import objects.Game;

import org.junit.Test;

public class test6blue {

	@Test
	public void test() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("kevin");
		names.add("ali");
		Game game = new Game(2, names);
		//start game, it is player 1's turn.
		game.startGame();
		assertEquals(true, game.getPlayerArray().get(0).isMyTurn());
		//create supporter cards for p1
		Card p1card1 = new Card("White", 2, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card p1card2 = new Card("White", 2, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card p1card3 = new Card("White", 2, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		//create supporter cards for p2
		Card p2card1 = new Card("White", 3, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card p2card2 = new Card("White", 2, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card p2card3 = new Card("White", 6, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		
		//create new card arrays to hold the supporters for p1 and p2.
		ArrayList<Card> p1Hand = new ArrayList<Card>();
		ArrayList<Card> p2Hand = new ArrayList<Card>();
		//add supporters to arrays
		p1Hand.add(p1card1);
		p1Hand.add(p1card2);
		p1Hand.add(p1card3);
		p2Hand.add(p2card1);
		p2Hand.add(p2card2);
		p2Hand.add(p2card3);
		//set players hands
		game.getPlayerArray().get(0).setHand(p1Hand);
		game.getPlayerArray().get(1).setHand(p2Hand);
		//player 1 starts a blue tournament
        game.update(0, "Blue");
		//player 1 plays 1 supporter.
		game.update(0, 0);
		//player 1 ends his turn
		game.update(0, true);
		//player 2 plays 1 supporter.
		game.update(1, 0);
		//player 2 ends his turn
		game.update(1, true);
		//player 1 plays several supporters.
		game.update(0, 0);
		game.update(0, 0);
		//player 1 ends his turn
		game.update(0, true);
		//player 2 plays several supporters.
		game.update(1, 0);
		game.update(1, 0);
		//player 2 ends his turn
		game.update(0, true);
		assertEquals(6, game.getPlayerArray().get(0).getPlayedValue());
		assertEquals(11, game.getPlayerArray().get(1).getPlayedValue());
		
	}

}
