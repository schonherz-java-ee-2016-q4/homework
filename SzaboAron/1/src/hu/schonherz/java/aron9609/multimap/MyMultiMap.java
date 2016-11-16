package hu.schonherz.java.aron9609.multimap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyMultiMap<K, V> implements MultiMap<K, V> {

	public static class MultiMapNode<K, V> {

		private K key;
		private List<V> values;

		public MultiMapNode() {
			super();
			this.values = new ArrayList<>();
		}

		public MultiMapNode(K key, V value) {
			this();
			this.key = key;
			this.values.add(value);
		}

		public MultiMapNode(K key, List<V> values) {
			this();
			this.key = key;
			this.values.addAll(values);
		}

		public void addValue(V value) {
			values.add(value);
		}

		public void addAllValue(List<V> value) {
			values.addAll(value);
		}

		public K getKey() {
			return key;
		}

		public void setKey(K key) {
			this.key = key;
		}

		public List<V> getValues() {
			return values;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((key == null) ? 0 : key.hashCode());
			result = prime * result + ((values == null) ? 0 : values.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			MultiMapNode<K, V> other = (MultiMapNode<K, V>) obj;
			if (key == null) {
				if (other.key != null)
					return false;
			} else if (!key.equals(other.key))
				return false;
			if (values == null) {
				if (other.values != null)
					return false;
			} else if (!values.equals(other.values))
				return false;
			return true;
		}

	}

	List<MultiMapNode<K, V>> multiMapDataStructure;

	public MyMultiMap() {
		super();
		multiMapDataStructure = new ArrayList<>();
	}

	@Override
	public void clear() {
		multiMapDataStructure.clear();

	}

	@Override
	public boolean containsKey(Object key) {
		if (key == null) {
			throw new IllegalArgumentException("The key are not allowed to be null value");
		}
		for (MultiMapNode<K, V> n : multiMapDataStructure) {
			if (n.getKey().equals(key)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		if (value == null) {
			throw new IllegalArgumentException("The value are not allowed to be null value");
		}
		for (MultiMapNode<K, V> n : multiMapDataStructure) {
			if (n.getValues().contains(value)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Collection<V> get(Object key) {
		for (MultiMapNode<K, V> n : multiMapDataStructure) {
			if (n.getKey().equals(key)) {
				return n.getValues();
			}
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		return multiMapDataStructure.isEmpty();
	}

	@Override
	public V put(K key, V value) {
		if (key == null) {
			throw new IllegalArgumentException("The key are not allowed to be null value");
		}

		MultiMapNode<K, V> existing = null;
		for (MultiMapNode<K, V> n : multiMapDataStructure) {
			if (n.getKey().equals(key)) {
				existing = n;
			}
		}
		if (existing != null) {
			V lastValue = existing.getValues().get(existing.getValues().size() - 1);
			existing.addValue(value);
			return lastValue;
		} else {
			MultiMapNode<K, V> newNode = new MultiMapNode<K, V>(key, value);
			multiMapDataStructure.add(newNode);
			return null;
		}

	}

	public V put(MultiMapNode<K, V> newNode) {
		if (newNode == null || newNode.getKey() == null) {
			throw new IllegalArgumentException("The key are not allowed to be null value");
		}
		MultiMapNode<K, V> existing = null;
		if (!multiMapDataStructure.isEmpty()) {
			for (MultiMapNode<K, V> n : multiMapDataStructure) {
				if (n.getKey().equals(newNode.getKey())) {
					existing = n;
				}
			}
		}
		if (existing != null) {
			V lastValue = existing.getValues().get(existing.getValues().size() - 1);
			existing.addAllValue(newNode.getValues());
			return lastValue;
		} else {
			multiMapDataStructure.add(newNode);
			return null;
		}

	}

	@Override
	public Collection<V> remove(Object key) {
		if (key == null) {
			throw new IllegalArgumentException("The key are not allowed to be null value");
		}
		MultiMapNode<K, V> existing = null;
		for (MultiMapNode<K, V> n : multiMapDataStructure) {
			if (n.getKey().equals(key)) {
				existing = n;
				multiMapDataStructure.remove(n);
				return existing.getValues();
			}
		}

		return null;
	}

	@Override
	public Object remove(Object key, Object value) {
		if (key == null) {
			throw new IllegalArgumentException("The key are not allowed to be null value");
		}
		for (MultiMapNode<K, V> n : multiMapDataStructure) {
			if (n.getKey().equals(key) && n.getValues().contains(value)) {
				n.getValues().remove(value);
				if (n.getValues().isEmpty()) {
					multiMapDataStructure.remove(n);
				}
				return n.getValues();
			}
		}
		return null;
	}

	@Override
	public int size() {
		return multiMapDataStructure.size();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((multiMapDataStructure == null) ? 0 : multiMapDataStructure.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyMultiMap other = (MyMultiMap) obj;
		if (multiMapDataStructure == null) {
			if (other.multiMapDataStructure != null)
				return false;
		} else if (!multiMapDataStructure.equals(other.multiMapDataStructure))
			return false;
		return true;
	}

}
