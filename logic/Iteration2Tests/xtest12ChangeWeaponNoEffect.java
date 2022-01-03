package Iteration2Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import objects.Card;
import objects.Game;

import org.junit.Test;

public class xtest12ChangeWeaponNoEffect {

	@Test
	public void test() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("kevin");
		names.add("james");
		Game game = new Game(2, names);
		ArrayList<Card> sHand = new ArrayList<Card>();
		Card sCard = new Card("Green", 1, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card sCard2 = new Card("Action", 0, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		sHand.add(sCard);
		sHand.add(sCard2);
		
		game.startGame();
		game.getPlayerArray().get(0).setHand(sHand);
		
		game.update(0, "Green");
		
		game.getPlayerArray().get(0).setNewTournamentColor("Blue");
		game.update(0, 1);
		
		//change weapon had no effect.
		assertEquals("Green", game.getCurrTournamentColor());
	}

}
