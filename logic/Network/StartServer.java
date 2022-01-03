package Network;
import javax.swing.JOptionPane;

import java.io.Console; 
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.*;

import javax.swing.JOptionPane;

import Network.Server;
import utils.Config;

@SuppressWarnings("unused")
public class StartServer {
	
	private static Boolean done = Boolean.FALSE;
	private static Boolean started = Boolean.FALSE;

	private static Scanner sc = new Scanner(System.in);
	private static Server appServer = null;
	
	static Logger logger = Logger.getLogger(StartServer.class.getName());
	public static void main(String[] argv) {

		//PropertyConfigurator.configure(Config.ServerConfig);
		System.out.println("Starting server ...");

		do {
			System.out.println("startup | shutdown | Testing");
			//String input = sc.nextLine(); //Harth - commented out, added below
			String input = JOptionPane.showInputDialog("Please enter 'start', if shown second time click cancel.");
			if (input.equalsIgnoreCase("STARTUP") || input.equalsIgnoreCase("START") && !started)
			{
				System.out.println("Starting server ...");
				appServer = new Server(Config.DEFAULT_PORT,false);
				started = Boolean.TRUE;
				logger.info(String.format("Server Started %s:%d", Config.DEFAULT_HOST, Config.DEFAULT_PORT));// what 
				//does the logger do exactly??
			    
			}
			if (input.equalsIgnoreCase("TESTING") || input.equalsIgnoreCase("TEST") && !started)
			{
				System.out.println("Starting server ...");
				appServer = new Server(Config.DEFAULT_PORT,true);
				started = Boolean.TRUE;
				logger.info(String.format("Server Started %s:%d", Config.DEFAULT_HOST, Config.DEFAULT_PORT));// what 
				//does the logger do exactly??
			    
			}
			
			if (input.equalsIgnoreCase("SHUTDOWN") && started)
			{
				System.out.println("Shutting server down ...");
				appServer.shutdown();
				started = Boolean.FALSE;
				done = Boolean.TRUE;
				logger.info(String.format("Server Shutdown %s:%d", Config.DEFAULT_HOST, Config.DEFAULT_PORT));			
			}			
		} while (!done);

		System.out.println("Exiting ...");
		System.exit(1);
	}
}
	