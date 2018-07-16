/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Codec {

    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if (root == null)
            return "";
        String result = Integer.toString(root.val);
        for (Node c : root.children) {
            result += "[" + serialize(c) + "]";
        }
        return result;
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if (data.length() == 0)
            return null;
        int index = 0;
        for (int i = 0; i < data.length(); i++) {
            if (data.charAt(i) != '[' && data.charAt(i) != ']') {
                index = i;
            }
            else
                break;
        }
        index += 1;
        Node result = new Node(Integer.parseInt(data.substring(0, index)), new ArrayList<>());
        int leftCount = 0;
        for (int i = index; i < data.length(); i++) {
            if (data.charAt(i) == '[') {
                leftCount += 1;
            }
            else if (data.charAt(i) == ']') {
                leftCount -= 1;
                if (leftCount == 0) {
                    result.children.add(deserialize(data.substring(index + 1, i)));
                    index = i + 1;
                }
            }
        }
        return result;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
