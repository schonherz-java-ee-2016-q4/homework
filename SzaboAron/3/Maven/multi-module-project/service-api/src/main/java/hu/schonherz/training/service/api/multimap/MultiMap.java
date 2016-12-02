package hu.schonherz.training.service.api.multimap;

import java.util.Collection;
import java.util.List;

public interface MultiMap<K, V> {

    public void clear();

    public boolean containsKey(Object key);

    boolean containsValue(Object value);

    public Collection<V> get(Object key);

    public boolean isEmpty();

    public V put(K key, V value);

    public V put(K key, List<V> value);

    public Collection<V> remove(Object key);

    public Object remove(Object key, Object value);

    public int size();

    public boolean equals(Object o);

    public int hashCode();

}
