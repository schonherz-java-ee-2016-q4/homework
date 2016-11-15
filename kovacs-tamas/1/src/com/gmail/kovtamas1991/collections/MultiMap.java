package com.gmail.kovtamas1991.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MultiMap<K, V> implements Map<K, V> {

    private List<K> keys;
    private List<LinkedList<V>> values;

    public MultiMap() {
        keys = new LinkedList<>();
        values = new ArrayList<>();
    }

    @Override
    public void clear() {
        keys.clear();
        values.clear();
    }

    @Override
    public boolean containsKey(Object key) {
        if (key == null) {
            return false;
        }
        return keys.contains(key);
    }

    @Override
    public boolean containsValue(Object value) {
        if (value == null) {
            return false;
        }

        for (List<V> currentValueList : values) {
            for (V currentValue : currentValueList) {
                if (currentValue.equals(value)) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public Set<java.util.Map.Entry<K, V>> entrySet() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public V get(Object arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isEmpty() {
        return keys.isEmpty();
    }

    @Override
    public Set<K> keySet() {
        return new HashSet<>(keys);
    }

    @Override
    public V put(K arg0, V arg1) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public V remove(Object arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int size() {
        return keys.size();
    }

    @Override
    public Collection<V> values() {
        return values.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }


}
