package webObjects;

public class Calculation extends WorkRequest
	{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
