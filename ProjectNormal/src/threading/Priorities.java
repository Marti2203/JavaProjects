package threading;

class Priorities
	{
		public static void main(String[] args)
			{
				Thread foo = new ShowThread("Foo");
				foo.setPriority(Thread.MIN_PRIORITY);
				Thread bar = new ShowThread("Bar");
				bar.setPriority(Thread.MAX_PRIORITY);
				bar.start();
			}
	}
