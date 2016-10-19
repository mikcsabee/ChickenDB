package org.chickendb.logic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.chickendb.model.IModel;

public class Finder<K, M extends IModel<K>> {
	private Map<K, M> db;

	public Finder(Map<K, M> db) {
		this.db = new HashMap<>(db);
	}

	public Finder<K, M> filter(IFilter<M> filter) {
		Iterator<Entry<K, M>> it = db.entrySet().iterator();
		while(it.hasNext()) {
			Entry<K, M> item = it.next();
			if(filter.validate(item.getValue()) == false) {
				it.remove();
			}
		}
		return this;
	}
	
	public Map<K, M> result() {
		return db;
	}
}
