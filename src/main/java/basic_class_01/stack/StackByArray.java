package basic_class_01.stack;

public class StackByArray {
    private int[] arr;
    private int index;

    public StackByArray(int initalSize) {
        if (initalSize < 0) {
            throw new RuntimeException("initialSize can not less than 0!");
        }
        arr = new int[initalSize];
        index = 0;
    }

    public void push(int value) {
        if (index == arr.length) {
            throw new RuntimeException("stack is full!");
        }
        arr[index++] = value;
    }

    public int peek() {
        if (index == 0) {
            throw new RuntimeException("stack is empty!");
        }
        return arr[index - 1];
    }

    public int pop() {
        if (index == 0) {
            throw new RuntimeException("stack is empty!");
        }
        return arr[--index];
    }
}
