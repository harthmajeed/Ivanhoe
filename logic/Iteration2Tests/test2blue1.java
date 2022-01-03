package Iteration2Tests;
import static org.junit.Assert.*;

import java.util.ArrayList;

import objects.Card;
import objects.Game;

import org.junit.Test;

public class test2blue1 {

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
		//create blue card for player 1
		Card p1card1 = new Card("Blue", 2, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		//create blue card for player 2
		Card p2card1 = new Card("Blue", 3, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		//add blue card to player 1's hand to ensure he can start a blue tournament
		game.getPlayerArray().get(0).getHand().add(p1card1);
		//add blue card to player 2's hand
		game.getPlayerArray().get(1).getHand().add(p2card1);
		//player 1 starts a tournament
        game.update(0, "Blue");
		//check to make sure tournament color was set
		assertEquals ("Blue", game.getCurrTournamentColor());
		//player 1's hand has 8 original cards, the card he drew when his turn started and the added card, total = 10.
		assertEquals (10, game.getPlayerArray().get(0).getHand().size());
		//player 1 has to play card to remain in tournament(play blue card).
		game.update(0, 9);
		//player 1 ends his turn
		game.update(0, true);
		//it is now player 2's turn, he draws a card thus his hand contains the 8 original cards plus the drawn card plus the added card total = 10.
		assertEquals(true, game.getPlayerArray().get(1).isMyTurn());
		assertEquals (10, game.getPlayerArray().get(1).getHand().size());
		//player 2 plays one card(blue card).
		game.update(1, 8);
		//player 2 ends turn.
		game.update(1, true);
		//it is now player 3's turn, he draws a card thus his hand contains the 8 original cards plus the drawn card, total = 9.
		assertEquals(true, game.getPlayerArray().get(2).isMyTurn());
		assertEquals (9, game.getPlayerArray().get(2).getHand().size());
		//player 3 forfeits.
		game.update(2, false);
        //game continues with player, 1's turn again
		assertEquals(true, game.getPlayerArray().get(0).isMyTurn());
	}

}
