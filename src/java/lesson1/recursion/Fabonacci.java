package lesson1.recursion;

public class Fabonacci {
    public static void main(String[] args) {
        System.out.println(cal(5));
    }

    private static int cal(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return cal(n - 1) + cal(n - 2);
    }
}
