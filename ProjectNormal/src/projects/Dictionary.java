package projects;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Dictionary<K, V> implements Map<K, V>
	{
		List<Map.Entry<K, V>> pairs;
		double threshold = 0.75;
		int elements;

		public Dictionary()
			{
				this.pairs = new List<>(20);
			}

		public Dictionary(Iterable<Map.Entry<K, V>> elements)
			{
				this();
				for (Entry<K, V> entry : elements)
					{
						this.put(entry.getKey(), entry.getValue());
					}
			}

		@Override
		public int size()
			{
				return elements;
			}

		@Override
		public boolean isEmpty()
			{
				return elements == 0;
			}

		@Override
		public V get(Object key)
			{
				V result = null;
				Objects.requireNonNull(key, "Key must not be null");
				int position = key.hashCode() % pairs.size();
				if (pairs.get(position).getKey().equals(key))
					result = pairs.get(position).getValue();

				return result;
			}

		@Override
		public V put(K key, V value)
			{
				V result = null;
				if (pairs.size() + 1 > threshold * pairs.size())
					{
						resizeLists();
					}
				if (pairs.get(key.hashCode() % pairs.length()) != null)
					resizeLists();
				if (get(key) != null)
					result = get(key);
				pairs.set(key.hashCode() % pairs.length(), new Pair<>(key, value));
				elements++;
				return result;
			}

		@Override
		public V remove(Object key)
			{
				return pairs.remove(key.hashCode() % pairs.length()).getValue();
			}

		public Collection<Entry<K, V>> toList()
			{
				return pairs;
			}

		@Override
		public boolean containsKey(Object key)
			{
				return this.pairs.stream().anyMatch(pair -> pair.getKey().equals(key));
			}

		@Override
		public boolean containsValue(Object value)
			{
				return this.pairs.stream().anyMatch(pair -> pair.getValue().equals(value));
			}

		@Override
		public void putAll(Map<? extends K, ? extends V> m)
			{
				for (K k : m.keySet())
					{
						this.put(k, m.get(k));
					}
			}

		@Override
		public void clear()
			{
				this.pairs.clear();
				this.elements = 0;
			}

		@Override
		public Set<K> keySet()
			{
				Set<K> values = new projects.Set<>(elements);
				for (Entry<K, V> pair : pairs)
					{
						values.add(pair.getKey());
					}
				return values;
			}

		@Override
		public Collection<V> values()
			{
				Collection<V> values = new List<>(elements);
				for (Entry<K, V> pair : pairs)
					{
						values.add(pair.getValue());
					}
				return values;
			}

		@Override
		public Set<Map.Entry<K, V>> entrySet()
			{
				return new projects.Set<Map.Entry<K, V>>(pairs);
			}

		private void resizeLists()
			{
				List<Map.Entry<K, V>> newPairs = new List<>(pairs.size() * 2);
				for (Entry<K, V> pair : pairs)
					{
						newPairs.add(pair.getKey().hashCode() % newPairs.size(), pair);
					}
				this.pairs = newPairs;
				System.gc();
			}
	}
