import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class MyMultiMap<K, V> implements MultiMap<K, V> {

	Map<Integer, ArrayList<V>> multiMap;

	@Override
	public void clear() {
		multiMap.clear();
		
	}

	@Override
	public boolean containsKey(Object key) {
		return multiMap.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return multiMap.containsKey(value);
	}

	@Override
	public Collection<V> get(Object key) {		
		return multiMap.get(key);
	}

	@Override
	public boolean isEmpty() {
		return multiMap.isEmpty();
	}

	@Override
	public V put(K key, V value) {
		
		return null;
	}

	@Override
	public Collection<V> remove(Object key) {
		multiMap.remove(key);
		return multiMap.get(key);
	}
	
	

	@Override
	public Object remove(Object key, Object value) {
		if ( multiMap.isEmpty() && multiMap.containsKey(key) && multiMap.containsValue(value)) {
			return multiMap.get(key).remove(multiMap.get(key).indexOf(value));
		} else

		return null;
	}

	@Override
	public int size() {
		multiMap.size();
		return 0;
	}

}
