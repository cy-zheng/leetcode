class HashItem {
    int val;
    HashItem next;
    HashItem(int val) {
        this.val = val;
    }
}

public class MyHashSet {
    
    private HashItem[] list;
    private int size;

    /** Initialize your data structure here. */
    public MyHashSet() {
        list = new HashItem[16];
    }
    
    public void add(int key) {
        if (contains(key))
            return;
        int hash = key % list.length;
        if (list[hash] == null) {
            list[hash] = new HashItem(key);
        }
        else {
            HashItem next = list[hash];
            list[hash] = new HashItem(key);
            list[hash].next = next;
        }
        size += 1;
        if (size * 1.0 / list.length > 0.8) {
            rehash();
        }
    }
    
    public void remove(int key) {
        int hash = key % list.length;
        if (list[hash] == null)
            return;
        if (list[hash].val == key) {
            list[hash] = list[hash].next;
        } 
        else {
            HashItem curr = list[hash];
            while (curr.next != null) {
                if (curr.next.val == key) {
                    curr.next = curr.next.next;
                    break;
                }
                curr = curr.next;
            }
        }
    }
    
    /** Returns true if this set did not already contain the specified element */
    public boolean contains(int key) {
        int hash = key % list.length;
        HashItem curr = list[hash];
        while (curr != null) {
            if (curr.val == key)
                return true;
            curr = curr.next;
        }
        return false;
    }
    
    private void rehash() {
        HashItem[] oldList = list;
        list = new HashItem[list.length * 2];
        for (int i = 0; i < oldList.length; i++) {
            HashItem curr = oldList[i];
            while (curr != null) {
                add(curr.val);
                curr = curr.next;
            }
        }
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
