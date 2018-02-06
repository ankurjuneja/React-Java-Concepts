## QuickSort

It is a divide and conquer algorithm for sorting.It is in-place sorting having O(N Log N) on the average.

works by partitioning the input array into two parts, then sorting the parts independently

partitioning process is most important - this process permutes the array so that following conditions hold

    * the element a[pivot] is in final place for some pivot
    * No element in a[start] through a[pivot-1] is greater than a[pivot]
    * No element in a[pivot+1] through a[end] is less than a[pivot]

