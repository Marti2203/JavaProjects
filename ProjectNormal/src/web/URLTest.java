package web;

import java.net.*;
import java.io.*;

public class URLTest
	{

		public static void main(String[] args)
			{
				try
					{
						URL url = new URL("http://imgur.com/");
						BufferedReader bin = new BufferedReader(new InputStreamReader(url.openStream()));
						String line;
						while ((line = bin.readLine()) != null)
							{
								System.out.println(line);
							}
						bin.close();
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}

	}
