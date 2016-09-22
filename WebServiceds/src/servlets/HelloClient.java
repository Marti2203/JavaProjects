package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloClient
 */
@WebServlet(urlPatterns = {"/helloClient", "/hello","/HELLO"} )
public class HelloClient extends HttpServlet
	{
		private static final long serialVersionUID = 1L;

		/**
		 * @see HttpServlet#HttpServlet()
		 */
		public HelloClient()
			{
				super();
				// TODO Auto-generated constructor stub
			}

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request,
		 *      HttpServletResponse response)
		 */
		public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
			{
				response.setContentType("text/html"); // must come first
				PrintWriter out = response.getWriter();
				out.println("<html><head><title>Hello Client!</title></head><body>" + "<h1>Hello Client!</h1>"
						+ "</body></html>");
			}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request,
		 *      HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException
			{
				// TODO Auto-generated method stub
				doGet(request, response);
			}

	}
