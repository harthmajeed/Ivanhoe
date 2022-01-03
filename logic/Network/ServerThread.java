package Network;

import java.net.*; 

//import org.apache.log4j.Logger;
import java.util.logging.*;

import objects.Game;

import java.io.*;

//import edu.carleton.scs.chat.utils.Formatter;

public class ServerThread implements Runnable 
{
	static Logger logger = Logger.getLogger(ServerThread.class.getName());

	private int ID = -1;
	private Socket socket = null;
	private Server server = null;

	private ObjectInputStream input = null;//ObjectInputStream
	private ObjectOutputStream output = null;//ObjectOutputStream
	private String clientAddress = null;;
	private boolean done = false;
	private static boolean ready = false;

	private Thread thread = null;
	public ServerThread(Server server, Socket socket) {
		super();
		this.server = server;
		this.socket = socket;
		this.ID = socket.getPort();
		this.clientAddress = socket.getInetAddress().getHostAddress();

		thread = new Thread (this);
		try {
			this.open();
			thread.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void open() 
	{
		try {
			output = new ObjectOutputStream(socket.getOutputStream());
			//System.err.println("-----" + output == null);//this doesn't print!
			System.out.println("You made it!!");//this doesn't print!
			input = new ObjectInputStream(socket.getInputStream());
			//System.err.println("-----" + input == null);//neither does this!
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void run() 
	{
		//if(server.getTesting()) this.send("Testing."); 
		//logger.info(Formatter.format("run()", "Server Thread Running", ID)); 
		while (!done) {
			//System.out.println("started");
			try {
				/** Received a message and pass to the server to handle */
				//server.startGame();//ADDED IN FOR TESTING
				if( server.getClienCount()==server.getNumPlayers() && server.getClienCount() == server.getNameSize() && !ready && !server.getTesting()){
					server.startGame();
					ready = true;
					System.out.println("**********##########%%%%%%%%%%%%%***********");
				}
				Object o = input.readObject();
				//System.out.println("Client Initialized..");

				if (o != null) 
				{
					server.handle(ID, o);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}}
	}

	public int getID() {
		return this.ID;
	}

	public String getSocketAddress () {
		return clientAddress;
	}

	/** The server processes the messages and passes it to the client to send it */
	public void send(Object msg) {
		try {
			if(msg instanceof Game){
				System.out.println("Sending Game object to " + this.ID );			
				System.out.println("Sending Game object to " + ((Game)msg).getNumPlayers() );
				output.writeObject(msg);
				output.flush();
			}
			else if(msg instanceof String){
				output.writeObject(msg);
				output.flush();
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
			//logger.fatal(Formatter.exception("send(String)", ioe));
			//server.remove(ID);
		}
	}
	/** 
	 * server thread that listens for incoming message from the client
	 * on the assigned port 
	 * */
	public void close() {
		try {
			if (socket != null) socket.close();
			if (input != null) input.close();
			if (output != null) output.close();
			this.done = true;
			this.socket = null;
			this.input = null;
			this.output = null;			
		} catch (IOException ioe) { 
			ioe.printStackTrace();
			//logger.fatal(Formatter.exception("close()", ioe));
		}
	}

}
