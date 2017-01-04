package hu.schonherz.java.training.utility.map;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map.Entry;
import java.util.Set;

public interface MultiMap<K, V> {

    public void clear();

    public boolean containsKey(Object key);

    boolean containsValue(Object value);

    public Collection<V> get(Object key);

    public boolean isEmpty();

    public V put(K key, V value);

    public Collection<V> remove(Object key);

    public Object remove(Object key, Object value);

    public int size();

    public boolean equals(Object o);

    public int hashCode();

    Set<Entry<K, ArrayList<V>>> entrySet();
}
