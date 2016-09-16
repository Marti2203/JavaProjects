package threading;

public class NamedConsumer extends Consumer
	{
		String name;

		public NamedConsumer(String name, Producer producer)
			{
				super(producer);
				this.name = name;
			}

		public void run()
			{
				while (true)
					{
						String message = producer.getMessage();
						System.out.println(name + " got message: " + message);
						try
							{
								Thread.sleep(sleepInterval);
							}
						catch (InterruptedException e)
							{}
					}
			}

		public static void main(String[] args)
			{
				Producer producer = new Producer();
				new Thread(producer).start();

				NamedConsumer consumerOne = new NamedConsumer("First", producer);
				new Thread(consumerOne).start();

				NamedConsumer consumerTwo = new NamedConsumer("Second", producer);
				new Thread(consumerTwo).start();
			}
	}
