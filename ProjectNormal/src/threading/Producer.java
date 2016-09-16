package threading;

import java.util.*;

public class Producer implements Runnable
	{
		static final int MAXQUEUE = 5;

		int sleepInterval;
		private List<String> messages = new ArrayList<String>();

		public Producer()
			{
				this(1000);
			}

		public Producer(int sleepInterval)
			{
				this.sleepInterval = sleepInterval;
			}

		public void run()
			{
				while (true)
					{
						putMessage();
						try
							{
								Thread.sleep(sleepInterval);
							}
						catch (InterruptedException e)
							{}
					}
			}

		private synchronized void putMessage()
			{
				while (messages.size() >= MAXQUEUE)
					try
						{
							wait();
						}
					catch (InterruptedException e)
						{}

				messages.add(new java.util.Date().toString());
				notify();
			}

		// called by Consumer
		public synchronized String getMessage()
			{
				while (messages.size() == 0)
					try
						{
							notify();
							wait();
						}
					catch (InterruptedException e)
						{}
				String message = messages.remove(0);
				notify();
				return message;
			}
	}