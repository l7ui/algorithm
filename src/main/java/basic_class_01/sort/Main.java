package basic_class_01.sort;

import java.lang.reflect.Proxy;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        SortInterface sort = new Sort();
        Handler handler = new Handler(sort, 100, 100000,100);
        SortInterface proxy = (SortInterface)Proxy.newProxyInstance(sort.getClass().getClassLoader(), sort.getClass().getInterfaces(), handler);
        ExecutorService service = Executors.newFixedThreadPool(10);
        service.execute(() -> proxy.bubbleSort(null));
        service.execute(() -> proxy.selectSort(null));
        service.execute(() -> proxy.insertSort(null));
        service.execute(() -> proxy.shellSort(null));
        service.execute(() -> proxy.mergeSort(null));
        service.execute(() -> proxy.quickSort(null));
        service.execute(() -> proxy.heapSort(null));
        service.shutdown();
    }
}
