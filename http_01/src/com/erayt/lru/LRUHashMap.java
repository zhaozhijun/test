package com.erayt.lru;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class LRUHashMap<K, V> {

	private LinkedHashMap<K, V> map;

	private static final float LOAD_FACTOR = 0.75f;

	private int size;

	public LRUHashMap(int size) {
		this.size = size;
		int capacity = (int) Math.ceil(size / LOAD_FACTOR) + 1;
		map = new LinkedHashMap<K, V>(capacity, LOAD_FACTOR, true) {

			private static final long serialVersionUID = 1L;

			@Override
			protected boolean removeEldestEntry(Entry<K, V> eldest) {
				return size() > LRUHashMap.this.size;
			}
		};
	}

	public synchronized V get(K key) {
		return map.get(key);
	}

	public synchronized void put(K key, V value) {
		map.put(key, value);
	}

	public synchronized int usedEntries() {
		return map.size();
	}

	public synchronized void clear() {
		map.clear();
	}

	public synchronized Collection<Entry<K, V>> getAll() {
		return new ArrayList<Entry<K, V>>(map.entrySet());
	}
	
	public static void main(String[] args) {
		LRUHashMap<String,String> lruHashMap=new LRUHashMap<String,String>(4);
		lruHashMap.put("1", "1");
		lruHashMap.put("2", "2");
		lruHashMap.put("3", "3");
		lruHashMap.put("4", "4");
		lruHashMap.put("5", "5");
		for (Entry<String, String> entry : lruHashMap.getAll()) {
			System.out.println(entry.getKey()+"=="+entry.getValue());
		}
	}
}
