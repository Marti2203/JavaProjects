package services;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ContextInfo
 */
@WebServlet("/ContextInfo")
public class ContextInfo extends HttpServlet
	{
		private static final long serialVersionUID = 2L;

		/**
		 * @see HttpServlet#HttpServlet()
		 */
		public ContextInfo()
			{
				super();
				// TODO Auto-generated constructor stub
			}

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request,
		 *      HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException
			{
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println("<html><body>");
				ServletContext context = getServletContext();
				for (Method method : ServletContext.class.getMethods())
					{
						if (!method.getName().startsWith("get") || method.getParameterCount() != 0)
							continue;
						try
							{
								out.println(method.getName() + " " + method.invoke(context, new Object[]{}) + "<br>");
							}
						catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e)
							{
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					}
				out.println("</body></html>");
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
