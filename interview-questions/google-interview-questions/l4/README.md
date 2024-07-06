# L4

### L4

[https://leetcode.com/problems/longest-consecutive-sequence/description/](https://leetcode.com/problems/longest-consecutive-sequence/description/)\
[https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/description/](https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/description/)\
[https://leetcode.com/problems/two-sum/description/](https://leetcode.com/problems/two-sum/description/)\
[https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/)\
[https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/)\
[https://leetcode.com/problems/logger-rate-limiter/description/](https://leetcode.com/problems/logger-rate-limiter/description/)\
[https://leetcode.com/problems/walls-and-gates/description/](https://leetcode.com/problems/walls-and-gates/description/)\
[https://leetcode.com/problems/meeting-rooms-ii/description/](https://leetcode.com/problems/meeting-rooms-ii/description/)\
[https://leetcode.com/problems/random-pick-with-weight/description/](https://leetcode.com/problems/random-pick-with-weight/description/)\
[https://leetcode.com/problems/the-earliest-moment-when-everyone-become-friends/description/](https://leetcode.com/problems/the-earliest-moment-when-everyone-become-friends/description/)\
\
**Other Questions**:

* Given a employee table employeeid and managerid , employee name. Find hierarchy for an employeeid upto highest level. - Recursive CTEs concept ( [link](https://leetcode.com/discuss/interview-experience/5147609/Google-L4-or-Application-Engineer-\(-Data\)-or-Hyderabad-or-April-2024-Rejected) )
* Sql question on find managers who are not in same location as their employees ( self join ) ([link](https://leetcode.com/discuss/interview-experience/5147609/Google-L4-or-Application-Engineer-\(-Data\)-or-Hyderabad-or-April-2024-Rejected))
* SQL question using Recursive CTE and a simple python implementation of the same.([link](https://leetcode.com/discuss/interview-experience/5147609/Google-L4-or-Application-Engineer-\(-Data\)-or-Hyderabad-or-April-2024-Rejected))
* Find the number of partitions of an array such that each contiguous partition consists of atleast one negative number. \
  \
  eg. \[-1,-2,-3,-4] has these possible partitions : \
  \[-1],\[-2],\[-3],\[-4];\
  &#x20;\[-1,-2],\[-3,-4]; \
  \[-1,-2,-3] ,\[-4]; \
  \[-1],\[-2,-3,-4]; \
  \[-1]\[-2,-3],\[-4]; ([Link](https://leetcode.com/discuss/interview-question/4574669/Google-or-Onsite-or-Find-partitions/))\
  \

*   A kid found out that his uncle loves him so much that he would do anything to buy him as many gifts as he possibly can. For this reason, the nephew prepares a list of gifts that he wants and gives it to his uncle. Each item in the list contains 2 integers: the day on which he wants the gift (today is day 0), and the cost of it. The uncle, knowing that his nephew is preparing such a list, saves $1 per day for the gifts, and initially (on day 0) he has $0. Calculate the maximum number of gifts the uncle can buy to his nephew.

    Input: The first line contains a single integer N - the number of gifts. Then N lines follow. Each line contains two integers separated by space: d\_i (the day that present i should be bought) and c\_i (the cost of gift i).

    Output: A single integer which is the maximum number of gifts the uncle can buy.

    ```
    First Test Case:
    Input:
    3
    3 2
    5 4
    6 3 

    Output
    2

    ```

    In this test case, there are 3 gifts on the list. On the 3rd day the uncle has $3 and can buy the gift that costs $2. Uncle is left with $1, and on day 5 she has two more dollars, a total of $3. On the 5th day he can't buy the gift that costs $4. The next day (6th) she has $4 and he can now buy the gift that costs $3. There is no way to buy all gifts in the list.

    ```
    Second Test Case:
    Input
    5
    1 2
    3 2
    5 3
    6 2
    7 2

    Output
    3
    ```

    ```
    Third test case:
    4
    1 1
    50 40
    51 20
    52 20

    Output : 3 (better to buy on day 1, 51 and 52 (NOTE: greedy solution would be to buy on day 1 and day 50, that is incorrect)

    ```

    ([Link](https://leetcode.com/discuss/interview-question/4173795/MAANG-interview-question/))\
    \

*   **Question**: Given two arrays A and B, each of size n, where A\[i], B\[j] represent the strength of a signal received from 2 antennas placed at two different places. A signal is considered to be valid if it is present in both the arrays A & B at a distance <= D. Find the number of valid signals.

    **Example**: A=\[1,3,4,3,4,5,6], B=\[4,1,8,7,6,3,2], D=2\
    Answer: The valid signals are A\[0] (=B\[1]), A\[2] (=B\[0]),A\[6] (=B\[4]), A\[3] (=B\[5]). Hence the answer is 4.

    _**Solution**: Solved using a sliding window of size 2d+1 storing the frequency of each signal value from B. Start traversing the array A and as we move forward to element A\[i], add the element B\[i+d] to the sliding window and remove element B\[i-d] from the silding window. If the frequency for A\[i]>0 in the current sliding window, increment the answer and decrease the frequency for A\[i] in the window. (_[_Link_](https://leetcode.com/discuss/interview-question/5354958/Google-or-L4)_)_\
    \

* Gave two json objects and asked me to compare how many changes there are between two and print the changes out.\
  \
  \

*   I was given (as strings) as directories e.g.\
    /a/b/x.txt\
    /a/b/p.txt\
    /a/c\
    /a/d/y.txt\
    /a/d/z.txt

    Also, I was given the selected directories e.g.\
    /a/d/y.txt\
    /a/d/z.txt\
    /a/b/p.txt

    My output should be\
    /a/d\
    /a/b/p.txt

    /a/d\
    is the answer because it has 2 txt files (y and z), and both are selected.\
    /a/b/p.txt\
    is the answer because another file in the directory i.e. /a/b/x.txt is not selected, if it was selected, answer would have been /a/b

    Basically, if all items are selected in a particular directory, we need to return the just prev directory. ([Link](https://leetcode.com/discuss/interview-question/5039879/Google-Onsite-Interview))

#### System Integration

*   Integrate on-hand inventory data from our global network of warehouses, each managed by different systems, to a central ERP.

    Discussed Data pipeleine designing for different sources and their integration into data warehouse , Data Reconcillation , Authentication with different systems involved , Trade-offs between choosing different ingestion mechanisms for different usecases. ([link](https://leetcode.com/discuss/interview-experience/5147609/Google-L4-or-Application-Engineer-\(-Data\)-or-Hyderabad-or-April-2024-Rejected))

\


#### Application Design

* Design a car rental reservation system.System Should allow user to book a car for a given time, cars can have multiple tier, discounts etc.The system should support multiple tenants. Discussed Business, Techincal requirements , Data modelling ( LLD ) and general application design of the same. ([link](https://leetcode.com/discuss/interview-experience/5147609/Google-L4-or-Application-Engineer-\(-Data\)-or-Hyderabad-or-April-2024-Rejected))
* Multiple functions to design Leaderboard
