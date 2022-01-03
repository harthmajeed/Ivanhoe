package testing;

import static org.junit.Assert.*;

import java.util.ArrayList;

import objects.Game;


import org.junit.Test;

public class playerConstructorTest {

	@Test
	public void test() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("kevin");
		names.add("james");
		Game game = new Game(2, names);
		
		String name = "kevin"; 
		int handSize = 0;
		int playedValue = 0;
		boolean myTurn = false;
		boolean tournamentWinner = false;
		boolean gameWinner = false;
		boolean pToken = false;
		boolean rToken = false;
		boolean bToken = false;
		boolean yToken = false; 
		boolean gToken = false;
		
		assertEquals (name, game.getPlayerArray().get(0).getName());
		assertEquals (handSize, game.getPlayerArray().get(0).getHand().size());
		assertEquals (playedValue, game.getPlayerArray().get(0).getPlayedValue());
		assertEquals (myTurn, game.getPlayerArray().get(0).isMyTurn());
		assertEquals (tournamentWinner, game.getPlayerArray().get(0).isTournamentWinner());
		assertEquals (gameWinner, game.getPlayerArray().get(0).isGameWinner());
		assertEquals (pToken, game.getPlayerArray().get(0).hasPToken());
		assertEquals (rToken, game.getPlayerArray().get(0).hasRToken());
		assertEquals (bToken, game.getPlayerArray().get(0).hasBToken());
		assertEquals (yToken, game.getPlayerArray().get(0).hasYToken());
		assertEquals (gToken, game.getPlayerArray().get(0).hasGToken());
	}

}
