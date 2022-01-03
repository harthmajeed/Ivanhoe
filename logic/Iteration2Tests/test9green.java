package Iteration2Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import objects.Card;
import objects.Game;

import org.junit.Test;

public class test9green {

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
		//create green card
		Card card1 = new Card("Green", 1, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		//add green card to player 1's hand to ensure he can start a green tournament
		game.getPlayerArray().get(0).getHand().add(card1);
		
		//player 1 starts a tournament
        game.update(0, "Green");
		//check to make sure tournament color was set
		assertEquals ("Green", game.getCurrTournamentColor());
		//player 1's hand has 8 original cards, the card he drew when his turn started and the added card, total = 10.
		assertEquals (10, game.getPlayerArray().get(0).getHand().size());
		//player 1 has to play card to remain in tournament(play green card).
		game.update(0, 9);
		//player 1 ends his turn
		game.update(0, true);
		//it is now player 2's turn, he draws a card thus his hand contains the 8 original cards plus the drawn card, total = 9.
		assertEquals(true, game.getPlayerArray().get(1).isMyTurn());
		assertEquals (9, game.getPlayerArray().get(1).getHand().size());
		//player 2 forfeits.
		game.update(1, false);
		//it is now player 3's turn, he draws a card thus his hand contains the 8 original cards plus the drawn card, total = 9.
		assertEquals(true, game.getPlayerArray().get(2).isMyTurn());
		assertEquals (9, game.getPlayerArray().get(2).getHand().size());
		//player 3 forfeits.
		game.update(2, false);
		
		//Player 1 won the tournament, he is awarded green token.
		assertEquals(true, game.getPlayerArray().get(0).hasGToken());
		
		
		
	}

}
