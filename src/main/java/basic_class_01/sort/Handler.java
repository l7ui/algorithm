package basic_class_01.sort;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Handler implements InvocationHandler {
    private Object object;
    private int testTime;
    private int size;
    private int maxValue;
    private Comparator comparator;

    public Handler(Object object, int testTime, int size, int value) {
        this.object = object;
        this.testTime = testTime;
        this.size = size;
        this.maxValue = value;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        comparator = new Comparator();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < testTime; i++) {
            System.out.print("\r" + (i+1.0)/ testTime * 100 + "%");
            int[] arr1 = comparator.generateRandomArray(size, maxValue);
            int[] arr2 = arr1.clone();
            int[] arr3 = arr1.clone();
            comparator.rightMethod(arr2);
            method.invoke(object, arr3);
            boolean comparaResult = comparator.isEqual(arr2, arr3);
            if (!comparaResult) {
                System.out.println("\n----------------------------");
                System.out.println("Method: " + method.getName());
                System.out.println("error-");
                System.out.println(Arrays.toString(arr1));
                System.out.println(Arrays.toString(arr2));
                System.out.println(Arrays.toString(arr3));
                System.exit(-1);
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("\r----------------------------");
        System.out.println("\rMethod: " + method.getName());
        System.out.println("\rRuntime: " + (endTime-startTime)/1000.0 + "s");
        return null;
    }
}
