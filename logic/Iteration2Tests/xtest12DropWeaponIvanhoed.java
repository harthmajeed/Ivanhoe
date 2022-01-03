package Iteration2Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import objects.Card;
import objects.Game;

import org.junit.Test;

public class xtest12DropWeaponIvanhoed {

	@Test
	public void test() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("kevin");
		names.add("james");
		Game game = new Game(2, names);
		ArrayList<Card> sHand = new ArrayList<Card>();
		Card sCard = new Card("Yellow", 3, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card sCard2 = new Card("Action", 0, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card sCard3 = new Card("Action", 0, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false);
		sHand.add(sCard);
		sHand.add(sCard2);
		sHand.add(sCard3);
		
		game.startGame();
		game.getPlayerArray().get(0).setHand(sHand);
		
		game.update(0, "Yellow");
		
		//player 1 plays drop weapon
		game.update(0, 1);
		
		assertEquals("Green", game.getCurrTournamentColor());
		
		//player 1 plays Ivanhoe
		game.update(0, 1);
		//drop weapon undone
		assertEquals("Yellow", game.getCurrTournamentColor());
		
		
	}

}
