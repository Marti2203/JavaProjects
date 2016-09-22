package client;

import learningjava.client.impl.*;

public class EchoClient
	{
		public static void main(String[] args) throws java.rmi.RemoteException
			{
				EchoService service = new EchoServiceService().getEchoServicePort();
				int i = service.echoInt(42);
				System.out.println(i);
				String s = service.echoString("Hello!");
				System.out.println(s);
				MyObject myObject = new MyObject();
				myObject.setIntValue(42);
				myObject.setStringValue("Foo!");
				MyObject myObj = service.echoMyObject(myObject);
				System.out.println(myObj.getStringValue());
			}
	}
