import java.util.*;

class Solution {

    private ArrayList<Integer> preResult = new ArrayList<>();
    private ArrayList<Integer> postResult = new ArrayList<>();

    public int[][] solution(int[][] nodeinfo) {

        ArrayList<Node> nodes = new ArrayList<>();
        for (int i = 0; i < nodeinfo.length; i++) {
            nodes.add(new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]));
        }

        nodes.sort((n1, n2) -> {
            if (n1.y == n2.y)
                return n1.x - n2.x;
            return n2.y - n1.y;
        });

        Node root = nodes.get(0);

        for (int i = 1; i < nodes.size(); i++) {
            root.addChild(nodes.get(i));
        }

        preorder(root);
        postorder(root);

        int[] preR = new int[nodeinfo.length];
        int[] postR = new int[nodeinfo.length];

        for (int i = 0; i < nodeinfo.length; i++) {
            preR[i] = preResult.get(i);
            postR[i] = postResult.get(i);
        }

        return new int[][] { preR, postR };
    }

    private void preorder(Node now) {
        preResult.add(now.idx);
        if (now.left != null)
            preorder(now.left);
        if (now.right != null)
            preorder(now.right);
    }

    private void postorder(Node now) {
        if (now.left != null)
            postorder(now.left);
        if (now.right != null)
            postorder(now.right);
        postResult.add(now.idx);
    }

    static class Node {
        int idx, x, y;
        Node left;
        Node right;

        public Node(int idx, int x, int y) {
            this.idx = idx;
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return "[ idx: " + idx + ", x: " + x + ", y: " + y + "]";
        }

        public void addChild(Node child) {
            if (child == null)
                return;

            Node curr = this;
            Node next = curr.x > child.x ? curr.left : curr.right;

            while (curr != null && next != null) {

                curr = next;
                next = curr.x > child.x ? curr.left : curr.right;
            }

            if (curr.x > child.x)
                curr.left = child;
            else
                curr.right = child;

        }
    }
}