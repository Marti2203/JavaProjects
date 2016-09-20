package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet Filter implementation class ConnectionLimitFilter
 */
@WebFilter( urlPatterns="/*", initParams={@WebInitParam(name="limit",value="2")})
public class ConnectionLimitFilter implements Filter
	{

		int limit;
		volatile int count;

		public ConnectionLimitFilter()
			{
				// TODO Auto-generated constructor stub
			}

		/**
		 * @see Filter#destroy()
		 */
		public void destroy()
			{
				// TODO Auto-generated method stub
			}

		/**
		 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
		 */
		public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
				throws IOException, ServletException
			{
				if (count > limit)
					{
						HttpServletResponse httpRes = (HttpServletResponse) response;
						httpRes.sendError(HttpServletResponse.SC_SERVICE_UNAVAILABLE, "Too Busy.");
					}
				else
					{
						++count;
						chain.doFilter(request, response);
						--count;
					}
			}

		/**
		 * @see Filter#init(FilterConfig)
		 */
		public void init(FilterConfig filterConfig) throws ServletException
			{
				String s = filterConfig.getInitParameter("limit");
				if (s == null)
					throw new ServletException("Missing init parameter: " + limit);
				limit = Integer.parseInt(s);
			}

	}
