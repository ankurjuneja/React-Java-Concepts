## Arrays and Strings

**Reverse a String**

 *String* is a sequence of characters. Can be represented by char arrays. Immutable objects.
 
 *StringBuilder* is mutable sequence of characters. Instances of StringBuilder are not safe for use by multiple threads.
 
 Use *StringBuffer* for synchronization.

 substring is a method that returns the substring from the specified index i.e. the begin index.

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

    ```
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
 ```
