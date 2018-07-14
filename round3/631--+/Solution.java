import java.util.*;

public class Excel {

    class Func {
        private int row;
        private char col;
        private String[] areas;

        public Func(int row, char col, String[] areas) {
            this.row = row;
            this.col = col;
            this.areas = areas;
        }

        public void doAction() {
            int sum = 0;
            for (String area : areas) {
                if (area.indexOf(":") == -1) {
                    sum += table[Integer.parseInt(area.substring(1, area.length())) - 1][area.charAt(0) - 'A'];
                }
                else {
                    String[] segs = area.split(":");
                    int row1 = Integer.parseInt(segs[0].substring(1, segs[0].length())) - 1;
                    int col1 = segs[0].charAt(0) - 'A';
                    int row2 = Integer.parseInt(segs[1].substring(1, segs[1].length())) - 1;
                    int col2 = segs[1].charAt(0) - 'A';
                    for (int i = row1; i <= row2; i++) {
                        for (int j = col1; j <= col2; j++) {
                            sum += table[i][j];
                        }
                    }
                }
            }
            table[row - 1][col - 'A'] = sum;
            for (Func func : listener.getOrDefault("" + col + row, new ArrayList<>())) {
                func.doAction();
            }
        }
    }

    private int[][] table;
    // 单元格影响的func
    private Map<String, List<Func>> listener;
    // 单元格注册的func
    private Map<String, Func> funcMap;

    public Excel(int H, char W) {
        funcMap = new HashMap<>();
        listener = new HashMap<>();
        table = new int[H][W - 'A' + 1];
    }

    private void _resetListener(String key, int r, char c) {
        for (int i = listener.getOrDefault(key, new ArrayList<>()).size() - 1; i >= 0; i--) {
            Func func = listener.get(key).get(i);
            if (func.row == r && func.col == c) {
                listener.get(key).remove(i);
            }
        }
    }

    private void resetListener(int r, char c) {
        // 解除注册的Func
        if (funcMap.containsKey("" + c + r)) {
            Func func = funcMap.remove("" + c + r);
            // 解除注册Func的listener
            for (String area : func.areas) {
                if (!area.contains(":")) {
                    String key = "" + area.charAt(0) + Integer.parseInt(area.substring(1, area.length()));
                    _resetListener(key, r, c);
                }
                else {
                    String[] segs = area.split(":");
                    int row1 = Integer.parseInt(segs[0].substring(1, segs[0].length()));
                    char col1 = segs[0].charAt(0);
                    int row2 = Integer.parseInt(segs[1].substring(1, segs[1].length()));
                    char col2 = segs[1].charAt(0);
                    for (char i = col1; i <= col2; i++) {
                        for (int j = row1; j <= row2; j++) {
                            _resetListener("" + i + j, r, c);
                        }
                    }
                }
            }
        }
    }

    private void setListener(Func func) {
        String[] areas = func.areas;
        for (String area : areas) {
            if (!area.contains(":")) {
                String key = "" + area.charAt(0) + Integer.parseInt(area.substring(1, area.length()));
                if (!listener.containsKey(key))
                    listener.put(key, new ArrayList<>());
                listener.get(key).add(func);
            }
            else {
                String[] segs = area.split(":");
                int row1 = Integer.parseInt(segs[0].substring(1, segs[0].length()));
                char col1 = segs[0].charAt(0);
                int row2 = Integer.parseInt(segs[1].substring(1, segs[1].length()));
                char col2 = segs[1].charAt(0);
                for (char i = col1; i <= col2; i++) {
                    for (int j = row1; j <= row2; j++) {
                        String key = "" + i + j;
                        if (!listener.containsKey(key))
                            listener.put(key, new ArrayList<>());
                        listener.get(key).add(func);
                    }
                }
            }
        }
    }

    public void set(int r, char c, int v) {
        // reset listener
        resetListener(r, c);
        // 设置值
        table[r - 1][c - 'A'] = v;
        // 影响其他的单元格
        for (Func func : listener.getOrDefault("" + c + r, new ArrayList<>())) {
            func.doAction();
        }
    }

    public int get(int r, char c) {
        return table[r - 1][c - 'A'];
    }

    public int sum(int r, char c, String[] strs) {
        // reset listener
        resetListener(r, c);
        // 生成func对象
        Func func = new Func(r, c, strs);
        // 注册func
        funcMap.put("" + c + r, func);
        // 绑定listener
        setListener(func);
        // doAction
        func.doAction();
        return table[r - 1][c - 'A'];
    }

    public static void main(String[] args) {
        Excel excel = new Excel(5, 'E');
        excel.set(1, 'A', 1);
        excel.sum(2, 'B', new String[] {"A1"});
        excel.set(2, 'B', 0);
        excel.get(2, 'B');
        excel.set(1, 'A', 5);
        excel.get(2, 'B');
    }
}

/**
 * Your Excel object will be instantiated and called as such:
 * Excel obj = new Excel(H, W);
 * obj.set(r,c,v);
 * int param_2 = obj.get(r,c);
 * int param_3 = obj.sum(r,c,strs);
 */
