package web;

import java.io.*;
import java.net.*;

public class URLConnectionTest
	{
		public static void main(String[] args)
			{
				try
					{
						URL url = new URL("http://localhost:1235/src/web/");
						URLConnection connection = url.openConnection();
						connection.getInputStream();
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}
	}
