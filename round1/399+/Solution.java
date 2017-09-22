/*
    把化简除法想成graph
*/

import java.util.*;

class Solution {
    
    class Node {
        String name;
        Map<String, Pair> children;
        public Node(String name) {
            this.name = name;
            this.children = new HashMap<>();
        }
    }
    
    class Pair {
        Node node;
        double d;
        public Pair(Node node, double d) {
            this.node = node;
            this.d = d;
        }
    }
    
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        if (equations == null || equations.length == 0 || equations[0].length == 0)
            return new double[0];
        
        Map<String, Node> map = createMap(equations, values);
        double[] result = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (!map.containsKey(queries[i][0]) || !map.containsKey(queries[i][1]))
                result[i] = -1;
            else if (queries[i][0].equals(queries[i][1])) 
                result[i] = 1;
            else
                result[i] = findResult(map.get(queries[i][0]), map.get(queries[i][1]));
        }
        return result;
    }
    
    private Map<String, Node> createMap(String[][] equations, double[] values) {
        Map<String, Node> map = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            if (!map.containsKey(equations[i][0])) {
                map.put(equations[i][0], new Node(equations[i][0]));
            }
            if (!map.containsKey(equations[i][1])) {
                map.put(equations[i][1], new Node(equations[i][1]));
            }
            
            map.get(equations[i][0]).children.put(equations[i][1], new Pair(map.get(equations[i][1]), values[i]));
            map.get(equations[i][1]).children.put(equations[i][0], new Pair(map.get(equations[i][0]), 1 / values[i]));
        }
        return map;
    }
    
    private double findResult(Node start, Node end) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(start, 1));
        Set<String> visited = new HashSet<>();
        visited.add(start.name);
        
        while (queue.size() != 0) {
            Pair curr = queue.poll();
            for (String key : curr.node.children.keySet()) {
                if (key.equals(end.name)) {
                    return curr.d * curr.node.children.get(key).d;
                }
                if (!visited.contains(key)) {
                    visited.add(key);
                    queue.add(new Pair(curr.node.children.get(key).node, curr.d * curr.node.children.get(key).d));
                }
            }
        }
        
        return -1;
    }
    
    
}