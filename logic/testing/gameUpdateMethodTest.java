package testing;

import static org.junit.Assert.*;

import java.util.ArrayList;

import objects.Card;
import objects.Game;



import org.junit.Test;

public class gameUpdateMethodTest {

	@Test
	public void test() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("kevin");
		names.add("james");
		names.add("manton");
		Game game = new Game(3, names);
		ArrayList<Card> bHand = new ArrayList<Card>();
		Card bCard = new Card("Blue", 2, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card bCard2 = new Card("Blue", 2, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		bHand.add(bCard);
		bHand.add(bCard2);
		
		game.startGame();
		
		game.getPlayerArray().get(0).setHand(bHand);
		
		game.update(0, "Blue");
		
		assertEquals ("Blue", game.getCurrTournamentColor());
		
		game.update(0, 0);
				
		game.update(0, true);
		
		assertEquals (false, game.getPlayerArray().get(0).isMyTurn());
		assertEquals (true, game.getPlayerArray().get(1).isMyTurn());
		
		game.update(1, false);
		
		assertEquals (2, game.getNumPlayersInTournament());
	}

}
