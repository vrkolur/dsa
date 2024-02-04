package Sorting;

public class Quick_Sort_Abdul {

    private void swap(int i, int j, int[] a) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private int partition(int l, int h, int[] a) {
        int pivot = a[l];
        int i = l, j = h;
        while (i<j) {
            do {
                i++;
            } while (a[i] <= pivot);
            do {
                j--;
            } while (a[j] > pivot);
            if (i < j) {
                swap(i, j, a);
            }
        }
        swap(l, j, a);
        return j;
    }

    private void QuickSort(int l, int h, int[] a) {
        if (l < h) {
            int j = partition(l, h, a);
            QuickSort(l, j, a);
            QuickSort(j + 1, h, a);
        }
    }

    public static void main(String[] args) {
        Quick_Sort_Abdul ob=new Quick_Sort_Abdul();
        int[] a = { 12, 4, 7, 3, 17, 9, 0, 2,99999 };
        ob.QuickSort(0,a.length-1,a);
        for(int num:a){
            System.out.print(num+" ");
        }
    }
}
