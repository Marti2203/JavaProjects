package projects;

import java.util.Arrays;
import java.util.Collection;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class List<T> implements java.util.List<T>, Iterable<T>// ,Comparable<T>
	{
		private T[] elements;
		private int defaultCapacity;
		private int capacity;
		private int length;
		private ListIterator<T> iterator;

		public List()
			{
				this(10);
			}

		public List(int capacity)
			{
				this(capacity, null);
			}

		public List(Iterable<T> elements)
			{
				this();
				elements.forEach(this::add);
			}

		public List(T[] elements)
			{
				this(elements.length + 1);
				for (int i = 0; i < elements.length; i++)
					{
						this.add(elements[i]);
					}
			}

		@SuppressWarnings("unchecked")
		public List(int capacity, ListIterator<T> iterator)
			{
				if (capacity < 0)
					{
						throw new IndexOutOfBoundsException("Cannot create a list with negative size");
					}
				this.elements = (T[]) new Object[capacity];
				this.defaultCapacity = capacity;
				this.capacity = capacity;
				this.length = 0;
				this.iterator = iterator;
			}

		public int length()
			{
				return length;
			}

		@SuppressWarnings("unchecked")
		public void clear()
			{
				elements = (T[]) new Object[defaultCapacity];
				capacity = defaultCapacity;
				length = 0;
				System.gc();
			}

		@Override
		public boolean add(T element)
			{
				Objects.requireNonNull(element, "Null element cannot be added.");
				if (length == (capacity - 1))
					resize();
				elements[length++] = (T) element;
				return true;
			}

		@Override
		public void add(int index, T element)
			{
				if (index < 0)
					throw new IndexOutOfBoundsException("Index cannot be negative");
				Objects.requireNonNull(element, "Null element cannot be added.");
				moveFront(index);
				elements[index] = element;
				length++;
			}

		@Override
		public boolean addAll(Collection<? extends T> c)
			{
				for (T element : c)
					{
						if (this.add(element))
							return false;
					}
				return true;
			}

		@Override
		public boolean addAll(int index, Collection<? extends T> c)
			{
				if (index < 0)
					throw new IndexOutOfBoundsException("Index cannot be negative");
				forEach(element -> this.add(index, element));
				return true;
			}

		@Override
		public boolean contains(Object o)
			{
				Objects.requireNonNull(o, "Null element cannot be added.");
				for (int i = 0; i < length; i++)
					{
						if (elements[i].equals(o))
							return true;
					}
				return false;
			}

		@Override
		public boolean containsAll(Collection<?> c)
			{
				for (Object element : c)
					{
						if (!this.contains(element))
							return false;
					}
				return true;
			}

		@Override
		public T get(int index)
			{
				if (index < 0)
					throw new IndexOutOfBoundsException("Index cannot be negative.");
				return (T) elements[index];
			}

		@Override
		public int indexOf(Object o)
			{
				Objects.requireNonNull(o, "Null element cannot be added.");
				for (int i = 0; i < length; i++)
					{
						if (elements[i].equals(o))
							return i;
					}
				return -1;
			}

		@Override
		public boolean isEmpty()
			{
				return length == 0;
			}

		@Override
		public int lastIndexOf(Object o) throws NullPointerException
			{
				Objects.requireNonNull(o, "Null element cannot be added.");
				int maxIndex = -1;
				for (int i = 0; i < length; i++)
					{
						if (o.equals(elements[i]))
							maxIndex = i;
					}
				return maxIndex;
			}

		@Override
		public java.util.ListIterator<T> listIterator()
			{
				if (this.iterator == null)
					return this.listIterator(0);
				return this.iterator;
			}

		@Override
		public java.util.ListIterator<T> listIterator(int index)
			{
				return new Iterator(index, this);
			}

		@SuppressWarnings("unused")
		@Override
		public boolean remove(Object o)
			{
				Objects.requireNonNull(o, "Null element cannot be added.");
				for (int i = 0; i < length; i++)
					{
						if (elements[i].equals(o))
							moveBack(i);
						return true;
					}
				return false;
			}

		@Override
		public T remove(int index)
			{
				if (index < 0)
					throw new IndexOutOfBoundsException("Index canot be negative.");
				T element = elements[index];
				this.moveBack(index);
				length--;
				return (T) element;
			}

		@Override
		public boolean removeAll(Collection<?> c)
			{
				boolean result = false;
				for (Object element : c)
					{
						if (remove(element))
							result = true;
					}
				return result;
			}

		@Override
		public boolean retainAll(Collection<?> c)
			{
				boolean result = false;
				for (int i = 0; i < length; i++)
					{
						if (!c.contains(elements[i]))
							if (remove(elements[i]))
								result = true;
					}
				return result;
			}

		@Override
		public T set(int index, T element)
			{
				if (index < 0)
					throw new IndexOutOfBoundsException("Index cannot be negative");
				if (index > elements.length)
					throw new IndexOutOfBoundsException("There is no item at this position.");
				Objects.requireNonNull(element, "Null element cannot be added.");
				T result = elements[index];
				elements[index] = element;
				return (T) result;
			}

		@Override
		public int size()
			{
				return length;
			}

		@Override
		public java.util.List<T> subList(int fromIndex, int toIndex)
			{
				if (fromIndex < 0)
					throw new IndexOutOfBoundsException("From index cannot be negative");
				if (toIndex < 0)
					throw new IndexOutOfBoundsException("To index cannot be negative");
				if (fromIndex < toIndex)
					{
						fromIndex ^= toIndex;
						toIndex ^= fromIndex;
						fromIndex ^= toIndex;
					}
				List<T> result = new List<T>(1 + toIndex - fromIndex);
				for (int i = fromIndex; i < toIndex; i++)
					{
						result.add(elements[i]);
					}
				return result;
			}

		@Override
		public Object[] toArray()
			{
				return elements;
			}

		@SuppressWarnings({ "unchecked", "hiding" })
		@Override
		public <T> T[] toArray(T[] a)
			{
				if (a.length < length)
					a = (T[]) new Object[this.length];
				System.arraycopy(elements, 0, a, 0, length);
				return a;
			}

		@Override
		public java.util.Iterator<T> iterator()
			{
				if (this.iterator == null)
					return new Iterator(this);
				return this.iterator;
			}

		private void moveBack(int position)
			{
				for (int i = position; i < length; i++)
					{
						elements[i] = elements[i + 1];
					}
			}

		private void moveFront(int position)
			{
				if (length == (capacity - 1))
					resize();
				for (int i = position; i < length; i++)
					{
						elements[i + 1] = elements[i];
					}
			}

		private void resize()
			{
				this.elements = Arrays.copyOf(elements, capacity * 2);
				this.capacity = capacity * 2;
				System.gc();
			}

		class Iterator implements ListIterator<T>
			{
				int currentIndex;
				List<T> list;

				public Iterator(List<T> list)
					{
						this(0, list);
					}

				public Iterator(int startIndex, List<T> list)
					{
						if (startIndex < 0)
							throw new IndexOutOfBoundsException("Starting index cannot be negative.");
						this.currentIndex = startIndex;
						this.list = list;
					}

				@Override
				public void add(T e)
					{
						list.add(currentIndex, e);
					}

				@Override
				public boolean hasNext()
					{
						return currentIndex < list.length && list.get(currentIndex + 1) != null;
					}

				@Override
				public boolean hasPrevious()
					{
						return currentIndex > 0;
					}

				@Override
				public T next()
					{
						if (hasNext())
							return list.get(++currentIndex);
						else
							throw new NoSuchElementException();
					}

				@Override
				public int nextIndex()
					{
						if (currentIndex != length)
							return currentIndex + 1;
						return currentIndex;
					}

				@Override
				public T previous()
					{
						if (hasPrevious())
							return list.get(--currentIndex);
						throw new NoSuchElementException();
					}

				@Override
				public int previousIndex()
					{
						return currentIndex - 1;
					}

				@Override
				public void remove()
					{
						list.remove(currentIndex--);
					}

				@Override
				public void set(T e)
					{
						list.set(currentIndex, e);
					}
			}

	}
