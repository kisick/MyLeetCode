package lcof_30;

import com.sun.tools.javac.Main;

import java.util.Stack;

/**
 * @author: gefeng
 * @created: 2021/05/11 01:35
 */
public class offer30 {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        //返回 -3.
        System.out.println(minStack.min());
        minStack.pop();
        //返回 0.
        System.out.println(minStack.top());
        // 返回 -2.
        System.out.println(minStack.min());

    }
}


/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *
 * O(1) 说明不需要遍历 说明min这个值是维护的一个属性。
 */
class MinStack {

    /**
     * 栈 后进先出
     * 用链表来实现栈 每次添加的元素都置为链表的头节点
     * 每次入栈的同时，都保存一份当前的最小值
     * 这样在移除栈顶元素后，依然可以找到最小值
     */
    private Node head;

    /** initialize your data structure here. */
    public MinStack() {
    }

    public void push(int x) {
        if (head == null) {
            head = new Node(x, x, null);
        } else {
            head = new Node(x, Math.min(x, head.min), head);
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
       return head.val;
    }

    public int min() {
        return head.min;
    }

    private class Node {
        private int val;
        private int min;
        private Node next;

        Node (int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
