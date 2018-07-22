import java.util.*;

class ExamRoom {
    int N;
    ArrayList<Integer> L = new ArrayList<>();
    public ExamRoom(int n) {
        N = n;
    }

    public int seat() {
        // 没有其他人，先返回0
        if (L.size() == 0) {
            L.add(0);
            return 0;
        }
        // d为首部间隔和尾部间隔最大值
        int d = Math.max(L.get(0), N - 1 - L.get(L.size() - 1));
        // 和中间的各个间隔比较
        for (int i = 0; i < L.size() - 1; ++i) 
            d = Math.max(d, (L.get(i + 1) - L.get(i)) / 2);
        // 如果等于首部间隔，返回0
        if (L.get(0) == d) {
            L.add(0, 0);
            return 0;
        }
        // 如果等于中间某个间隔，在该间隔中点插入元素
        for (int i = 0; i < L.size() - 1; ++i)
            if ((L.get(i + 1) - L.get(i)) / 2 == d) {
                L.add(i + 1, (L.get(i + 1) + L.get(i)) / 2);
                return L.get(i + 1);
            }
        // 否则则插入到尾部间隔
        L.add(N - 1);
        return N - 1;
    }

    public void leave(int p) {
        for (int i = 0; i < L.size(); ++i) if (L.get(i) == p) 
            L.remove(i);
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(N);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */
