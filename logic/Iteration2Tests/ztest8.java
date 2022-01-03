package Iteration2Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import objects.Card;
import objects.Game;



import org.junit.Test;

public class ztest8 {

	@Test
	public void test() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("kevin");
		names.add("james");
		names.add("manton");
		Game game = new Game(3, names);
		ArrayList<Card> goodHand = new ArrayList<Card>();
		Card bCard = new Card("Blue", 3, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card gCard = new Card("Green", 1, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card yCard = new Card("Yellow", 3, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card rCard = new Card("Red", 3, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card pCard = new Card("Purple", 3, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		
		goodHand.add(bCard);
		goodHand.add(gCard);
		goodHand.add(yCard);
		goodHand.add(rCard);
		goodHand.add(pCard);
		
		game.startGame();
		game.getPlayerArray().get(0).setHand(goodHand);
		
		game.update(0, "Blue");
		game.update(0, 0);
		game.update(0, true);
		game.update(1, false);
		game.update(2, false);
		game.update(0, "Green");
		game.update(0, 0);
		game.update(0, true);
		game.update(1, false);
		game.update(2, false);
		game.update(0, "Yellow");
		game.update(0, 0);
		game.update(0, true);
		game.update(1, false);
		game.update(2, false);
		game.update(0, "Red");
		game.update(0, 0);
		game.update(0, true);
		game.update(1, false);
		game.update(2, false);
		game.update(0, "Purple");
		game.update(0, 0);
		game.update(0, true);
		game.update(1, false);
		game.update(2, false);
		game.getPlayerArray().get(0).setChosenToken("Purple");
		game.afterTokenChoice();
		
		assertEquals(true, game.getPlayerArray().get(0).hasBToken());
		assertEquals(true, game.getPlayerArray().get(0).hasGToken());
		assertEquals(true, game.getPlayerArray().get(0).hasYToken());
		assertEquals(true, game.getPlayerArray().get(0).hasRToken());
		assertEquals(true, game.getPlayerArray().get(0).hasPToken());
		assertEquals(true, game.getPlayerArray().get(0).isGameWinner());
		assertEquals(true, game.isGameOver());
	}

}
