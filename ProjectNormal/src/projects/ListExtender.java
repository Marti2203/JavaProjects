package projects;

public class ListExtender<T> {
	public boolean Contains(Iterable<T> list,T element)
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
	public final static ListExtender<String> StringSearcher=new ListExtender<String>();
}
