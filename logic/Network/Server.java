/**
 * 
 * @author Howard Scott Needham
 * @Version 1.0
 * 
 * 1: open a server side socket/port and establish a connection 	(Constructor)
 * 2:	start the servers main thread to listen for client request 	(start/run methods)
 * 3:	The run method is a thread that listens for client requests. When a client
 * 	requests a connection it starts a new server thread that is dedicated to the
 * 	client and is then registered in the clients hashmap - addThread () method
 * 4:	The handle method is called from the servers client thread to handle the incoming message
 * 	Notice how we filter the message - this is where you would plug in your rules engine etc .....
 * 
 * 	The server thread listens on the assigned port and when it receives a message it passes it
 * 	back to the server for processing. It is usually best practice to handle this in a seperate
 * 	class that is dedicated to handling/processing messages
 */

package Network;
//package edu.carleton.scs.chat.utils; 
import javax.swing.JOptionPane;

import java.net.*; 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.*;

import objects.Game;
import utils.Config;
import utils.Filter;
import utils.Formatter;

//import org.apache.log4j.Logger;

import java.io.*; 

public class Server implements Runnable {
	static Logger logger = Logger.getLogger(Server.class.getName());

	private int clientCount = 0;
	//private Filter filter;
	private Thread thread = null;
	private ServerSocket server = null;
	private HashMap<Integer, ServerThread> clients;
	private static Scanner userin = new Scanner(System.in);//my code
	//private static Scanner userin2 = new Scanner(System.in);//my code
	private int numPlayers;
	private int numRounds;
	private ArrayList<String> names = new ArrayList<String>();
	private Game game;
	private Boolean gameStarted = Boolean.FALSE;
	private boolean testing;
	public Server(int port,boolean testing) {
		try {
			/** Set up our message filter object */
			//filter = new Filter();
			this.testing = testing;
			System.out.println("Binding to port " + port + ", please wait  ...");
			logger.info("Binding to port " + port);
			/**
			 * I use a HashMap to keep track of the client connections and their
			 * related thread
			 */
			clients = new HashMap<Integer, ServerThread>();

			/** Establish the servers main port that it will listen on */
			server = new ServerSocket(port);
			/**
			 * Allows a ServerSocket to bind to the same address without raising
			 * an "already bind exception"
			 */
			server.setReuseAddress(true);
			start(); //calls the start() method of this class
		} catch (IOException ioe) {
			ioe.printStackTrace();
			//logger.fatal(Formatter.exception("Contructor", ioe));
		}
	}

	/** Now we start the servers main thread */
	public void start() {
		if (thread == null) {
			thread = new Thread(this);
			//creates a new thread object with the appserver class since it implements
			//runnable interface.
			//System.out.println(server.getInetAddress());
			if(!testing){
				do
				{
					System.out.println("Please choose between 2 and 5 players\n");
					//numPlayers = userin.nextInt();//number of players
					String input = JOptionPane.showInputDialog("Please 2 to 5 players.");
					//Harth - added above, and commented  above above
					numPlayers = Integer.parseInt(input);
				}
				while(numPlayers<2 || numPlayers>5);
			}
			//System.out.println("How many rounds would you like to play?\n");
			//numRounds = userin2.nextInt();

			//RulesEngine rules = new RulesEngine(numPlayers,numRounds);//calls the rules engine class!
			//I should be calling the Game object class passing it in the number of players
			//--------------------------------------------------------------------------------------------------

			//rules.addIntoPlayer(name);
			thread.start();		
			//after calling start on the thread, appserver's run method is invoked	
			logger.info(String.format("Server started: %s %d", server,thread.getId()));
		}
	}

	/** The main server thread starts and is listening for clients to connect */
	public void run() 
	{
		while (thread != null) 
		{ //thread was just created, if loop succeeds
			try 
			{
				logger.info("Waiting for a client ...");

				addThread(server.accept()); // calls the addThread method of this class 
				System.out.println("Right Place Line:118 in Server");
			} catch (IOException ioe) {				
				ioe.printStackTrace();
			}}
	}

	/** 
	 * Client connection is accepted and now we need to handle it and register it 
	 * and with the server | HashTable 
	 * @throws IOException 
	 **/
	private void addThread(Socket socket) throws IOException {
//		if(clients.size()>numPlayers){
//			thread = null;
//			ServerThread sv = new ServerThread(this, socket);
//			sv.close();
//		}
		try 
		{
			System.out.println("Adding client " + socket.getPort());

			/** Create a separate server thread for each client */
			ServerThread serverThread = new ServerThread(this, socket);
			if(getTesting())serverThread.send("Testing.");//for junit testcase
			/** Open and start the thread */
			clients.put(serverThread.getID(), serverThread);
			//				if(getTesting()) serverThread.send("Testing.");
			//names.add(serverThread.getID());
			//names.add(Integer.toString(serverThread.getID()));
			this.clientCount++;
			System.out.println("Added client " + serverThread.getID());//
			//logger.info(Formatter.format("Client Accepted: " , socket));
		} catch (Exception ioe) {
			ioe.printStackTrace();
			//logger.fatal(Formatter.exception("addThread(Socket)", ioe));
		}

	}
	public boolean getTesting(){
		return testing;
	}
	public int getClienCount(){
		return clientCount;
	}
	public int getNumPlayers(){
		return numPlayers;
	}

	public void startGame() {
		game = new Game(numPlayers,names);  
		game.startGame();
		for (ServerThread st : clients.values()) {
			//System.out.println ("Sending to " + numPlayers);	
			//System.out.println("Sending Game object..");
			st.send(game);
		}		
	}
	public int getNameSize(){
		return names.size();
	}

	public synchronized void handle(int ID, Object o) {
		if (o instanceof Game) {
			handleGame((Game) o);
		}
		if(o instanceof String) {
			handleString(ID,(String)o);
		}}

	public synchronized void handleGame(Game o){
		game = o;
		for (ServerThread st : clients.values()) {
			st.send(game);
		}
	}

	public synchronized void handleString(int ID,String s){

		if (s.equals("quit!")) 
		{
			//logger.info(Formatter.format("Removing Client:", ID));
			if (clients.containsKey(ID)) {
				clients.get(ID).send("quit!" + "\n");
				remove(ID);
			}}
		else if (s.equals("shutdown!")) { shutdown(); }
		names.add(s);//add the name of the person sent in from client GUI

	}
	/** Try and shutdown the client cleanly */
	public synchronized void remove(int ID) {
		if (clients.containsKey(ID)) {
			ServerThread toTerminate = clients.get(ID);
			clients.remove(ID);
			clientCount--;

			toTerminate.close();
			toTerminate = null;
		}
	}

	/** Shutdown the server cleanly */
	public void shutdown() {
		Set<Integer> keys = clients.keySet();

		if (thread != null) {
			thread = null;
		}

		try {
			for (Integer key : keys) {
				clients.get(key).close();
			}
			clients.clear();
			server.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
			//logger.fatal(Formatter.exception("shutdown()", ioe));
		}
		logger.info(String.format("Server Shutdown cleanly %s", server));
	}

}
