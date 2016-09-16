package webRMI;

import webObjects.*;
import java.rmi.*;
import java.util.*;

public class MyServer extends java.rmi.server.UnicastRemoteObject implements ServerRemote
	{
		/**
		* 
		*/
		private static final long serialVersionUID = 4L;

		public MyServer() throws RemoteException
			{}

		public Date getDate() throws RemoteException
			{
				return new Date();
			}

		public Object execute(WorkRequest work) throws RemoteException
			{
				return work.execute();
			}

		public static void main(String args[])
			{
				try
					{
						System.setProperty("java.rmi.server.hostname", "192.168.43.224");
						ServerRemote server = new MyServer();
						Naming.rebind("ErmiServer", server);
					}
				catch (java.io.IOException e)
					{
						e.printStackTrace();
						// problem registering server
					}
			}

		public StringIterator getList() throws RemoteException
			{
				return new MyStringIterator(new String[] { "Foo", "Bar", "Gee" });
			}

		public void asyncExecute(final WorkRequest work, final WorkListener listener) throws RemoteException
			{
				new Thread()
					{
						public void run()
							{
								Object result = work.execute();
								try
									{
										listener.workCompleted(work, result);
									}
								catch (RemoteException e)
									{
										System.out.println(e); // error calling
																// client
									}
							}
					}.start();
			}
	}
