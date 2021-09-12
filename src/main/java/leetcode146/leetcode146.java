package leetcode146;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: gefeng
 * @created: 2021/07/06 23:24
 */
public class leetcode146 {
    public static void main(String[] args) {

        //["LRUCache","put","put","get","get","put","get","get","get"]
        //[2],[2,1],[3,2],[3],[2],[4,3],[2],[3],[4]
        //[null,null,null,2,1,null,1,-1,3]
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2,1);
        lruCache.put(3,2);
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(2));
        lruCache.put(4,3);
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));




//        LRUCache lruCache = new LRUCache(2);
//        lruCache.put(1,1);
//        lruCache.put(2,2);
//        System.out.println(lruCache.get(1));
//        lruCache.put(3,3);
//        System.out.println(lruCache.get(2));
//        lruCache.put(4,4);
//        System.out.println(lruCache.get(1));
//        System.out.println(lruCache.get(3));
//        System.out.println(lruCache.get(4));
    }
}
class LRUCache {

    // 一个双向链表，最新使用的放在尾部，将要删除的放在头部
    static class ListNode {
        public int val;
        public int key;
        public ListNode next;
        public ListNode pre;
        public ListNode(int val,int key) {
            this.val = val;
            this.key = key;
        }
    }

    private void removeNode(ListNode removeThis) {
        if (removeThis == head) {
            removeHead();
        } else if (removeThis == tail) {
            removeTail();
        } else {
            removeThis.pre.next = removeThis.next;
            removeThis.next.pre = removeThis.pre;
        }
    }

    private void addToTail(ListNode listNode) {
        tail.next = listNode;
        listNode.pre = tail;
        listNode.next = head;
        head.pre = listNode;
        tail = listNode;
    }

    private void removeHead() {
        head.next.pre = tail;
        tail.next = head.next;
        head = head.next;
    }

    private void removeTail() {
        head.pre = tail.pre;
        tail.pre.next = head;
        tail = tail.pre;
    }

    private int capacity;
    // key,(value,count)
    // 最新使用的key放在尾部，将要删除的key放在头部
    // hashMap用来O(1)的查找，但是不能存储顺序
    // 所以搞个链表来保存数据，map用来查找链表中的节点
    private Map<Integer, ListNode> cache = new HashMap<>();
    private ListNode head;
    private ListNode tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (cache.get(key) != null) {
            // 更新这个key的位置
            ListNode listNode = cache.get(key);
            // 删除该节点
            removeNode(listNode);
            // 将该节点加到表尾
            addToTail(listNode);
            return cache.get(key).val;
        }
        return -1;
    }

    public void put(int key, int value) {

        if (cache.get(key) != null) {
            // 更新这个key的位置
            ListNode listNode = cache.get(key);
            listNode.val = value;
            // 删除该节点
            removeNode(listNode);
            // 将该节点加到表尾
            addToTail(listNode);

            cache.put(key,listNode);
        } else {
            ListNode listNode = new ListNode(value,key);
            if (cache.size() < capacity) {
                if (cache.isEmpty()) {
                    head = listNode;
                    tail = listNode;
                    head.next = tail;
                    head.pre = tail;
                } else {
                    // 将该节点加到表尾
                    addToTail(listNode);
                }
            } else {
                // 从map中删除表头
                cache.remove(head.key);
                // 删除链表中的表头
                removeHead();
                // 将该节点加到表尾
                addToTail(listNode);
            }
            cache.put(key,listNode);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
