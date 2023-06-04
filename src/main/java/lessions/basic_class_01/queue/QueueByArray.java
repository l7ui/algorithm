package lessions.basic_class_01.queue;

public class QueueByArray {
    private int[] arr;
    private int head;
    private int tail;
    private int size;

    public QueueByArray(int initialsize) {
        arr = new int[initialsize];
        head = 0;
        tail = 0;
        size = 0;
    }

    public void add(int value) {
        if (size == arr.length) {
            throw new RuntimeException("queue is full!");
        }
        size++;
        arr[tail] = value;
        tail = (tail == arr.length - 1) ? 0 : tail + 1;
    }

    public int peek() {
        if (size == 0) {
            throw new RuntimeException("queue is empty!");
        }
        return arr[head];
    }

    public int poll() {
        if (size == 0) {
            throw new RuntimeException("queue is empty!");
        }
        size--;
        int res = arr[head];
        head = (head == arr.length - 1) ? 0 : head + 1;
        return res;
    }
}
