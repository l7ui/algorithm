package test;

public class Test {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node x = null;
        Node y = new Node(3);
        n1.next = x;
        n2.next = y;
        x = new Node(4);
        y = new Node(5);
        System.out.println(n2.next.val);
        System.out.println(n1.next.val);
    }
}
