package services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieCutter
 */
@WebServlet("/CookieCutter")
public class CookieCutter extends HttpServlet
	{
		private static final long serialVersionUID = 3L;

		/**
		 * @see HttpServlet#HttpServlet()
		 */
		public CookieCutter()
			{
				super();
				// TODO Auto-generated constructor stub
			}

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request,
		 *      HttpServletResponse response)
		 */
		public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
			{
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println("<html><body>");
				if (request.getParameter("setcookie") != null)
					{
						Cookie cookie = new Cookie("Learningjava", "Cookies!");
						cookie.setMaxAge(60);
						response.addCookie(cookie);
						out.println("<h1>Cookie Set...</h1>");
					}
				else
					{
						Cookie[] cookies = request.getCookies();
						if (cookies.length == 0)
							{
								out.println("<h1>No cookies found...</h1>");
							}
						else
							{
								for (int i = 0; i < cookies.length; i++)
									out.print("<h1>Name: " + cookies[i].getName() + "<br>" + "Value: "
											+ cookies[i].getValue() + "</h1>");
							}
						out.println("<p><a href=\"" + request.getRequestURI() + "?setcookie=true\">"
								+ "Reset the Learning Java cookie.</a>");
					}
				out.println("</body></html>");
				out.close();
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
