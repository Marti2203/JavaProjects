package threading;

public class Yield
	{

		public static void main(String[] args)
			{
				new ShowThreadYielding("Foo").start();
				new ShowThreadYielding("Bar").start();
			}

	}
