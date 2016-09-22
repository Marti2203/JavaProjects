package filters;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 * Servlet Filter implementation class CensorshipFilter
 */
@WebFilter("/CensorshipFilter")
public class CensorshipFilter implements Filter
	{

		/**
		 * Default constructor.
		 */
		public CensorshipFilter()
			{
				// TODO Auto-generated constructor stub
			}

		FilterConfig filterConfig;

		public void init(FilterConfig filterConfig) throws ServletException
			{
				this.filterConfig = filterConfig;
			}

		public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
				throws IOException, ServletException
			{
				WrappedResponse wrappedResponse = new WrappedResponse((HttpServletResponse) res);
				chain.doFilter(req, wrappedResponse);
				wrappedResponse.close();
			}

		public void destroy()
			{}

		class WrappedResponse extends HttpServletResponseWrapper
			{
				boolean linkText;
				PrintWriter client;

				WrappedResponse(HttpServletResponse res)
					{
						super(res);
					}

				@Override
				public void setContentType(String mime)
					{
						super.setContentType(mime);
						if (mime.startsWith("text/html"))
							linkText = true;
					}

				@Override
				public PrintWriter getWriter() throws IOException
					{
						if (client == null)
							if (linkText)
								client = new LinkWriter(super.getWriter(), new ByteArrayOutputStream());
							else
								client = super.getWriter();
						return client;
					}

				void close()
					{
						if (client != null)
							client.close();
					}
			}

		class LinkWriter extends PrintWriter
			{
				ByteArrayOutputStream buffer;
				Writer client;

				LinkWriter(Writer client, ByteArrayOutputStream buffer)
					{
						super(buffer);
						this.buffer = buffer;
						this.client = client;
					}

				public void close()
					{
						try
							{
								flush();
								client.write(linkText(buffer.toString()));
								client.close();
							}
						catch (IOException e)
							{
								setError();
							}
					}

				String linkText(String text)
					{
						Enumeration<String> en = filterConfig.getInitParameterNames();
						while (en.hasMoreElements())
							{
								String pattern = (String) en.nextElement();
								String value = filterConfig.getInitParameter(pattern);
								text = text.replaceAll(pattern, "<a href=" + value + ">$0</a>");
							}
						return text;
					}
			}
	}
