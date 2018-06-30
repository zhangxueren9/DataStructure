package quicksort;

public class QuickSort {
    public static void main(String[] args) {
        int[] a = new int[100000];
        for(int i = 0; i < 100000; i++){
            a[i] = i % 10;
        }

        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(a, 0, a.length - 1);
        for (int i : a)
            System.out.println(i);
        System.out.println(a.length);
    }
    public void quickSort(int[] args, int start, int end) {
        int stNum = args[start];
        int tmp;
        int i = start;
        int j = end;
        if (start >= end)
            return;
        while (i < j) {
            if (args[i + 1] <= stNum) {
                args[i] = args[i + 1];
                args[i + 1] = stNum;
                i++;
            } else {
                tmp = args[i + 1];
                args[i + 1] = args[j];
                args[j] = tmp;
                j--;
            }
        }
        if ((i - 1) > start) {
            quickSort(args, start, i - 1);
        }
        if ((i + 1) < end) {
            quickSort(args, i + 1, end);
        }
    }
}
