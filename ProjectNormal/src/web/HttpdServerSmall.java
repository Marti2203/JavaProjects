package web;

import java.net.*;
import java.io.*;
import java.util.regex.*;
import java.util.Date;
import java.util.concurrent.*;

public class HttpdServerSmall
	{
		public static void main(String argv[]) throws IOException
			{
				Executor executor = Executors.newFixedThreadPool(5);
				@SuppressWarnings("resource")
				ServerSocket ss = new ServerSocket(Integer.parseInt(argv[0]));;
				
				while (true)
					executor.execute(new TinyHttpdConnection(ss.accept()));
			}
	}

class TinyHttpdConnection implements Runnable
	{
		Socket client;
		String resource="";
		TinyHttpdConnection(Socket client) throws SocketException
			{
				this.client = client;
			}

		public void run()
			{
				try
					{
						BufferedReader in = new BufferedReader(
								new InputStreamReader(client.getInputStream(), "8859_1"));
						OutputStream out = client.getOutputStream();
						PrintWriter pout = new PrintWriter(new OutputStreamWriter(out, "8859_1"), true);
						String request = in.readLine();
						System.out.println("Request: " + request+" "+new Date());
						Matcher get = Pattern.compile("GET /?(\\S*).*").matcher(request);
						if (get.matches())
							{
								request = get.group(1);
								request=resource+request;
								if (request.endsWith("/") || request.equals(resource))
									request = request + "index.html";
								try
									{
										FileInputStream fis = new FileInputStream(request);
										byte[] data = new byte[64 * 1024];
										for (int read; (read = fis.read(data)) > -1;)
											out.write(data, 0, read);
										out.flush();
										fis.close();
									}
								catch (FileNotFoundException e)
									{
										pout.println("404 Object Not Found");
									}
							}
						else
							pout.println("400 Bad Request");
						client.close();
					}
				catch (IOException e)
					{
						System.out.println("I/O error " + e);
					}
			}
	}
