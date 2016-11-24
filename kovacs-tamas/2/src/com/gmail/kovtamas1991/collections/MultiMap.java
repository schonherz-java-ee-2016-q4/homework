package com.gmail.kovtamas1991.collections;

import java.util.Collection;

public interface MultiMap<K, V> {

    public void clear();

    public boolean containsKey(Object key);

    boolean containsValue(Object value);

    public Collection<V> get(Object key);

    public boolean isEmpty();

    public void put(K key, V value);

    public void put(K key, Collection<V> values);

    public Collection<V> remove(Object key);

    // What exactly should I give back?
    public Object remove(Object key, Object value);

    public int size();

    @Override
    public boolean equals(Object o);

    @Override
    public int hashCode();

}
