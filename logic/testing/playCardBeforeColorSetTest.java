package testing;

import static org.junit.Assert.*;

import java.util.ArrayList;

import objects.Game;

import org.junit.Test;

public class playCardBeforeColorSetTest {

	@Test
	public void test() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("kevin");
		names.add("james");
		names.add("manton");
		Game game = new Game(3, names);
		
		game.startGame();
		
		game.update(0, 0);
		
		assertEquals (9, game.getPlayerArray().get(0).getHand().size());
		assertEquals (true, game.getPlayerArray().get(0).isMyTurn());
	}

}
