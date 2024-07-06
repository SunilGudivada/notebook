---
cover: >-
  https://images.unsplash.com/photo-1565728744382-61accd4aa148?crop=entropy&cs=srgb&fm=jpg&ixid=M3wxOTcwMjR8MHwxfHNlYXJjaHw0fHxJbnRlcnZpZXd8ZW58MHx8fHwxNzIwMTk5OTIyfDA&ixlib=rb-4.0.3&q=85
coverY: 0
---

# Interview Questions

*   I was asked to get all the possible combinations of a series of "musical notes" given the following rules:

    1. Every sequence must have a sum of 12
    2. Possible notes that make up the sequence can only be 1, 2 and 3
    3. There are only certain valid transitions, they're given in this dictionary {1: \[2, 3], 2: \[1, 2], 3: \[1]}. Meaning, only 2 and 3 are allowed after 1 and so on
    4. First note and last note must have a valid transition. Example of valid sequence: \[1, 2, 2, 2, 1, 1, 3]. Example of not valid: \[1, 2, 2, 2, 2, 2, 1] reason is because 1 cannot be followed by another 1 (last and first notes transition is invalid)

    Return every possible valid sequence in an array of possible sequences. You may return it in any order. ([Link](https://leetcode.com/discuss/interview-question/5359320/Google-L3-Onsite-Second-Round))\
    \
    \

*   Write a function that takes the following 3 queries:

    ```
    	1. manager, a, b      -> represents that a is manager of b
    	2. peer, a, b         -> both a and b have the same manager
    	3. is_manager a, b    -> you should return whether a is manager of b
    ```

    Assume every input is valid.\
    Assume every query is coming one at a time, not a list of queries.\
    Interviewer said I might come across a case where a peer query came with two managerless employees

    My answer was a class that had three global variables: managerless\_people, peer\_to\_manager, managers that represented a connection between a and b. Lots of if statements and assignments. ([Link](https://leetcode.com/discuss/interview-question/5369393/Google-Onsite-Final-Coding-Interview))\
    \
    &#x20;\
    \

*   Given a string with any format containing only english letters, replace every percent-sign-sorrounded word (%EXAMPLE%) with the corresponding variable given inside a dictionary passed as an argument. Example:

    ```
    input = "home/usr/lib/%EXAMPLE%", {EXAMPLE: "testfile.tx"}
    output =  "home/usr/lib/testfile.txt"

    input = "Hi %USER% how are you doing today %DATE%?", {USER: "John", DATE: "01/01/2024"}
    output =  "Hi John how are you doing today 01/01/2024?"
    ```

    My response was a simple algorithm that goes through every letter and whenever I see % I would call another function to get the closing sign. If no closing sign was found or no variable was mapped to that variable name, I would return error

    Follow Up Question:

    Imagine your dictionary with variables had nested variables. For example:

    ```
    input = "Hi %USER%", {USER: "%PRONOUN% John", PRONOUN: "Mr."}
    ```





* Given an array of size n and an integer k where k << n. Also for each element, the absolute difference b/w its current position and sorted position is <= k. We have to sort the array.\
  \
  \
  \

*   You are given a tree node (Root) at start. Write two methods\
    a. addNode(TreeNode \*parent, int val) ===> Create a new node and add it to its parent. Parent pointer was given as argument for this function.\
    b. getRandomNode() ==> Gives a random node from the tree

    Follow up: getRandomLeafNode() => Give a random leaf node.

    All the methods must be in O(1).\
    \
    \
    \

*   Given an array, any subarray is special if it forms an AP with common difference of 1 or -1. Give sum of all such subarrays.

    Ex: arr = \[2,3,4,5,6,5]

    So ans should be sum of all the good subarrays which are:

    \[2], \[3], \[4], \[5], \[6], \[5]

    \[2,3], \[3,4], \[4,5], \[5,6], \[6,5]

    \[2,3,4], \[3,4,5], \[4,5,6]

    \[2,3,4,5], \[3,4,5,6]

    \[2,3,4,5,6]
