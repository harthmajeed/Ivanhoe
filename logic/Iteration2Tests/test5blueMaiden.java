package Iteration2Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import objects.Card;
import objects.Game;

import org.junit.Test;

public class test5blueMaiden {

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
		//create maiden card
		Card card1 = new Card("White", 6, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		//create a new card array to hold the maiden.
		ArrayList<Card> p1Hand = new ArrayList<Card>();
		//add maiden to new array
		p1Hand.add(card1);
		//set player 1's hand to only the one supporter card
		game.getPlayerArray().get(0).setHand(p1Hand);
		
		//player 1 starts a blue tournament
        game.update(0, "Blue");
		//check to make sure tournament color was set
		assertEquals ("Blue", game.getCurrTournamentColor());
		//player 1's hand has only the supporter card.
		assertEquals (1, game.getPlayerArray().get(0).getHand().size());
		//player 1 has to play card to remain in tournament(play maiden card).
		game.update(0, 0);
		//player 1 ends his turn
		game.update(0, true);
		
		
	}

}
