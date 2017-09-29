package org.chickendb;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ChickenDB<K, M extends IModel<K>> implements Iterable<M> {
	private Map<K, M> db;

	public ChickenDB() {
		db = new HashMap<>();
	}

	@Override
	public Iterator<M> iterator() {
		return db.values().iterator();
	}

	public void add(M item) {
		db.put(item.getKey(), item);
	}

	public void put(M item) {
		add(item);
	}

	public void modify(M item) {
		add(item);
	}
	
	public void update(M item) {
		add(item);
	}
	
	public M get(K key) {
		return db.get(key);
	}

	public void remove(M item) { delete(item); }

	public void remove(K key) { delete(key); }

	public void delete(M item) {
		delete(item.getKey());
	}
	
	public void delete(K key) {
		db.remove(key);
	}

	public boolean contains(M item) {
		return db.containsValue(item);
	}

	public boolean contains(K key) {
		return db.containsKey(key);
	}

	public void clear() {
		db.clear();
	}

	public int size() {
		return db.size();
	}

	public boolean isEmpty() {
		return db.isEmpty();
	}

	public Stream<M> stream() {
		return db.values().stream();
	}

	public Stream<M> parallelStream() {
		return db.values().stream();
	}

	public Collection<M> toCollection() {
        return db.values();
    }

    public ChickenDB<K, M> filter(IFilter<M> filter) {
        ChickenDB<K, M> clone = new ChickenDB<>();
        clone.db = stream().filter(filter::validate)
                           .collect(Collectors.toMap(IModel::getKey, v -> v));
        return clone;
    }
}
