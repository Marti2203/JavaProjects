package webRMI;

import java.rmi.*;
import webObjects.*;

public interface WorkListener extends Remote
	{
		public void workCompleted(WorkRequest request, Object result) throws RemoteException;
	}
