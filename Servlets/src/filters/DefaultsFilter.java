package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * Servlet Filter implementation class DefaultsFilter
 */
@WebFilter(urlPatterns="/*")
public class DefaultsFilter implements Filter
	{

		/**
		 * Default constructor.
		 */
		public DefaultsFilter()
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
		FilterConfig filterConfig;

		public void init(FilterConfig filterConfig) throws ServletException
			{
				this.filterConfig = filterConfig;
			}

		public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
				throws IOException, ServletException
			{
				WrappedRequest wrappedRequest = new WrappedRequest((HttpServletRequest) req);
				chain.doFilter(wrappedRequest, res);
			}

		class WrappedRequest extends HttpServletRequestWrapper
			{
				WrappedRequest(HttpServletRequest req)
					{
						super(req);
					}

				public String getParameter(String name)
					{
						String value = super.getParameter(name);
						if (value == null)
							value = filterConfig.getInitParameter(name);
						return value;
					}
			}

	}
