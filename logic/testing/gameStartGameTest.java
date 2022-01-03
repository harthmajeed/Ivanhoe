package testing;

import static org.junit.Assert.*;

import java.util.ArrayList;

import objects.Game;

import org.junit.Test;

public class gameStartGameTest {

	@Test
	public void test() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("kevin");
		names.add("james");
		Game game = new Game(2, names);
		
		game.startGame();
		
		assertEquals (9, game.getPlayerArray().get(0).getHand().size());
		assertEquals (8, game.getPlayerArray().get(1).getHand().size());
		assertEquals (true, game.getPlayerArray().get(0).isMyTurn());
		assertEquals (false, game.getPlayerArray().get(1).isMyTurn());
	}

}
