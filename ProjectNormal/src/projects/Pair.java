package projects;

import java.util.Map;
import java.util.Objects;

public class Pair<K, V> implements Map.Entry<K, V>
	{
		private K key;
		private V value;

		public Pair(K key, V value)
			{
				this.key = key;
				this.value = value;
			}

		public K getKey()
			{
				return key;
			}

		public void setKey(K element)
			{
				key = element;
			}

		public V getValue()
			{
				return value;
			}

		public V setValue(V element)
			{
				value = element;
				return element;
			}

		@Override
		public int hashCode()
			{
				return key.hashCode();
			}

		@SuppressWarnings("unchecked")
		@Override
		public boolean equals(Object obj)
			{
				Objects.requireNonNull(this, "This cannot be null.");
				Objects.requireNonNull(obj, "Cannot compare to null.");
				Pair<K, V> o = (Pair<K, V>) obj;
				return this.key.equals(o.key) && this.value.equals(o.value);
			}
	}
