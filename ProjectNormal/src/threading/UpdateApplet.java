package threading;

import java.applet.Applet;

public class UpdateApplet extends Applet implements Runnable
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		Thread thread;

		boolean running;

		int updateInterval;

		public UpdateApplet()
			{
				this(1000);
			}

		public UpdateApplet(int updateInterval)
			{
				this.updateInterval = updateInterval;
			}

		public void run()
			{
				while (running)
					{
						repaint();
						try
							{
								Thread.sleep(updateInterval);
							}
						catch (InterruptedException e)
							{
								System.out.println("interrupted...");
								return;
							}
					}
			}

		public void start()
			{
				System.out.println("starting...");
				if (!running) // naive approach
					{
						running = true;
						thread = new Thread(this);
						thread.start();
					}
			}

		public void stop()
			{
				System.out.println("stopping...");
				thread.interrupt();
				running = false;
			}
	}