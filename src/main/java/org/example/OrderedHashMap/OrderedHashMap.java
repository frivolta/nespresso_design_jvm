package org.example.OrderedHashMap;

public class OrderedHashMap<K,V>{
    Entry<K,V> orderedHashMap;
    public OrderedHashMap(K key, V value){
      this.orderedHashMap = new Entry<K, V>(key, value, null, null);
    }

    public V getLast(){
        if(orderedHashMap==null){
            return null;
        }
        Entry<K, V> current = orderedHashMap;

        while(current.next!=null){
            current=current.next;
        }
        return current.value;
    }

    public V getFirst(){
        if(orderedHashMap==null){
            return null;
        }
        return orderedHashMap.value;
    }

    public void remove(K key) {
        if (orderedHashMap == null) {
            return; // List is empty
        }

        Entry<K, V> current = orderedHashMap;

        while (current != null) {
            if (current.key.equals(key)) {
                // Found the key, now remove the entry

                if (current.previous != null) {
                    current.previous.next = current.next;
                } else {
                    // Removing the head of the list
                    orderedHashMap = current.next;
                }

                if (current.next != null) {
                    current.next.previous = current.previous;
                }
                // Optionally, clear the current entry's next and previous to help GC
                current.next = null;
                current.previous = null;
                return;
            }
            current = current.next;
        }
    }



    public Integer size(){
        if (orderedHashMap == null) {
            return 0;
        }
        int count=0;
        Entry<K, V> current = orderedHashMap;
        while(current.next!=null){
            count+=1;
            current=current.next;
        }
        return count+1;
    }

    public void put(K key, V value){
        if (orderedHashMap == null) {
            orderedHashMap = new Entry<>(key, value, null, null);
            return;
        }

        Entry<K, V> current = orderedHashMap;
        while (current.next != null) {
            if (key.equals(current.key)) {
                current.value = value;
                return;
            }
            current = current.next;
        }

        // Handle the last element separately
        if (key.equals(current.key)) {
            current.value = value;
        } else {
            current.next = new Entry<>(key, value, current, null);
        }
    }
}
