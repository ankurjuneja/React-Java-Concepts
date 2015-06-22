// Selection sort finds the minimum element from the unsorted array and it in sorted array
// this process is repeated until all the elements are in sorted array
// Time complexity - O(n*n)
package searching;

class SelSort{
    
    private int temp;
    private int idx;
    
    public void selSort(int arr[],int len){
        //traversing through unsorted array
       for (int i =0;i<=len-1;i++){
           temp = i;
           //find the minimum element in unsorted array
           for (int j=i+1;j<len;j++){
               if (arr[j] < arr[temp])
                temp = j;
           }
           //swapping the first element with minimum element
           idx = arr[temp];
           arr[temp] = arr[i];
           arr[i] = idx;
          
       }
    }
    
  // method to print sorted array
    public void printArray(int arr[], int len){
        for(int i=0;i<len;i++){
            System.out.print(  arr[i] +" ");
        }
    }
}

public class SelectionSort {
    public static void main(String[] args){
        int[] arr = {64,25,12,22,11};
        SelSort ss = new SelSort();
        ss.selSort(arr, arr.length);
        ss.printArray(arr, arr.length);
    }
}
