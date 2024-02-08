package org.example.OrderedHashMap;

public class Entry <K,V>{
    K key;
    V value;
    Entry<K,V>previous;
    Entry<K,V>next;

    public Entry(K key, V value, Entry<K, V> previous, Entry<K, V> next) {
        if(key == null || value == null){
            throw new IllegalArgumentException("Key and value cannot be empty");
        }
        this.key = key;
        this.value = value;
        this.previous = previous;
        this.next = next;
    }
}
