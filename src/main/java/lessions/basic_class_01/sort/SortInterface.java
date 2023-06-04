package lessions.basic_class_01.sort;

public interface SortInterface {
    /**
     * bubble the maximum to last
     * @param arr array
     */
    void bubbleSort(int[] arr);

    /**
     * put the minimum to start
     * @param arr array
     */
    void selectSort(int[] arr);

    /**
     * insert item to the sorted array
     * @param arr array
     */
    void insertSort(int[] arr);

    /**
     * set the gap > 1 while insert sorting
     * @param arr array
     */
    void shellSort(int[] arr);

    /**
     * merge two sort array to one
     * @param arr array
     */
    void mergeSort(int[] arr);

    /**
     * partition array to two array, left is less, right is larger
     * @param arr array
     */
    void quickSort(int[] arr);

    /**
     *
     * @param arr array
     */
    void heapSort(int[] arr);
}

