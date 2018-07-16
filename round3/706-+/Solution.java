class HashItem {
    int key, val;
    HashItem next;
    HashItem(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

public class MyHashMap {
    
    private HashItem[] list;
    private int size;

    /** Initialize your data structure here. */
    public MyHashMap() {
        list = new HashItem[16];
    }
    
    /** value will always be positive. */
    public void put(int key, int value) {
        int hash = key % list.length;
        if (list[hash] == null) {
            list[hash] = new HashItem(key, value);
        }
        else if (list[hash].key == key) {
            list[hash].val = value;
        }
        else {
            HashItem curr = list[hash];
            while (curr.next != null && curr.next.key != key) 
                curr = curr.next;
            if (curr.next != null) 
                curr.next.val = value;
            else
                curr.next = new HashItem(key, value);
        }
        size += 1;
        if (size * 1.0 / list.length > 0.8) {
            rehash();
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hash = key % list.length;
        HashItem curr = list[hash];
        while (curr != null) {
            if (curr.key == key)
                return curr.val;
            curr = curr.next;
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hash = key % list.length;
        if (list[hash] == null) {
            return;
        }
        else if (list[hash].key == key) {
            list[hash] = list[hash].next;
        }
        else {
            HashItem curr = list[hash];
            while (curr.next != null && curr.next.key != key) 
                curr = curr.next;
            if (curr.next != null) 
                curr.next = curr.next.next;
        }
    }
    
    private void rehash() {
        HashItem[] oldList = list;
        list = new HashItem[list.length * 2];
        for (int i = 0; i < oldList.length; i++) {
            HashItem curr = oldList[i];
            while (curr != null) {
                put(curr.key, curr.val);
                curr = curr.next;
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
