
## 28.  Implement strStr()  [![Website shields.io](https://img.shields.io/badge/Easy-green.svg)](https://sunilgudivada.github.io/Data-Structures-and-Algorithms/)


Implement  [strStr()](http://www.cplusplus.com/reference/cstring/strstr/).

Return the index of the first occurrence of needle in haystack, or  `-1`  if  `needle`  is not part of  `haystack`.

**Clarification:**

What should we return when  `needle`  is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when  `needle`  is an empty string. This is consistent to C's [strstr()](http://www.cplusplus.com/reference/cstring/strstr/)  and Java's [indexOf()](https://docs.oracle.com/javase/7/docs/api/java/lang/String.html#indexOf(java.lang.String)).
  
   
  
Example 1:  
  

    Input: haystack = "hello", needle = "ll"
	Output: 2

 
Example 2:  
  

    Input: haystack = "aaaaa", needle = "bba"
	Output: -1  

Example 3:  
  

    Input: haystack = "", needle = ""
	Output: 0

  

 
Constraints:  
 

-   0 <= haystack.length, needle.length <= 5 * 104`
-   `haystack`  and `needle`  consist of only lower-case English characters. 


> #### Recommended: Please solve it in your code editor first, before moving on to the solution.
  [![Website shields.io](https://img.shields.io/badge/28-solution-green.svg)](https://github.com/SunilGudivada/Data-Structures-and-Algorithms/blob/master/src/com/platform/leetCode/problems/_28_Implement_strStr.java)
