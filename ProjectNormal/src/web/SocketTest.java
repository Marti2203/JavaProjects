package web;

import java.io.*;
import java.net.*;

public class SocketTest
	{
		public static void main(String[] arg){
			try {
				Socket sock = new Socket("google.com", 25);
				System.out.println(sock.isConnected());
				sock.close();
				} catch ( UnknownHostException e ) {
				System.out.println("Can't find host.");
				} catch ( IOException e ) {
				System.out.println("Error connecting to host.");
				}
		}
	}
