package lesson1.sort;


public class Sort implements SortInterface {

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @Override
    public void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        boolean hasSorted = true;
        for (int i = arr.length-1; i > 0 && hasSorted; i--) {
            hasSorted = false;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j+1]) {
                    swap(arr, j, j+1);
                    hasSorted = true;
                }
            }
        }
    }

    @Override
    public void selectSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int index = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    index = j;
                }
            }
            swap(arr, index, i);
        }
    }

    @Override
    public void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j-1]; j--) {
                swap(arr,j, j-1);
            }
        }
    }

    @Override
    public void shellSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int h = 1, gap = 2;
        while (h < arr.length / gap) {
            h = h * gap + 1;
        }

        while (h >= 1) {
            for (int i = h; i < arr.length; i+=h) {
                for (int j = i; j > 0 && arr[j-h] > arr[j]; j-=h) {
                    swap(arr, j-h, j);
                }
            }
            h /= gap;
        }
    }

    @Override
    public void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        mergeProcess(arr,0, arr.length-1);
    }
    private void merge(int[] arr, int l, int m, int h) {
        int[] copy = new int[h-l+1];
        int p1 = l, p2 = m+1;
        int i = 0;

        while (p1 <= m && p2 <= h) {
            copy[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= m) {
            copy[i++] = arr[p1++];
        }
        while (p2 <= h) {
            copy[i++] = arr[p2++];
        }

        for (int j = 0; j < copy.length; j++) {
            arr[l+j] = copy[j];
        }
    }
    private void mergeProcess(int[] arr, int l, int h) {
        if (l >= h) {
            return;
        }

        int m = l + ((h - l) >> 1);
        mergeProcess(arr, l, m);
        mergeProcess(arr, m+1, h);
        merge(arr, l, m, h);
    }

    @Override
    public void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        quickProcess(arr, 0, arr.length-1);
    }
    private int partition(int[] arr, int l, int h) {
        int i = l, j = h;
        int x = arr[i];

        while (i < j) {
            while (i < j && arr[j] >= x) {
                j--;
            }
            if (i < j) {
                arr[i] = arr[j];
                i++;
            }
            while (i < j && arr[i] <= x) {
                i++;
            }
            if (i < j) {
                arr[j] = arr[i];
                j--;
            }
        }

        arr[i] = x;
        return i;
    }
    private void quickProcess(int[] arr, int l, int h) {
        if (l >= h) {
            return;
        }

        int i = partition(arr, l, h);
        quickProcess(arr, l, i);
        quickProcess(arr, i+1, h);
    }

    @Override
    public void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }

        int heapSize = arr.length;
        while (heapSize > 0) {
            heapSize--;
            swap(arr, 0, heapSize);
            heapify(arr, 0, heapSize);
        }
    }
    private void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int largerIndex = left + 1 < heapSize && arr[left + 1] > arr[left]
                    ? left + 1
                    : left;
            if (arr[index] >= arr[largerIndex]) {
                break;
            }
            swap(arr, index, largerIndex);
            index = largerIndex;
            left = index * 2 + 1;
        }
    }
}
