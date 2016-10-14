package utils;

public enum CharExtender
{
	;
	public static boolean isLowerCase(String word)
	{
		for(int i=0;i<word.length();i++)
		{
			if(!Character.isLowerCase(word.charAt(i)))
			{
				return false;
			}
		}
		return true;
	}
}
