package org.chickendb;

import java.util.HashMap;
import java.util.Map;

import org.chickendb.logic.Finder;
import org.chickendb.model.IModel;

public class ChickenDB<K, M extends IModel<K>> {
	private Map<K, M> db;

	public ChickenDB() {
		db = new HashMap<>();
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
	
	public M getByKey(K key) {
		return db.get(key);
	}

	public void delete(M item) {
		delete(item.getKey());
	}
	
	public void delete(K key) {
		db.remove(key);
	}
	
	public Finder<K, M> finder() {
		return new Finder<>(db);
	}
}
