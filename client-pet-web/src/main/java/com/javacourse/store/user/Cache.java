package com.javacourse.store.user;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class Cache<K, V> {
    private final Map<K, V> map;

    public Cache() {
        this.map = new HashMap<>();
    }

    public V get(K key) {
        return this.map.get(key);
    }

    public V put(K key, V value) {
        return this.map.put(key, value);
    }

    public V remove(K key) {
        return this.map.remove(key);
    }

    public Collection<V> values() {
        return map.values();
    }
}
