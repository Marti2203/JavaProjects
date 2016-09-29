package webservices;

import javax.jws.*;
import javax.xml.ws.Endpoint;

@WebService
public class EchoService
{
	@WebMethod
	public int echoInt(int value)
	{
		return value * 2;
	}

	@WebMethod
	public String echoString(String value)
	{
		return value.toUpperCase();
	}

	@WebMethod
	public MyObject echoMyObject(MyObject value)
	{
		return value;
	}

	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Endpoint endpoint = Endpoint.publish("http://localhost:8080/echo", new EchoService());
	}
}
