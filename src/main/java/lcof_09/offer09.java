package lcof_09;

import java.util.Stack;


/**
 * @author: gefeng
 * @created: 2021/04/11 15:26
 */
public class offer09 {
    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        cQueue.appendTail(11);
        System.out.println(cQueue.deleteHead());
        cQueue.appendTail(1);
        cQueue.appendTail(17);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        cQueue.appendTail(19);
        cQueue.appendTail(20);
        cQueue.appendTail(13);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        cQueue.appendTail(12);
        cQueue.appendTail(3);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        cQueue.appendTail(10);
        cQueue.appendTail(19);
        System.out.println(cQueue.deleteHead());
    }
}


/**
 * 用两个栈实现一个队列。
 * 队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。
 * (若队列中没有元素，deleteHead操作返回 -1 )
 *
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 *
 */
class CQueue {
    private Stack<Integer> addStack;
    private Stack<Integer> deleteStack;
    public CQueue() {
        addStack = new Stack<>();
        deleteStack = new Stack<>();
    }

    public void appendTail(int value) {
        addStack.add(value);
    }

    public int deleteHead() {
        if (!deleteStack.isEmpty()) {
            return deleteStack.pop();
        } else {
            while (!addStack.isEmpty()) {
                deleteStack.add(addStack.pop());
            }
            if (!deleteStack.isEmpty()) {
                return deleteStack.pop();
            }
        }
        return -1;
    }
}
/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
