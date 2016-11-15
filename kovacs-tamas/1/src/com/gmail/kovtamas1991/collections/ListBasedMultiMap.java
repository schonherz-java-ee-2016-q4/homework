package com.gmail.kovtamas1991.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class ListBasedMultiMap<K, V> implements MultiMap<K, V> {

    private List<K> keys;
    private List<LinkedList<V>> values;

    public ListBasedMultiMap() {
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
    public Collection<V> get(Object key) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isEmpty() {
        return keys.isEmpty();
    }

    @Override
    public V put(K key, V value) {
        if (key == null || value == null) {
            throw new IllegalArgumentException("Nor the key or value are allowed to be null!");
        }

        int keyIndex = keys.indexOf(key);
        // if map already contains key
        if (isValidKeyIndex(keyIndex)) {
            LinkedList<V> existingValues = values.get(keyIndex);
            V prevValue = existingValues.getLast();
            existingValues.add(value);
            return prevValue;
        } else {
            keys.add(key);
            LinkedList<V> valueList = new LinkedList<>();
            valueList.add(value);
            values.add(valueList);
            return null;
        }
    }

    @Override
    public Collection<V> remove(Object key) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object remove(Object key, Object value) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int size() {
        return keys.size();
    }

    private boolean isValidKeyIndex(int keyIndex) {
        return keyIndex >= 0 && keyIndex < keys.size();
    }

}
