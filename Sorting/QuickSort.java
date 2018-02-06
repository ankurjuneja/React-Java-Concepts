import java.util.Arrays;

public class QuickSort {

    private int partition(int [] array, int low, int high)
    {
        int largest = array[high];
        int i = low - 1 ; // i to keep track of smaller element

        for (int j = low; j < high; j++)
        {
            if (array[j] <= largest)
            {
                i++;
                //exchange array[i] and array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp ;
            }
        }

        //exchange last smaller element with pivot
        int temp = array[i+1];
        array[i+1] = array[high];
        array[high] = temp;

        return i+1;
    }
    public void quickSort(int[] array, int low, int high)
    {
        if (low < high)
        {
            int pivot = partition(array,low,high); //pivot is the partitioning index

            //recursive sort two sub arrays around pivot
            quickSort(array,low, pivot-1);
            quickSort(array,pivot+1,high);

        }

    }

    public void printSortedArray(int[] array) {
        Arrays.stream(array)
                .forEach(num-> System.out.print(" "+num));
    }

    public static void main(String[] args) {
        int[] arr = {16,8,7,3,1,9,4};
        QuickSort qs = new QuickSort();
        qs.quickSort(arr,0,arr.length-1);
        qs.printSortedArray(arr);
    }
}
