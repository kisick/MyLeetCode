package lcof_35;


import sun.misc.Unsafe;

import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.locks.LockSupport;

/**
 * @author: gefeng
 * @created: 2021/05/25 00:50
 */
public class offer35 {
    public static void main(String[] args) {
        Node head = new Node(7);
        head.next = new Node(13);
        head.next.next = new Node(11);
        head.next.next.next = new Node(10);
        head.next.next.next.next = new Node(1);
        head.next.random = head;
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head;


        Solution solution = new Solution();
        Node node = solution.copyRandomList(head);
    }
}

/**
 * 请实现 copyRandomList 函数，复制一个复杂链表。
 * 在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 *
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 *
 */
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        while (cur != null) {
            Node tmp = new Node(cur.val);
            Node next = cur.next;
            cur.next = tmp;
            tmp.next = next;
            cur = next;
        }
        cur = head;
        while (cur != null) {
            Node random = cur.random;
            if (random != null) {
                cur.next.random = random.next;
            }
            cur = cur.next.next;
        }
        cur = head;
        Node res = new Node(-1);
        Node res_dummy = res;
        while (cur != null) {
            res_dummy.next = cur.next;
            cur.next = cur.next.next;
            res_dummy = res_dummy.next;
            cur = cur.next;
        }
        return res.next;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
