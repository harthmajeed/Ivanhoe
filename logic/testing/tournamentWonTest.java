package testing;

import static org.junit.Assert.*;

import java.util.ArrayList;

import objects.Card;
import objects.Game;

import org.junit.Test;

public class tournamentWonTest {

	@Test
	public void test() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("kevin");
		names.add("james");
		names.add("manton");
		Game game = new Game(3, names);
		ArrayList<Card> bHand = new ArrayList<Card>();
		Card bCard = new Card("Blue", 2, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		Card bCard2 = new Card("Blue", 2, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		bHand.add(bCard);
		bHand.add(bCard2);
		
		game.startGame();
		
		game.getPlayerArray().get(0).setHand(bHand);
		
		game.update(0, "Blue");
		
		game.update(0, 0);
		
		game.update(0, true);
		assertEquals(3, game.getNumPlayersInTournament());
		game.update(1, false);
		assertEquals(2, game.getNumPlayersInTournament());
		game.update(2, false);
		
		assertEquals(0, game.getLastTournamentWinner());
		assertEquals(true, game.getPlayerArray().get(0).hasBToken());
		assertEquals("Blue", game.getLastTournamentColor());
		assertEquals(null, game.getCurrTournamentColor());
		assertEquals(true, game.getPlayerArray().get(0).isMyTurn());
		assertEquals(0, game.getPlayerArray().get(0).getPlayedValue());
		assertEquals(0, game.getPlayerArray().get(1).getPlayedValue());
		assertEquals(0, game.getPlayerArray().get(2).getPlayedValue());
		
		
	}

}
