package lcof_36;

/**
 * @author: gefeng
 * @created: 2021/05/30 15:28
 */
public class offer36 {
    public static void main(String[] args) {
//        Node root = new Node(4);
//        root.left = new Node(2);
//        root.right = new Node(5);
//        root.left.left = new Node(1);
//        root.left.right = new Node(3);
        Node root = new Node(8);
        root.left = new Node(-6);
        root.left.left = new Node(-8);
        Solution solution = new Solution();
        Node node = solution.treeToDoublyList(root);
    }
}

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。
 * 要求不能创建任何新的节点，只能调整树中节点指针的指向。
 */
class Solution {
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return root;
        }
        Node head = recursion(root);
        Node tail = head;
        while (tail.right != null) {
            tail = tail.right;
        }
        head.left = tail;
        tail.right = head;
        return head;
    }

    public Node recursion(Node root) {
        if (root == null) {
            return null;
        }
        Node left = root.left;
        Node right = root.right;
        if (left != null) {
            Node head = recursion(left);
            while (head.right != null) {
                head = head.right;
            }
            head.right = root;
            root.left = head;
        }
        if (right != null) {
            Node head = recursion(right);
            while (head.left != null) {
                head = head.left;
            }
            head.left = root;
            root.right = head;
        }
        if (left == null) {
            return root;
        }
        while (left.left != null) {
            left = left.left;
        }
        return left;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}
