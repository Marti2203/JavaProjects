package webRMI;

import java.rmi.*;

public class MyStringIterator extends java.rmi.server.UnicastRemoteObject implements StringIterator
	{
		/**
		* 
		*/
		private static final long serialVersionUID = 5L;
		String[] list;
		int index = 0;

		public MyStringIterator(String[] strings) throws RemoteException
			{
				this.list = strings;
			}

		public boolean hasNext() throws RemoteException
			{
				return index < list.length;
			}

		public String next() throws RemoteException
			{
				return list[index++];
			}
	}
