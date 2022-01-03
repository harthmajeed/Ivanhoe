package Iteration2Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import objects.Card;
import objects.Game;

import org.junit.Test;

public class ztest3 {

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
		
		game.update(0, 0);
				
		game.update(0, true);
		
		assertEquals (true, game.getPlayerArray().get(1).isMyTurn());
		
		game.update(1, true);
		
		assertEquals (true, game.getPlayerArray().get(1).isMyTurn());
		
		

	}

}
