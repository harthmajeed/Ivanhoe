package Network;

import utils.Config;

public final class StartClient {

	public static void main (String[] argv) {
		new Client(Config.DEFAULT_HOST, Config.DEFAULT_PORT,false); 
	}
	
}
