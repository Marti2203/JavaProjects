package threading;

public class ShowThread extends Thread
	{
		String message;
		int counter;

		public ShowThread(String message)
			{
				this.message = message;
				this.counter = 0;
			}

		@Override
		public void run()
			{
				while (true)
					{
						System.out.println(message + " " + counter++);
					}
			}
	}