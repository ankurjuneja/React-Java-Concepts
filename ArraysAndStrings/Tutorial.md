## Arrays and Strings

 *String* is a sequence of characters. Can be represented by char arrays. Immutable objects.
 
 *StringBuilder* is mutable sequence of characters. Instances of StringBuilder are not safe for use by multiple threads.
 
 Use *StringBuffer* for synchronization.

 substring is a method that returns the substring from the specified index i.e. the begin index.

**Reverse a String**

 ```
 public String reverseIteratively(String strToReverse)
     {
      StringBuilder stringBuilder = new StringBuilder();
      char[] strChars = strToReverse.toCharArray();

      for (int i =strChars.length-1;i>=0;i--)
      {
          stringBuilder.append(strChars[i]);
      }
      return stringBuilder.toString();
     }

     public String reverseRecursively(String strToReverse)
     {
         if(strToReverse.length() < 2)
             return strToReverse;

         return reverseRecursively(strToReverse.substring(1))+strToReverse.charAt(0);
     }
  ```
**Given two Strings, check if one is permutation of the other**

 Assumption-Comparision is case sensitive and white spaces are significant

 ```
 public Boolean checkPermutation (String str1, String str2)
     {
         if(str1.length()!=str2.length())
             return false;

         int[] letters = new int[256]; // Assumption ASCII character set
         char[] str1Array = str1.toCharArray();

         for(char c: str1Array)
         {
             letters[c]++;
         }

         for (int i=-0; i<str2.length();i++)
         {
             int c = (int) str2.charAt(i);
             if(--letters[c] < 0)
                 return false;
         }

         return true;
     }
 ```

 **find whether the String has all unique characters**

    
    public boolean isUnique(String str){
 		//ascii character set is 128 unique chars
 		if (str.length() > 128)
 			return false;

 		boolean[] charSet = new boolean[128];

 		for (int i=0; i<str.length(); i++){
 			int val = str.charAt(i);

 			//found this char in string
 			if (charSet[i])
 				return false;

 			//value in char set is marked as true

 			charSet[val] = true;
 		}

 		return true;
 	}
 
**Given a string and two integers, find all the unique substrings of all lenghts between those integers**

```
public void mySubString(String s,int left,int right)
    {
        List<String > subStrings = new ArrayList<>();

        for(int i=left;i<=right+1;i++)
        {
            for(int j=i;j<=right+1;j++)
            {
                if(s.substring(i,j).length()!=0 && !subStrings.contains(s.substring(i,j))) {
                subStrings.add(s.substring(i,j));
                }
            }
        }

        System.out.println(subStrings.size());
    }
```

**Shuffle array of integer**
```
public void shuffleArray(int arr[]) {
        Random rand = new Random();

        //start from the last element and swap one-by-one
        for (int i = arr.length-1 ; i > 0 ; i--) {
            //find random from 0 to i
            int random = rand.nextInt(i);
            
            //swap arr[i] with element at random index
            int temp = arr[random];
            arr[random] = arr[i];
            arr[i] = temp;
        }

        System.out.println(Arrays.toString(arr));
    }
```

**Shuffle a Deck of cards**

[Java Program](https://github.com/ankurjuneja/React-Java-Concepts/blob/master/src/ArraysAndStrings/Deck.java)

**Method to replace all spaces in a string with %20**
```
public static String replaceSpaceWithPercent20(String str) {
        char[] charArray = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        String percent20 = "%20";
        for(int i = 0; i < charArray.length-1; i++) {
            if(charArray[i] == ' ' && charArray[i+1] != ' ')
                sb.append(percent20);
            else
                sb.append(charArray[i]);
        }
        return sb.toString();
    }
```

**Given an array of integers, find subarray with maximum sum**
```
public void maxSubArraySum (int arr[]) {
        int maxSoFar = Integer.MIN_VALUE;
        int maxEndHere = 0;
        int start = 0;
        int end = 0;
        int s = 0;

        for (int i=0 ; i < arr.length; i++) {
            maxEndHere += arr[i];
            if(maxSoFar < maxEndHere) {
                maxSoFar = maxEndHere ;
                start = s;
                end = i;
            }
            if (maxEndHere < 0) {
                maxEndHere = 0;
                s = i+1;
            }
        }
        System.out.println("maximum sum of subarray-"+maxSoFar);
        System.out.println("starting index-"+start);
        System.out.println("ending index-"+end);
    }
```

**given a 2D array of integers, sorted row wise and column wise. find if number exists in the array.**

Java supports multi-dimensional array by having array of arrays.

```
public boolean findNum (int[][] arr, int num) {
        int row = 0;
        int column = arr[row].length-1;
        while(row >= 0 && column >=0 && row <= arr.length-1 && column <= arr.length-1) {
            if (arr[row][column] == num)
                return true;
            else if ( arr[row][column] < num)
                row++ ;
            else
                column--;
        }
        return false;
    }
```
