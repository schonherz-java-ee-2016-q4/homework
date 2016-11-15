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
    public V get(Object key) {
        if (key == null) {
            return null;
        }

        int keyIndex = keys.indexOf(key);
        if (!isValidKeyIndex(keyIndex)) {
            return null;
        }

        LinkedList<V> valuesOfKey = values.get(keyIndex);
        return valuesOfKey.getLast();
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
    public void putAll(Map<? extends K, ? extends V> otherMap) {
        if (otherMap != null && !otherMap.isEmpty()) {
            for (Map.Entry<? extends K, ? extends V> entry : otherMap.entrySet()) {
                this.put(entry.getKey(), entry.getValue());
            }
        }
    }

    @Override
    public V remove(Object key) {
        if (key == null) {
            return null;
        }

        int keyIndex = keys.indexOf(key);
        if (!isValidKeyIndex(keyIndex)) {
            return null;
        }

        LinkedList<V> valuesOfKey = values.get(keyIndex);
        if (valuesOfKey.size() > 1) {
            return valuesOfKey.removeLast();
        } else {
            keys.remove(keyIndex);
            values.remove(keyIndex);
            return valuesOfKey.removeLast();
        }
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

    private boolean isValidKeyIndex(int keyIndex) {
        return keyIndex >= 0 && keyIndex < keys.size();
    }

}
