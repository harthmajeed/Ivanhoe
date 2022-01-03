package Iteration2Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import objects.Card;
import objects.Game;

import org.junit.Test;

public class test5blueSeveral {

	@Test
	public void test() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("kevin");
		names.add("ali");
		names.add("harth");
		Game game = new Game(3, names);
		//start game, it is player 1's turn.
		game.startGame();
		assertEquals(true, game.getPlayerArray().get(0).isMyTurn());
		//create supporter cards
		Card card1 = new Card("White", 2, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card card2 = new Card("White", 3, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card card3 = new Card("White", 6, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		//create a new card array to hold the supporters.
		ArrayList<Card> p1Hand = new ArrayList<Card>();
		//add supporters to new array
		p1Hand.add(card1);
		p1Hand.add(card2);
		p1Hand.add(card3);
		//set player 1's hand to only the supporters card
		game.getPlayerArray().get(0).setHand(p1Hand);
		
		//player 1 starts a blue tournament
        game.update(0, "Blue");
		//check to make sure tournament color was set
		assertEquals ("Blue", game.getCurrTournamentColor());
		//player 1's hand has only the supporter cards.
		assertEquals (3, game.getPlayerArray().get(0).getHand().size());
		//player 1 plays supporters.
		game.update(0, 0);
		game.update(0, 0);
		game.update(0, 0);
		//player 1 ends his turn
		game.update(0, true);
		
		
	}

}
