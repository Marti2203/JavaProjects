package projects;

import java.util.Collection;
import java.util.Spliterator;

public class Set<E> extends List<E> implements java.util.Set<E> {

	@Override
	public boolean add(E e) {
		if (this.contains(e)) {
			return false;
		}
		super.add(e);
		return true;
	}

	public Set() {
		super();
	}

	public Set(int capacity) {
		super(capacity);
	}
	public Set(Collection<E> collection)
		{
			for (E e : collection)
				{
					this.add(e);
				}
		}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		for (E e : c) {
			if (!add(e)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public Spliterator<E> spliterator()
		{
			// TODO Auto-generated method stub
			return java.util.Set.super.spliterator();
		}

}
