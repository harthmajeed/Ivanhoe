package testing;

import static org.junit.Assert.*;

import java.util.ArrayList;

import objects.Card;
import objects.Game;

import org.junit.Test;

public class CounterChargeActionTest {

	@Test
	public void test() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("kevin");
		names.add("james");
		names.add("harth");
		Game game = new Game(3, names);
		ArrayList<Card> p1Hand = new ArrayList<Card>();
		ArrayList<Card> p2Hand = new ArrayList<Card>();
		ArrayList<Card> p3Hand = new ArrayList<Card>();
		Card p1Card1 = new Card("Blue", 4, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card p1Card2 = new Card("Blue", 4, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card p1Card3 = new Card("Blue", 5, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card p2Card1 = new Card("Blue", 4, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card p2Card2 = new Card("Blue", 5, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card p2Card3 = new Card("Blue", 5, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card p3Card1 = new Card("Action", 0, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false);
		Card p3Card2 = new Card("Blue", 4, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		p1Hand.add(p1Card1);
		p1Hand.add(p1Card2);
		p1Hand.add(p1Card3);
		p2Hand.add(p2Card1);
		p2Hand.add(p2Card2);
		p2Hand.add(p2Card3);
		p3Hand.add(p3Card1);
		p3Hand.add(p3Card2);
		
		game.startGame();
		game.getPlayerArray().get(0).setHand(p1Hand);
		game.getPlayerArray().get(1).setHand(p2Hand);
		game.getPlayerArray().get(2).setHand(p3Hand);
		
		game.update(0, "Blue");
		
		game.update(0, 0);
		game.update(0, 0);
		game.update(0, 0);
		game.update(0, true);
		
		game.update(1, 0);
		game.update(1, 0);
		game.update(1, 0);
		game.update(1, true);
		
		assertEquals(13, game.getPlayerArray().get(0).getPlayedValue());
		assertEquals(14, game.getPlayerArray().get(1).getPlayedValue());
		assertEquals(3, game.getPlayerArray().get(0).getDisplay().size());
		assertEquals(3, game.getPlayerArray().get(1).getDisplay().size());
	
		game.update(2, 0);
		
		assertEquals(8, game.getPlayerArray().get(0).getPlayedValue());
		assertEquals(4, game.getPlayerArray().get(1).getPlayedValue());
		assertEquals(2, game.getPlayerArray().get(0).getDisplay().size());
		assertEquals(1, game.getPlayerArray().get(1).getDisplay().size());
	}

}
