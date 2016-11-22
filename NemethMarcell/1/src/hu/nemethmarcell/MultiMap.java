package hu.nemethmarcell;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MultiMap<K, V> implements MyMultiMap<K, V> {
    Map<K, ArrayList<V>> multiMap;
    ArrayList<V> list;

    public MultiMap() {
        multiMap = new HashMap<>();
    }

    @Override
    public int size() {
        return multiMap.size();
    }

    public V put(K key, V value) {
        list = multiMap.get(key);
        if (list == null) {
            multiMap.put(key, list = new ArrayList<V>());

        }
        list.add(value);

        return value;
    }

    @Override
    public Collection<V> get(Object key) {
        return multiMap.get(key);
    }

    @Override
    public void clear() {
        multiMap.clear();

    }

    @Override
    public boolean containsKey(Object key) {
        if (multiMap.containsKey(key)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (Object k : multiMap.keySet()) {
            if (multiMap.get(k).contains(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        if (multiMap.isEmpty()) {
            return true;
        }
        return false;
    }

    @Override
    public Collection<V> remove(Object key) {
        Collection<V> ret = get(key);
        multiMap.remove(key);
        return ret;
    }

    @Override
    public Object remove(Object key, Object value) {
        if (multiMap.get(key) == null) {
            return null;
        }
        if (multiMap.get(key) != null) {
            multiMap.get(key).remove(value);
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("MultiMap [multiMap=");
        builder.append(multiMap);
        builder.append("]");
        return builder.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((list == null) ? 0 : list.hashCode());
        result = prime * result + ((multiMap == null) ? 0 : multiMap.hashCode());
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
        MultiMap other = (MultiMap) obj;
        if (list == null) {
            if (other.list != null)
                return false;
        } else if (!list.equals(other.list))
            return false;
        if (multiMap == null) {
            if (other.multiMap != null)
                return false;
        } else if (!multiMap.equals(other.multiMap))
            return false;
        return true;
    }
}