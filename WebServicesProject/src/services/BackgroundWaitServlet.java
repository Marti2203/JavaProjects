package services;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class bgwait
 */
@WebServlet(urlPatterns = { "/bgwait","/bgwaiter" }, asyncSupported = true)
/**
 * @see HttpServlet#HttpServlet()
 */
public class BackgroundWaitServlet extends HttpServlet
	{
		/**
		* 
		*/
		private static final long serialVersionUID = 8L;

		public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
			{
				final AsyncContext asyncContext = request.startAsync();

				ScheduledExecutorService executor = (ScheduledExecutorService) request.getServletContext()
						.getAttribute("BackgroundWaitExecutor");
				executor.schedule(new RespondLaterJob(asyncContext), 5, TimeUnit.SECONDS);
			}

		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException
			{
				// TODO Auto-generated method stub
				doGet(request, response);
			}
	}

class RespondLaterJob implements Runnable
	{
		private AsyncContext asyncContext;

		RespondLaterJob(AsyncContext asyncContext)
			{
				this.asyncContext = asyncContext;
			}

		@Override
		public void run()
			{
				try
					{
						ServletResponse response = asyncContext.getResponse();
						response.setContentType("text/html");
						PrintWriter out = response.getWriter();
						out.println("<html><body><h1>WaitServlet Response</h1></body></html>");
					}
				catch (IOException e)
					{
						throw new RuntimeException(e);
					}
				asyncContext.complete();
			}
	}
