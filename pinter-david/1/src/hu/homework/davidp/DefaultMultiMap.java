package hu.homework.davidp;

import java.util.*;

public class DefaultMultiMap<K, V> implements MultiMap<K, V> {
    private Map<K, ArrayList<V>> data;

    public DefaultMultiMap(){
        data = new HashMap<>();
    }

    public DefaultMultiMap(Map<K, ArrayList<V>> data) {
        this.data = data;
    }

    @Override
    public void clear() {
        data.clear();
    }

    @Override
    public boolean containsKey(Object key) {
        return data.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        for (ArrayList<V> values : data.values()) {
            if (values.contains(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Collection<V> get(Object key) {
        return data.get(key);
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public V put(K key, V value) {
        if (!data.containsKey(key)) {
            data.put(key, new ArrayList<>());
        }
        data.get(key).add(value);
        return value;
    }

    @Override
    public Collection<V> remove(Object key) {
        return data.remove(key);
    }

    @Override
    public Object remove(Object key, Object value) {
        boolean isEmptyDataValue = data.containsKey(key) && data.get(key).size() == 0;

        if (!data.containsKey(key) || isEmptyDataValue || !data.get(key).contains(value)) {
            return null;
        }

        return data.get(key).remove(data.get(key).indexOf(value));
    }

    @Override
    public int size() {
        return data.size();
    }

    public Set<Map.Entry<K, ArrayList<V>>> entrySet() {
        return data.entrySet();
    }
}
