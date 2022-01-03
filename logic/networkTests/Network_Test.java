package networkTests;

import Network.*;  

import static org.junit.Assert.*;
import org.junit.Test;
import utils.Config;

public class Network_Test {

	@Test
	public void test1() {
		Client client = new Client(Config.DEFAULT_HOST, Config.DEFAULT_PORT, true);
		//System.out.println("client.getClient().isConnected()");
		assertEquals(true,client.getSocket().isConnected());
		//fail("Not yet implemented");
	}
	
	@Test
	public void test2() {
		Client client1 = new Client(Config.DEFAULT_HOST, Config.DEFAULT_PORT, true);
		Client client2 = new Client(Config.DEFAULT_HOST, Config.DEFAULT_PORT, true);
		//System.out.println("client.getClient().isConnected()");
		assertEquals(true,client1.getSocket().isConnected());
		assertEquals(true,client2.getSocket().isConnected());
		//fail("Not yet implemented");
	}
	@Test
	public void test3() {// having 5 players connecting
		Client client1 = new Client(Config.DEFAULT_HOST, Config.DEFAULT_PORT, true);
		Client client2 = new Client(Config.DEFAULT_HOST, Config.DEFAULT_PORT, true);
		Client client3 = new Client(Config.DEFAULT_HOST, Config.DEFAULT_PORT, true);
		Client client4 = new Client(Config.DEFAULT_HOST, Config.DEFAULT_PORT, true);
		Client client5 = new Client(Config.DEFAULT_HOST, Config.DEFAULT_PORT, true);
		//System.out.println("client.getClient().isConnected()");
		assertEquals(true,client1.getSocket().isConnected());
		assertEquals(true,client2.getSocket().isConnected());
		assertEquals(true,client3.getSocket().isConnected());
		assertEquals(true,client4.getSocket().isConnected());
		assertEquals(true,client5.getSocket().isConnected());
		
		//fail("Not yet implemented");
	}
	
	@Test
	public void test4(){// test sending/receiving message from server
		Client client1 = new Client(Config.DEFAULT_HOST, Config.DEFAULT_PORT, true);
		String message = "Testing.";
		assertEquals(true,client1.getSocket().isConnected());
		assertEquals(message,client1.StringPassedIn());//
	}

}
