package com.gmail.kovtamas1991.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MultiMap<K, V> implements Map<K, V> {

    private List<K> keys;
    private List<LinkedList<V>> values;

    public MultiMap() {
        keys = new LinkedList<>();
        values = new ArrayList<>();
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean containsKey(Object arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean containsValue(Object arg0) {
        // TODO Auto-generated method stub
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
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Set<K> keySet() {
        // TODO Auto-generated method stub
        return null;
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
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Collection<V> values() {
        // TODO Auto-generated method stub
        return null;
    }


}
