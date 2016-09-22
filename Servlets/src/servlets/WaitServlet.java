package servlets;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;



@WebServlet(name="waitServlet",urlPatterns = { "/waitServlet" },initParams={@WebInitParam(name="time",value="4")})
public class WaitServlet extends HttpServlet
	{
		/**
		* 
		*/
		private static final long serialVersionUID = 11L;

		public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
			{
				String waitStr = request.getParameter("time");
				if (waitStr == null)
					throw new ServletException("Missing parameter: waitTime");
				int wait = Integer.parseInt(waitStr);
				try
					{
						Thread.sleep(wait * 1000);
					}
				catch (InterruptedException e)
					{
						throw new ServletException(e);
					}
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println("<html><body><h1>WaitServlet Response"+wait+"</h1></body></html>");
				out.close();
			}

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
			{
				doGet(req, resp);
			}

		public WaitServlet()
			{
				// TODO Auto-generated constructor stub
			}
	}