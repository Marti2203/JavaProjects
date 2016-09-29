package utils;

public enum ListExtender {
	;
	public static <T> boolean Contains(Iterable<T> list,T element)
	{
		for(T item:list)
		{
			if(item.equals(element))
			{
				return true;
			}
		}
		return false;
	}
}
