package webRMI;

import webObjects.*;

import java.rmi.*;
import java.util.*;

public interface ServerRemote extends Remote
	{
		Date getDate() throws RemoteException;

		Object execute(WorkRequest work) throws RemoteException;

		StringIterator getList() throws RemoteException;

		void asyncExecute(WorkRequest request, WorkListener listener) throws RemoteException;
	}