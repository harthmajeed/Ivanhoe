package Network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Logger;

public class ClientThread extends Thread {
	private Socket         socket   = null;
	private Client      client   = null;
	private ObjectInputStream in = null;
	private Thread thread = null;
	static Logger logger = Logger.getLogger(Server.class.getName());
	//private ObjectOutputStream out = null;
	private boolean done = false;
	
	public ClientThread(Client client, Socket socket) {  
		this.client = client;
		this.socket = socket;
		logger.info("ClientThread created..");
		//thread = new Thread (this);
		open();  
		//thread.run();
		start();
	}
	
	 public void open () {
       
		 System.out.println("Opening Sockets..");

         try {
        	 	System.out.println("Before opening Sockets..");
                 in  = new ObjectInputStream(socket.getInputStream());// code gets to this line and returns at second client
                 System.out.println("Sockets opened..");
         } catch (IOException e) {
                 e.printStackTrace();
         }
 }
	public void run() {
		System.out.println("Client Thread " + socket.getLocalPort() + " running.");
		while (!done) { 
			try {  
				//Thread.sleep(500);
				
				client.handle(in.readObject());
			} catch(Exception ioe) {  
				ioe.printStackTrace();
	    }}
	}
	public void close () {
		done = true;
		try {  
			if (in != null) in.close();
		//	if (out != null) out.close();
			if (socket != null) socket.close();
			this.socket = null;
			//this.out = null;
			this.in = null;
		} catch(IOException ioe) { 
			ioe.printStackTrace();
	   }	
	}

}
