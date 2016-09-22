package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowParameters
 */
@WebServlet("/ShowParameters")
public class ShowParameters extends HttpServlet
	{
		private static final long serialVersionUID = 6L;

		/**
		 * @see HttpServlet#HttpServlet()
		 */
		public ShowParameters()
			{
				super();
				// TODO Auto-generated constructor stub
			}

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request,
		 *      HttpServletResponse response)
		 */
		public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
			{
				showRequestParameters(request, response);
			}

		void showRequestParameters(HttpServletRequest request, HttpServletResponse response) throws IOException
			{
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println("<html><head><title>Show Parameters</title></head><body>" + "<h1>Parameters</h1><ul>");
				Map<String, String[]> params = request.getParameterMap();
				for (String name : params.keySet())
					{
						String[] values = params.get(name);
						out.println("<li>" + name + " = " + Arrays.asList(values));
					}
				out.println("</ul><p><form method=\"POST\" action=\""
						+ request.getRequestURI() + "\">"
						+ "Field 1 <input name=\"Field 1\" size=20><br>"
						+ "Field 2 <input name=\"Field 2\" size=20><br>"
						+ "<br><input type=\"submit\" value=\"Submit\"></form>"
						);
				out.close();
			}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request,
		 *      HttpServletResponse response)
		 */
		public void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException
			{
				showRequestParameters(request, response);
			}

	}
