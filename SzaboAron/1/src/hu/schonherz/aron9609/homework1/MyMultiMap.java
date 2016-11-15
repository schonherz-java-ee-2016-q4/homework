package hu.schonherz.aron9609.homework1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//Nincs teljesen kész, néhány metódus implementálás alatt, a már implementáltak pedig átgondolás alatt

public class MyMultiMap<K, V> implements Map<K, V> {
	class Node implements Map.Entry<K, List<V>> {
		private K key;
		private List<V> value;

		public Node() {
			super();
		}

		public Node(K key, List<V> value) {
			super();
			this.key = key;
			this.value = value;
		}

		public K getKey() {
			return key;
		}

		public void setKey(K key) {
			this.key = key;
		}

		public List<V> getValue() {
			return value;
		}

		public List<V> setValue(List<V> value) {
			this.value = value;
			return value;
		}

	}

	private ArrayList<Node> multiMapImpl = new ArrayList<>();

	@Override
	public void clear() {
		multiMapImpl.clear();
	}

	@Override
	public boolean containsKey(Object arg0) {
		for (Node n : multiMapImpl) {
			if (n.getKey().equals(arg0)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean containsValue(Object arg0) {
		for (Node n : multiMapImpl) {
			if (n.getValue().contains(arg0)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		return null;
	}

	@Override
	public V get(Object arg0) {
		return null;
	}

	@Override
	public boolean isEmpty() {
		if (multiMapImpl.isEmpty()) {
			return true;
		}
		return false;
	}

	@Override
	public Set<K> keySet() {
		Set<K> keys = new HashSet<>();
		for (Node n : multiMapImpl) {
			keys.add(n.getKey());
		}
		return keys;
	}

	@Override
	public V put(K arg0, V arg1) {
		for (Node n : multiMapImpl) {
			if (n.getKey().equals(arg0)) {
				n.getValue().add(arg1);
				return arg1;
			}
		}
		Node newNode = new Node();
		newNode.setKey(arg0);
		List<V> newNodesValues = new ArrayList<V>();
		newNodesValues.add(arg1);
		newNode.setValue(newNodesValues);
		return arg1;

	}

	@Override
	public void putAll(Map<? extends K, ? extends V> arg0) {
	}

	@Override
	public V remove(Object arg0) {

		return null;
	}

	@Override
	public int size() {
		return multiMapImpl.size();
	}

	@Override
	public Collection<V> values() {
		List<V> vals = new ArrayList<>();
		for (Node n : multiMapImpl) {
			vals.addAll(n.getValue());
		}
		return vals;
	}

}
