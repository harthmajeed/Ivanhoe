package testing;

import static org.junit.Assert.*;

import java.util.ArrayList;

import objects.Card;
import objects.Game;

import org.junit.Test;

public class gTournTest {

	@Test
	public void test() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("kevin");
		names.add("james");
		Game game = new Game(2, names);
		ArrayList<Card> bHand = new ArrayList<Card>();
		Card bCard = new Card("Green", 1, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card bCard2 = new Card("Green", 1, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		bHand.add(bCard);
		bHand.add(bCard2);
		
		game.startGame();
		
		game.getPlayerArray().get(0).setHand(bHand);
		
		game.update(0, "Green");
		
		assertEquals ("Green", game.getCurrTournamentColor());
	}

}
