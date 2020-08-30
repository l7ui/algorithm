package leetcode.p146;

import java.util.HashMap;

public class LRUCache2 {
    private class LinkedNode {
        private int key;
        private int value;
        LinkedNode pre;
        LinkedNode next;
        public LinkedNode() {

        }
        public LinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private int size;
    // 引入伪头尾方便操作
    private LinkedNode head;
    private LinkedNode tail;
    HashMap<Integer, LinkedNode> cache;

    public LRUCache2(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
        head = new LinkedNode();
        tail = new LinkedNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        LinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        LinkedNode node = cache.get(key);
        // key不存在
        if (node == null) {
            LinkedNode newNode = new LinkedNode(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            size++;
            if (size > capacity) {
                LinkedNode eldest = removeTail(tail.pre);
                cache.remove(eldest.key);
                size--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    public void moveToHead(LinkedNode node) {
        removeNode(node);
        addToHead(node);
    }
    public void removeNode(LinkedNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
    public void addToHead(LinkedNode node) {
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;
    }
    public LinkedNode removeTail(LinkedNode node) {
        LinkedNode tmp = tail.pre;
        removeNode(tmp);
        return tmp;
    }
}
