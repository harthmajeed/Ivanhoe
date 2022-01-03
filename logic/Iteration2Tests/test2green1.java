package Iteration2Tests;
import static org.junit.Assert.*;

import java.util.ArrayList;

import objects.Card;
import objects.Game;

import org.junit.Test;

public class test2green1 {

	@Test
	public void test() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("kevin");
		names.add("ali");
		names.add("harth");
		Game game = new Game(3, names);
		
		game.startGame();
		assertEquals(true, game.getPlayerArray().get(0).isMyTurn());
		Card p1card1 = new Card("Green", 1, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card p3card1 = new Card("Green", 1, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		game.getPlayerArray().get(0).getHand().add(p1card1);
		game.getPlayerArray().get(2).getHand().add(p3card1);
        game.update(0, "Green");
		assertEquals ("Green", game.getCurrTournamentColor());
		assertEquals (10, game.getPlayerArray().get(0).getHand().size());
		game.update(0, 9);
		game.update(0, true);
		//player 2 forfeits
		game.update(1, false);
		//player 3 plays green card
		game.update(2, 8);
		
		
	
		
	}

}
