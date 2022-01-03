package Iteration2Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import objects.Game;

import org.junit.Test;

public class ztest5 {

	@Test
	public void test() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("kevin");
		names.add("james");
		Game game = new Game(2, names);
		
		game.startGame();
		
		//loop that draws more than 110 cards, cards added to discard pile as they are drawn
		for(int i = 0; i < 150; i++){
			game.getPlayerArray().get(0).draw();
			game.discardPile.getCards().add(game.getPlayerArray().get(0).getHand().get(0));
		}
       assertEquals(false, game.deck.getCards().isEmpty());
	}

}
