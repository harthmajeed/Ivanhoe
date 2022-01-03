package testing;

import static org.junit.Assert.*;

import java.util.ArrayList;

import objects.Card;
import objects.Game;

import org.junit.Test;

public class supportersTest {

	@Test
	public void test() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("kevin");
		names.add("james");
		names.add("manton");
		Game game = new Game(3, names);
		ArrayList<Card> supHand = new ArrayList<Card>();
		Card bCard = new Card("Blue", 2, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card sCard = new Card("White", 2, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card mCard = new Card("White", 6, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card mCard2 = new Card("White", 6, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		supHand.add(bCard);
		supHand.add(sCard);
		supHand.add(mCard);
		supHand.add(mCard2);
		
		game.startGame();
		
		game.getPlayerArray().get(0).setHand(supHand);
		
		game.update(0, "Blue");
		
		game.update(0, 1);
		assertEquals(2, game.getPlayerArray().get(0).getPlayedValue());
		game.update(0, 1);
		assertEquals(8, game.getPlayerArray().get(0).getPlayedValue());
		assertEquals(true, game.getPlayerArray().get(0).isMaidenPlayed());
		game.update(0, 1);
		assertEquals(8, game.getPlayerArray().get(0).getPlayedValue());
		assertEquals(true, game.getPlayerArray().get(0).isMaidenPlayed());
		assertEquals(2, game.getPlayerArray().get(0).getHand().size());
		
	}

}
