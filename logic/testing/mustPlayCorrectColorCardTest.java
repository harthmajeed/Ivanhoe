package testing;

import static org.junit.Assert.*;

import java.util.ArrayList;

import objects.Card;
import objects.Game;

import org.junit.Test;

public class mustPlayCorrectColorCardTest {

	@Test
	public void test() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("kevin");
		names.add("james");
		Game game = new Game(2, names);
		ArrayList<Card> sHand = new ArrayList<Card>();
		Card sCard = new Card("Blue", 2, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card sCard2 = new Card("Green", 1, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card sCard3 = new Card("White", 6, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		sHand.add(sCard);
		sHand.add(sCard2);
		sHand.add(sCard3);
		
		game.startGame();
		game.getPlayerArray().get(0).setHand(sHand);
		
		game.update(0, "Blue");
		
		game.update(0, 1);
		assertEquals(0, game.getPlayerArray().get(0).getPlayedValue());
		assertEquals(3, game.getPlayerArray().get(0).getHand().size());
		game.update(0, 0);
		assertEquals(2, game.getPlayerArray().get(0).getPlayedValue());
		assertEquals(2, game.getPlayerArray().get(0).getHand().size());
		game.update(0, 1);
		assertEquals(8, game.getPlayerArray().get(0).getPlayedValue());
		assertEquals(1, game.getPlayerArray().get(0).getHand().size());
	}

}
