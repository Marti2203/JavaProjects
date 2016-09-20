package servlets;

public enum StringExtender
	{
		;
		public static String CreateName(String name)
			{
				if(Character.isUpperCase(name.charAt(0)))
						return name;
				else
					{
						return name.charAt(0)+name.substring(1);
					}
			} 
	}
