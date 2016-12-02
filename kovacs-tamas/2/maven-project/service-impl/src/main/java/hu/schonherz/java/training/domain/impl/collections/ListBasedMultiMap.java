package hu.schonherz.java.training.domain.impl.collections;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import hu.schonherz.java.training.domain.collections.MultiMap;

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
            if (currentValueList.contains(value)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public Collection<V> get(Object key) {
        if (key == null) {
            return new ArrayList<>(0);
        }

        int keyIndex = keys.indexOf(key);
        if (!isValidKeyIndex(keyIndex)) {
            return new ArrayList<>(0);
        }

        return values.get(keyIndex);
    }

    @Override
    public boolean isEmpty() {
        return keys.isEmpty();
    }

    @Override
    public void put(K key, V value) {
        if (key == null || value == null) {
            throw new IllegalArgumentException("Nor the key or value are allowed to be null!");
        }

        int keyIndex = keys.indexOf(key);
        // if map already contains key
        if (isValidKeyIndex(keyIndex)) {
            LinkedList<V> existingValues = values.get(keyIndex);
            existingValues.add(value);
        } else {
            keys.add(key);
            LinkedList<V> valueList = new LinkedList<>();
            valueList.add(value);
            values.add(valueList);
        }
    }

    @Override
    public void put(K key, Collection<V> newValues) {
        if (key == null || newValues == null) {
            throw new IllegalArgumentException("Nor the key or values are allowed to be null!");
        }

        int keyIndex = keys.indexOf(key);
        if (isValidKeyIndex(keyIndex)) {
            values.get(keyIndex).addAll(newValues);
        } else {
            keys.add(key);
            values.add(new LinkedList<>(newValues));
        }
    }

    @Override
    public Set<K> keySet() {
        return Collections.unmodifiableSet(new HashSet<>(keys));
    }

    @Override
    public Set<Entry<K, List<V>>> entrySet() {
        Set<Entry<K, List<V>>> entrySet = new HashSet<>();
        for (int i = 0; i < keys.size(); i++) {
            Entry<K, List<V>> currentEnty = new AbstractMap.SimpleEntry<>(keys.get(i), values.get(i));
            entrySet.add(currentEnty);
        }

        return entrySet;
    }

    @Override
    public Set<List<V>> values() {
        Set<List<V>> allValues = new HashSet<>();
        allValues.addAll(values);
        return allValues;
    }

    @Override
    public Collection<V> remove(Object key) {
        if (key == null) {
            return new ArrayList<>(0);
        }

        int keyIndex = keys.indexOf(key);
        if (!isValidKeyIndex(keyIndex)) {
            return new ArrayList<>(0);
        }

        keys.remove(keyIndex);
        return values.remove(keyIndex);
    }

    @Override
    public Object remove(Object key, Object value) {
        if (key == null || value == null) {
            return null;
        }

        int keyIndex = keys.indexOf(key);
        if (!isValidKeyIndex(keyIndex)) {
            return null;
        }

        List<V> keyValues = values.get(keyIndex);
        if (!keyValues.contains(value)) {
            return null;
        }

        if (keyValues.size() == 1) {
            keys.remove(keyIndex);
            values.remove(keyIndex);
        }
        keyValues.remove(value);

        return value;
    }

    @Override
    public int size() {
        return keys.size();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((keys == null) ? 0 : keys.hashCode());
        result = prime * result + ((values == null) ? 0 : values.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        ListBasedMultiMap other = (ListBasedMultiMap) obj;
        if (keys == null) {
            if (other.keys != null) {
                return false;
            }
        } else if (!keys.equals(other.keys)) {
            return false;
        }
        if (values == null) {
            if (other.values != null) {
                return false;
            }
        } else if (!values.equals(other.values)) {
            return false;
        }
        return true;
    }

    private boolean isValidKeyIndex(int keyIndex) {
        return keyIndex >= 0 && keyIndex < keys.size();
    }

}
