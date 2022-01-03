package utils;

import java.util.logging.Logger;

import Network.ServerThread;

public class Filter {

	static Logger logger = Logger.getLogger(Filter.class.getName());
	
	private String[] filters =  { "dog", "cat", "horse", "rabbit", "goat", "sheep", "llama" };
	
	public Boolean process (ServerThread client, String m) {
		for (String filter : filters) {
			if (m.toLowerCase().contains(filter)) {				
				//logger.warn(String.format("%s:%d : %s" ,client.getSocketAddress(), client.getID(), m));
				//logger.warn(String.format("%s:%d Message had to be filtered: it contained the word %s", client.getSocketAddress(), client.getID(), filter));
				return Boolean.FALSE;
			}}
		logger.info(String.format("%s:%d Message processed successfully: %s", client.getSocketAddress(), client.getID(), m));
		return Boolean.TRUE;
	}
	
}
