package Sorting;

public interface Sorting {
    int[] sort(int[] arr);
}

class QuickSort implements Sorting {

    @Override
    public int[] sort(int[] arr) {
        qSort(arr, 0, arr.length-1);
        return arr;
    }

    private void qSort(int[] arr, int low, int high) {
        if (low < high) {
			/* pi is partitioning index, arr[pi] is
			now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            qSort(arr, low, pi-1);
            qSort(arr, pi+1, high);
        }
    }

    private int partition(int[] arr, int left, int high) {
        int pivot = arr[high];
        int i = left - 1;
        for (int j = left; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;

                // swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap pivot
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return  i+1;
    }
}

class Sorter {
    public static void main(String[] args) {
        Sorting quickSort = new QuickSort();
        quickSort.sort(new int[]{4,1,5});
    }
}
