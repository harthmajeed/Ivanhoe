package testing;

import static org.junit.Assert.*;
import objects.Card;
import objects.Deck;

import org.junit.Test;

public class deckDrawMethodTest {

	@Test
	public void test() {
		Deck deck = new Deck();
		
		assertEquals (110, deck.getCards().size());
		
		Card card = deck.draw();
		
		assertEquals ("Purple", card.getColor());
		assertEquals (3, card.getValue());
		assertEquals (109, deck.getCards().size());
	}

}
