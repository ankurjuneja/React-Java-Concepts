//Given a sorted array, binary search returns the index of the searched element
//Time complexity: O(logn)

package searching;

class binSearch{
	
	
	//Recursive Binary Search
	public int recSearch(int[] arr,int left,int right,int num){
		if(right >= left){
			int mid = (right-1)/2 + 1;
			//if element is present at the middle itself
			if (arr[mid] == num)
				return mid;
			
			// If element is smaller than mid, then it can only be present
	        // in left subarray
			if(arr[mid] > num)
				return recSearch(arr,left,mid-1,num);
		//else element can only be present in right subarray
			return recSearch(arr,mid+1,right,num);
		}
		return -1;
		
	}
}

public class BinarySearch {
	public static void main(String[] args){
	
		int[] arr = {10,23,47,51,78};
		binSearch bs = new binSearch();
		System.out.println("index of the element(51) searched is "+ bs.recSearch(arr,0,arr.length,51));
	}
	
}
