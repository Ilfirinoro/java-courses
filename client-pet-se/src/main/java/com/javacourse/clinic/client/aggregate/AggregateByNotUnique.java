package com.javacourse.clinic.client.aggregate;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

public class AggregateByNotUnique<K, V> {
    private Map<K, Set<V>> map;

    public AggregateByNotUnique() {
        map = new ConcurrentHashMap<>();
    }

    public void put(K key, V value) {
        Set<V> valuesSet = map.get(key);
        if(valuesSet == null) {
            synchronized (this.map) {
                if(valuesSet == null) {
                    valuesSet = new CopyOnWriteArraySet<>();
                    map.put(key, valuesSet);
                } else {
                    valuesSet = map.get(key);
                }
            }
        }
        valuesSet.add(value);
    }

    public Set<V> get(K key) {
        return map.get(key);
    }

    public boolean remove(K key, V value) {
        Set<V> valuesSet = map.get(key);
        if(valuesSet == null) {
            return false;
        }
        boolean result = valuesSet.remove(value);
        if(valuesSet.size() == 0) {
            map.remove(key);
        }
        return result;
    }
}
