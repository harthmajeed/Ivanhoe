package Iteration2Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import objects.Card;
import objects.Game;

import org.junit.Test;

public class xtest11yellow{

	@Test
	public void test() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("kevin");
		names.add("james");
		Game game = new Game(2, names);
		ArrayList<Card> supHand = new ArrayList<Card>();
		Card bCard = new Card("Yellow", 2, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card mCard = new Card("White", 6, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		supHand.add(bCard);
		supHand.add(mCard);
		ArrayList<Card> bHand = new ArrayList<Card>();
		Card bCard1 = new Card("Yellow", 4, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card bCard2 = new Card("Yellow", 5, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		bHand.add(bCard1);
		bHand.add(bCard2);
		
		game.startGame();
		game.getPlayerArray().get(0).setbToken(true);
		game.getPlayerArray().get(0).setHand(supHand);
		game.getPlayerArray().get(1).setHand(bHand);
		
		game.update(0, "Yellow");
		
		game.update(0, 0);
		game.update(0, 0);
		game.update(0, true);
		game.update(1, 0);
		game.update(1, 0);
		game.update(1, true);
		game.update(0, false);
		assertEquals(false, game.getPlayerArray().get(0).hasBToken());
		
		
		
	}

}

