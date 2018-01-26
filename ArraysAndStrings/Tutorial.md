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
