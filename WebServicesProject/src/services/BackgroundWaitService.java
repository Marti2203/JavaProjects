package services;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class BackgroundWaitService
 *
 */
@WebListener
public class BackgroundWaitService implements ServletContextListener
	{
		ScheduledExecutorService executor;

		public BackgroundWaitService()
			{
				// TODO Auto-generated constructor stub
			}

		/**
		 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
		 */
		public void contextInitialized(ServletContextEvent sce)
			{
				this.executor = Executors.newScheduledThreadPool(3);
				sce.getServletContext().setAttribute("BackgroundWaitExecutor", executor);
			}

		public void contextDestroyed(ServletContextEvent sce)
			{
				ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);
				executor.shutdownNow();
			}
	}
