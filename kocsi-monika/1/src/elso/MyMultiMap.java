package elso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyMultiMap<V, K> implements MultiMap<K, V>{
	private List<Object> keys;
	private ArrayList<List<Object>> values;
	private List<Object> list;
	
	public MyMultiMap() {
		this.keys = new ArrayList<Object>();
		this.values = new ArrayList<List<Object>>();
	}
	
	@Override
	public void clear() {
		
	}

	@Override
	public boolean containsKey(Object key) {
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		return false;
	}

	@Override
	public Collection<V> get(Object key) {
		int n = keys.indexOf(key);
		if(n >= 0) {
			return (Collection<V>) values.get(n);
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public Object put(Object key, Object value) {
		int find=0;
		for(int i=0; i<keys.size(); i++) {
			if(key.equals(keys.get(i))) {
				List<Object> l = values.get(i);
				l.add(value);
				values.set(i, l);
				find=1;
				break;
			}
		}
		if(find==0){
			keys.add(key);
			list = new ArrayList<Object>();
			list.add(value);
			int n = keys.indexOf(key);
			values.add(n, list);
		}
		
		return null;
	}

	@Override
	public Collection<V> remove(Object key) {
		return null;
	}

	@Override
	public Object remove(Object key, Object value) {
		return null;
	}

	@Override
	public int size() {
		return keys.size();
	}

	@Override
	public boolean equals(Object o) {
		return false;
	}
	
	@Override
	public int hashCode() {
		return 0;
	}
}
