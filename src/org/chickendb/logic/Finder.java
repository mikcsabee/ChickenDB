package org.chickendb.logic;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.chickendb.model.IModel;

public class Finder<K, M extends IModel<K>> {
	private Map<K, M> db;

	public Finder(Map<K, M> db) {
		this.db = new HashMap<>(db);
	}

	public Finder<K, M> filter(IFilter<M> filter) {
		db.values().stream()
			  .filter(item -> filter.validate(item) == false)
			  .map(IModel::getKey)
			  .collect(Collectors.toList())
			  .forEach(db::remove);
		
		return this;
	}
	
	public Map<K, M> result() {
		return db;
	}
}
