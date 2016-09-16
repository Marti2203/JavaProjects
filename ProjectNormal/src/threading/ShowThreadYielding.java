package threading;

public class ShowThreadYielding extends ShowThread
	{

		public ShowThreadYielding(String message)
			{
				super(message);
			}

		@Override
		public void run()
			{
				// TODO Auto-generated method stub
				while (true)
					{
						System.out.println(message + " " + counter++);
						yield();
					}
					
			}

	}