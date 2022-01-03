package Iteration2Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import objects.Card;
import objects.Game;

import org.junit.Test;

public class zztestRobustDuplicateTokenPurpleTournament {

	@Test
	public void test() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("kevin");
		names.add("james");
		Game game = new Game(2, names);
		ArrayList<Card> sHand = new ArrayList<Card>();
		Card sCard = new Card("Purple", 5, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		sHand.add(sCard);
		
		game.startGame();
		game.getPlayerArray().get(0).setHand(sHand);
		
		game.update(0, "Purple");
		game.update(0, 0);
		game.update(0, true);
		game.update(1, false);
		//player 1 won the purple tournament
		//set player 1 to already having a blue token
		game.getPlayerArray().get(0).setbToken(true);
		//player 1 needs to choose a token
		assertEquals(true, game.getPlayerArray().get(0).isTokenChoiceNeeded());
		//player 1 chooses blue token.
		game.getPlayerArray().get(0).setChosenToken("Blue");
		game.afterTokenChoice();
		//player 1 still needs to choose a token, since ha already has blue
		assertEquals(true, game.getPlayerArray().get(0).isTokenChoiceNeeded());
		//player 1 tries choosing red instead(he does not yet have red token)
		game.getPlayerArray().get(0).setChosenToken("Red");
		game.afterTokenChoice();
		//player 1 no longer needs to pick a token
		assertEquals(false, game.getPlayerArray().get(0).isTokenChoiceNeeded());
		//player one is awarded red token
		assertEquals(true, game.getPlayerArray().get(0).hasRToken());
	}

}
