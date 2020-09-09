package leetcode.p232;

import java.util.Stack;

/**
 * 使用栈实现队列
 */
public class MyQueue {
    private Stack<Integer> s1;
    private Stack<Integer> s2;
    private int size = 0;

    /** Initialize your data structure here. */
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
        size = 0;
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.push(x);
        size++;
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        size--;
        return s2.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return size == 0;
    }
}
