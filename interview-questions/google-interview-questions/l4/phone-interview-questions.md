# Phone Interview Questions

* There is stream of float values (-inf, inf) which is coming as input and an integer D.

We need to find a set of 3 values which satisfy condition - |a - b| <= D, |b - c| <= D, |a - c| <= D, assuming a,b,c are 3 float values. Print these 3 values and remove them and continue ....

Constraints -\
All values in stream will be unique.\
D -> \[0, inf)

Eg:\
Input stream - \[1,10,7,-2,8,....], d = 5\
Output - (when 8 comes, then print "7 8 10" and remove them and continue)

```
class Solution {
	private int D;
	void init(int d) {
		this.D = d;
	void func(float item) {
		// implement
	}
}
```

What data structure should be used here, and what approach can be applied? ([Link](https://leetcode.com/discuss/interview-question/4964533/Google-Phone-Interview-Question))\




* Given one struct of time interval with using that i have to return in bool that are they overlapping 2 intervals or not. \
  struct TimeInterval{ \
  &#x20;     int id ; \
  &#x20;     int startTime; \
  &#x20;     int endTime; \
  }; \
  \
  bool overlapping( TimeInterva t1, TimeInterva t2){} ([Link](https://leetcode.com/discuss/interview-question/5230887/Google-or-L4-or-Phone-Screening-or-Round-1))\

*   Given stream of time interval tell that min how many cars will be used to book for all timeintervals;

    Given : \{{1,3}, {2,5},{6,8},{7,10},{9,10\}}\
    output :\
    car1 : {1,3},{6,8},{9,10}\
    car2 : {2,5},{7,10} \
    ([Link](https://leetcode.com/discuss/interview-question/5230887/Google-or-L4-or-Phone-Screening-or-Round-1))\
    \
    \

*   Imagine we have google drive in Some other country and your code is running in another country.

    ```clike
    struct FilesFolders {
    	vector<string> files;
    	vector<string> folders;
    }

    FilesFolders FindAllFilesAndFolders(path) {
    	// network call in google drive which fetches all files and folders inside this path.
    	return FilesFolders;
    }

    // Implement Search method which return any path which has sub_string in it.
    string Search(string path, string sub_string) {

    }

    Expectation: -> Implement this Search method and give time complexity according to network latency for google drive.
    Solution -> A recurrence and focus on Time Complexity.

    Follow up ->

    New method:
    void get_async(string path, callback_func…) {
    	// creates a new thread
    	// Calls callback_func after 100ms or whenever operation done.
    	callback_func(files, folders);
    	return;
    }

    -> Now implement Search using new method get_async() along with time_complexities.
    ```

    ([Link](https://leetcode.com/discuss/interview-question/5160996/Google-Phone-Screen))\
    \
    \

*   [https://leetcode.com/discuss/interview-question/5075278/Google-Phone-screen](https://leetcode.com/discuss/interview-question/5075278/Google-Phone-screen)\
    inputs:

    ```
    int n - [0..n-1] digits in the array, 
    int[]arr1 - [0, 1, 2] len 3 values will be valid and will use the digits in the range of 0 to n-1
    int[]arr2 - [2, 3, 1] len 3 values will be valid and will use the digits in the range of 0 to n-1
    arr1 and arr2 can contain duplicate values and also all values can be equal. arr1:[0, 1, 2] arr2:[0, 1, 2]
    int t - will be used to calculate upper and lower bound for each digit in the array. `0<=t<=n`.
    ```

    Function signature

    ```
    int solve(int n, int t, int[]arr1, int[]arr2) {
    }
    ```

    Return how many distinct combinations (length of 3) we can create. Distinct - order matters \[0, 1, 2] \[2, 0, 1] is distinct. \[0, 1, 2] \[0, 1, 2] not distinct\
    E.x

    ```
    n = 3
    arr1[0, 1, 2]
    arr2[2, 0, 1]
    t = 1
    ```



* You are given n fingerprints from 0 , 1 ,2 , 3.....(n-1). One has to generate a password of length n or greater than n, such that every fingerprint should be utilised atleast once. \
  \
  Write a general function, where you are given number of fingerprints and password length and print all the possible passwords.

\
