package multimaphomework;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MyMultiMap<K, V> implements MultiMap<K, V> {
	private HashMap<K, ArrayList<V>> mmap;

	public MyMultiMap() {
		super();
		mmap = new HashMap<>();
	}

	@Override
	public void clear() {
		mmap.clear();
	}

	@Override
	public boolean containsKey(Object key) {
		return mmap.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		for (Object i : mmap.keySet()) {
			if (mmap.get(i).contains(value)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Collection<V> get(Object key) {
		Collection<V> valuelist = new ArrayList<V>();
		if (!mmap.containsKey(key)) {
			return valuelist;
		}
		for (V i : mmap.get(key)) {
			valuelist.add(i);
		}
		return valuelist;
	}

	@Override
	public boolean isEmpty() {
		if (mmap.isEmpty()) {
			return true;
		}
		return false;
	}

	@Override
	public V put(K key, V value) {
		ArrayList<V> list;

		if (!mmap.containsKey(key)) {
			list = new ArrayList<V>();
			mmap.put(key, list);
			list.add(value);
			return value;
		}

		list = mmap.get(key);
		list.add(value);
		return value;
	}

	@Override
	public Collection<V> remove(Object key) {
		if (!mmap.containsKey(key)) {
			return mmap.get(0);
		}
		mmap.remove(key);
		return mmap.get(0);
	}

	@Override
	public Object remove(Object key, Object value) {
		if (!mmap.containsKey(key)) {
			return mmap.get(0);
		}
		if (!(mmap.get(key)).contains(value)) {
			return mmap.get(0);
		}
		ArrayList<V> list;
		list=mmap.get(key);
		while(list.contains(value)) {
			list.remove(list.indexOf(value));
		}
		return mmap.get(0);
	}

	@Override
	public int size() {
		return mmap.size();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mmap == null) ? 0 : mmap.hashCode());
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
		if (mmap == null) {
			if (other.mmap != null)
				return false;
		} else if (!mmap.equals(other.mmap))
			return false;
		return true;
	}

	public Object keySet() {
		return mmap.keySet();
	}
	
	public Set<Map.Entry<K, ArrayList<V>>> entrySet() {
        return mmap.entrySet();
    }
}