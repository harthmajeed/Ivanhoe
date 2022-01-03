package testing;

import static org.junit.Assert.*;

import java.util.ArrayList;

import objects.Game;


import org.junit.Test;

public class playerDrawMethodTest {

	@Test
	public void test() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("kevin");
		names.add("james");
		Game game = new Game(2, names);
		game.getPlayerArray().get(0).draw();
		assertEquals (1, game.getPlayerArray().get(0).getHand().size());
	}

}
