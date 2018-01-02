import java.util.*;

public class Heap {
    private List<Integer> tree;

    public Heap() {
        tree = new ArrayList<>();
    }

    public void offer(int item) {
        tree.add(item);
        siftUp(tree.size() - 1);
    }

    public int poll() {
        int result = tree.get(0);
        tree.set(0, tree.get(tree.size() - 1));
        tree.remove(tree.size() - 1);
        siftDown(0);
        return result;
    }

    public boolean remove(int item) {
        for (int i = 0; i < tree.size(); i++) {
            if (tree.get(i) == item) {
                int tmp = tree.get(tree.size() - 1);
                tree.set(tree.size() - 1, tree.get(i));
                tree.set(i, tmp);
                tree.remove(tree.size() - 1);
                if (i < tree.size()) {
                    siftDown(i);
                    siftUp(i);
                }
                return true;
            }
        }
        return false;
    }

    public int peek() {
        return tree.get(0);
    }

    private void siftUp(int index) {
        while (index != 0) {
            int parent = (index - 1) / 2;
            if (tree.get(parent) > tree.get(index)) {
                int tmp = tree.get(parent);
                tree.set(parent, tree.get(index));
                tree.set(index, tmp);
                index = parent;
            }
            else
                break;
        }
    }

    private void siftDown(int index) {
        while (index < tree.size()) {
            int c1 = index * 2 + 1;
            int c2 = index * 2 + 2;
            if (c1 < tree.size() && c2 < tree.size()) {
                int minIndex;
                if (tree.get(c1) < tree.get(c2))
                    minIndex = c1;
                else
                    minIndex = c2;
                if (tree.get(index) > tree.get(minIndex)) {
                    int tmp = tree.get(minIndex);
                    tree.set(minIndex, tree.get(index));
                    tree.set(index, tmp);
                    index = minIndex;
                }
                else
                    break;
            }
            else if (c1 < tree.size()) {
                if (tree.get(index) > tree.get(c1)) {
                    int tmp = tree.get(c1);
                    tree.set(c1, tree.get(index));
                    tree.set(index, tmp);
                    index = c1;
                }
                else
                    break;
            }
            else
                break;
        }
    }

    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.offer(8);
        heap.offer(3);
        heap.offer(10);
        heap.offer(13);
        heap.offer(2);
        heap.remove(2);
        heap.remove(3);
        heap.remove(10);
        heap.remove(16);
        heap.poll();
        heap.offer(1);
        heap.offer(2);
        heap.remove(1);
        heap.poll();
        heap.poll();
        heap.peek();
        heap.poll();
    }
}

