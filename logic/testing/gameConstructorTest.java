package testing;

import static org.junit.Assert.*;

import java.util.ArrayList;

import objects.Game;

import org.junit.Test;

public class gameConstructorTest {

	@Test
	public void test() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("kevin");
		names.add("james");
		Game game = new Game(2, names);
		 
		int numPlayers = 2;
		
		assertEquals (numPlayers, game.getNumPlayers());
		assertEquals (2, game.getPlayerArray().size());
		assertEquals ("kevin", game.getPlayerArray().get(0).getName());
		assertEquals ("james", game.getPlayerArray().get(1).getName());
	}

}
