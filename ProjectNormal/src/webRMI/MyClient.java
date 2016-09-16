package webRMI;

import webObjects.*;
import java.rmi.*;

public class MyClient
	{
		public static void main(String[] args) throws RemoteException
			{
				new MyClient(args[0]);
			}

		public MyClient(String host)
			{
				try
					{
						ServerRemote server = (ServerRemote) Naming.lookup("rmi://" + host + "/ErmiServer");
						System.out.println(server.getDate());
						System.out.println(server.execute(new Calculation(2)));
					}
				catch (java.io.IOException e)
					{
						System.out.println("IOExepction");
						e.printStackTrace();
						// I/O Error or bad URL
					}
				catch (NotBoundException e)
					{
						System.out.println("NotBoundException");
						// NiftyServer isn't registered
					}
			}
	}