package webRMI;

import java.rmi.*;
import webObjects.*;

public class MyClientAsync extends java.rmi.server.UnicastRemoteObject implements WorkListener
	{
		/**
		* 
		*/
		private static final long serialVersionUID = 6L;

		public MyClientAsync(String host) throws RemoteException
			{
				try
					{
						ServerRemote server = (ServerRemote) Naming.lookup("rmi://" + host + "/ErmiServer");

						for (StringIterator iterator = server.getList(); iterator.hasNext();)
							{
								System.out.println(iterator.next());
							}

						server.asyncExecute(new Calculation(100), this);
						System.out.println("call done...");

					}
				catch (java.io.IOException e)
					{
						e.printStackTrace();
						// I/O Error or bad URL
					}
				catch (NotBoundException e)
					{
						e.printStackTrace();
						// NiftyServer isn't registered
					}
			}

		public void workCompleted(WorkRequest request, Object result) throws RemoteException
			{
				System.out.println("Async result: " + result);
			}

		public static void main(String[] args) throws RemoteException
			{
				new MyClientAsync(args[0]);
			}
	}