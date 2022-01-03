package Iteration2Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import objects.Card;
import objects.Game;

import org.junit.Test;

public class xtest12ChangeWeaponIvanhoed {

	@Test
	public void test() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("kevin");
		names.add("james");
		Game game = new Game(2, names);
		ArrayList<Card> p1Hand = new ArrayList<Card>();
		Card p1Card1 = new Card("Red", 5, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card p1Card2 = new Card("Action", 0, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card p1Card3 = new Card("Action", 0, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false);
		p1Hand.add(p1Card1);
		p1Hand.add(p1Card2);
		p1Hand.add(p1Card3);
		
		game.startGame();
		game.getPlayerArray().get(0).setHand(p1Hand);
		
		game.update(0, "Red");
		
		assertEquals("Red", game.getCurrTournamentColor());
		
		game.getPlayerArray().get(0).setNewTournamentColor("Blue");
		//play change weapon
		game.update(0, 1);
		
		assertEquals("Blue", game.getCurrTournamentColor());
		
		//play Ivanhoe
		game.update(0, 1);
		// change weapon undone
		assertEquals("Red", game.getCurrTournamentColor());
		
	}

}
