package quicksort;

import java.util.*;

public class QuickSort {
    public static void main(String[] args) {
        int[] a = new int[50];
        for (int i = 0; i < 50; i++) {
            a[i] = 20 - i;
        }
        a[0] = 6;
        QuickSort quickSort = new QuickSort();
//        quickSort.quickSort(a, 0, a.length - 1);
        quickSort.newQuickSort(a);
//        quickSort.splitList(a,0,a.length - 1);
        for (int i : a) {
            System.out.println("+++" + i);
        }
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


    public void newQuickSort(int[] args) {
        Queue taskQueue = new LinkedList();
        taskQueue.add(splitList(args, 0, args.length - 1));
        while (taskQueue.size() > 0) {
            ArrayList task = (ArrayList) taskQueue.poll();
            int i = (int) task.get(2);
            int start = (int) task.get(1);
            int end = (int) task.get(3);
            if (i - 1 == 0) {
                continue;
            }
            if (i + 1 >= end) {
                continue;
            }
            taskQueue.add(splitList((int[]) task.get(0), start, i - 1));
            taskQueue.add(splitList((int[]) task.get(0), i + 1, end));
        }
    }

    public ArrayList splitList(int[] args, int start, int end) {
        int tmp = args[start];
        int tmp2;
        int i = start;
        int j = end;
        while (i < j) {
            if (args[i + 1] <= tmp) {
                args[i] = args[i + 1];
                args[i + 1] = tmp;
                i++;
            } else {
                tmp2 = args[i + 1];
                args[i + 1] = args[j];
                args[j] = tmp2;
                j--;
            }
        }
        System.out.println(i);
        ArrayList res = new ArrayList();
        res.add(args);
        res.add(start);
        res.add(i);
        res.add(end);
        return res;
    }
}
