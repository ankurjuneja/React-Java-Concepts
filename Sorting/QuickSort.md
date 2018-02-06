## QuickSort

It is a divide and conquer algorithm for sorting.It is in-place sorting having O(N Log N) on the average.

works by partitioning the input array into two parts, then sorting the parts independently

partitioning process is most important - this process permutes the array so that following conditions hold

    * the element a[pivot] is in final place for some pivot
    * No element in a[start] through a[pivot-1] is greater than a[pivot]
    * No element in a[pivot+1] through a[end] is less than a[pivot]

Following is the quicksort implementation in Java, here pivot is chosen as the last element in the array

This implementation is based on pseudo code provided in Cormen

```
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
```
