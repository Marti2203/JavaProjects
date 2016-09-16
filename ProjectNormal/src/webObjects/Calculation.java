package webObjects;

public class Calculation extends WorkRequest
	{
		int n;

		public Calculation(int n)
			{
				this.n = n;
			}

		@Override
		public Object execute()
			{
				return new Integer(n * n);
			}

	}
