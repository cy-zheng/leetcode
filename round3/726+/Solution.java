import java.util.*;

class Atom implements Comparable<Atom> {
    String name;
    int num;
    Atom(String name, int num) {
        this.name = name;
        this.num = num;
    }
    
    public int compareTo(Atom other) {
        return this.name.compareTo(other.name);
    }
}

public class Solution {
    public String countOfAtoms(String formula) {
        List<Atom> res = unnest(formula);
        StringBuilder sb = new StringBuilder();
        TreeMap<String, Integer> map = new TreeMap<>();
        for (Atom atom : res) {
            map.put(atom.name, map.getOrDefault(atom.name, 0) + atom.num);
        }
        for (String name : map.keySet()) {
            sb.append(name);
            if (map.get(name) != 1)
                sb.append("" + map.get(name));
        }
        return sb.toString();
    }
    
    private List<Atom> unnest(String s) {
        List<Atom> result = new ArrayList<>();
        Stack<Atom> stack = new Stack<>();
        int index = 0;
        while (index < s.length()) {
            char curr = s.charAt(index);
            if (curr == '(') {
                stack.push(null);
                index += 1;
            }
            else if (curr == ')') {
                int nextIndex = nextNum(s, index + 1), times;
                if (nextIndex == curr + 1)
                    times = 1;
                else
                    times = Integer.parseInt(s.substring(index + 1, nextIndex));
                index = nextIndex;
                List<Atom> tmp = new ArrayList<>();
                while (stack.peek() != null) {
                    tmp.add(stack.pop());
                }
                stack.pop();
                for (Atom atom : tmp) {
                    atom.num *= times;
                    stack.push(atom);
                }
            }
            else {
                while (nextAtom(s, index) != index) {
                    Atom atom = new Atom(s.substring(index, nextAtom(s, index)), 0);
                    index = nextAtom(s, index);
                    if (nextNum(s, index) == index)
                        atom.num = 1;
                    else
                        atom.num = Integer.parseInt(s.substring(index, nextNum(s, index)));
                    index = nextNum(s, index);
                    stack.push(atom);
                }
            }
        }
        while (stack.size() != 0) {
            result.add(stack.pop());
        }
        return result;
    }
    
    private int nextAtom(String s, int start) {
        if (start >= s.length() || s.charAt(start) < 'A' || s.charAt(start) > 'Z')
            return start;
        int i = start + 1;
        while (i < s.length()) {
            if (s.charAt(i) < 'a' || s.charAt(i) > 'z')
                return i;
            i += 1;
        }
        return i;
    } 
    
    private int nextNum(String s, int start) {
        int i = start;
        while (i < s.length()) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                return i;
            }
            i += 1;
        }
        return i;
    }
}
