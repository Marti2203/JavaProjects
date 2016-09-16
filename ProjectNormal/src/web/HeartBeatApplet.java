package web;

import java.net.*;
import java.io.*;

@SuppressWarnings("serial")
public class HeartBeatApplet extends java.applet.Applet
	{
		String myHost;
		int myPort;

		public void init()
			{
				myHost = getCodeBase().getHost();
				myPort = Integer.parseInt(getParameter("myPort"));
			}

		private void sendMessage(String message)
			{
				try
					{
						byte[] data = message.getBytes("UTF-8");
						InetAddress addr = InetAddress.getByName(myHost);
						DatagramPacket packet = new DatagramPacket(data, data.length, addr, myPort);
						DatagramSocket ds = new DatagramSocket();
						ds.send(packet);
						ds.close();
					}
				catch (IOException e)
					{
						System.out.println(e); // Error creating socket
					}
			}

		public void start()
			{
				sendMessage("Arrived");
			}

		public void stop()
			{
				sendMessage("Departed");
			}
	}