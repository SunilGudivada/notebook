---
description: 'Priority: P0'
---

# Algorithms and Coding

## Algorithms

### What you need to know

Please note here that if I write that I need to know "Linked lists", for example, then I will not list every algorithm related to this topic. But it is understood that you need to independently study which he has operations and practice writing delete, insert and other important things.

The second important thing is that if you are short on time and do not have time to cover all topics, then choose those that you are more likely to meet. For example, it is better to study graphs and trees, than encryption algorithms. But if you have the opportunity, try to study everything, at least for the level of understanding of Wikipedia.

* Basic things

  * Algorithm complexity - what is it and how is it counted? The complexity is temporary and spatial
  * Working with bits - tables AND, OR, XOR. This also includes a binary notation, and degrees deuces
  * Fundamentals of Probability Theory
  * Basics of combinatorics and counting the number of different combinations
  * Fundamentals of Euclidean geometry - for example, how to check if points lie on the same straight, on one or different sides of a straight
  * Fundamentals of Cryptography
  * Computer Security Fundamentals

* Basic Data Structures
  * Strings
    * ASCII, UNICODE
    * How Strings are implemented in your programming langauge \( for example does it have maximum length \)
    * Search for substrings \(for example, the Rabin-Karp algorithm\)
    * Regular expressions
  * Arrays
    * Implementation details in your programming language.  For example, for C ++ you need to know the implementation using pointers, and the vector. For a vector too you need to know, for example, what it resize periodically, and other similar details.
  * Linked Lists
    * Single Linked List
    * Double Linked List
    * Less common types are listed in [wikipedia](https://en.wikipedia.org/wiki/Linked_list) page
  * Stacks and Queues
  * Trees
    * DFS , BFS
    * Adding and removal of elements
    * Less common tree types \(eg, red black trees, B-trees\) - what are they, how they

      differ from the binary trees, basic complexities, and how they are used. No need to know all the rotations in the RB-tree, for example.

    * Tries
  * Heaps
    * Heap sort
    * Using heaps for tracking top-K
    * Allocating elements on a heap vs on a stack - what does it mean?
  * Graphs
    * DFS, BFS
    * Topological search
    * Shortest path
  * Hash
    * Hash functions
    * Universal hash
* Algorithms
  * Sorting
    * Especially make sure you know heapsort, mergesort and quicksort.
  * Searching
    * Binary search
    * Searching in linked lists, arrays, trees, graphs, dictionaries
  * Dynamic Programming
  * Greedy Algorithms
  * Recursion
* Other Mastering algorithms
  * Master theorem
  * NP Complete Problems
  * Discrete Math

### Notes

* You need to understand the trade offs of each task. For example, searching in a HashMap is usually faster sort, but it needs additional memory. So in cases where the speed is not critical, but memory, yes, it may be better to sort.
* For more rare data structures - eg, trie, B-tree, red black tree - it is not necessary to remember all rotations for deleting and inserting an element, but you need to understand how these structures work and where they are used.
* You need to understand the limitations of each task. For example, searching for an element in an array cannot be done in less than O \(n\) time. Or that in general the complexity sorting, which uses a comparison elements, [can not be less than O \(n log n\)](http://www.geeksforgeeks.org/lower-bound-on-comparison-based-sorting-algorithms/)
* What is NP completeness. This is the type of problem that can only be solved by exhaustive search options. Know what tasks are -[NP-complete](https://en.wikipedia.org/wiki/List_of_NP-complete_problems)
*  Learn standard problem solving techniques. For example, a heap of size K can be

  use top-K for large array for linear complexity. Remember these tricks are worked out by solving problems.

> Another good answer to the "What you need to know" question on Stackexchange: [Which algorithms / data structures should I “recognize” and know by name?](https://softwareengineering.stackexchange.com/questions/155639/which-algorithms-data-structures-should-i-recognize-and-know-by-name/155649)

### Advice

> When learning algorithms, ask yourself the questions yourself. This is the easiest way to deepen own knowledge. For example, when the complexity of the algorithm is log \(n\), then on what basis is log and why? Or what is better to buy to speed up your code - a sea of RAM or more smart processor? Why?

### Books

* [Introduction to algorithms](https://www.amazon.com/gp/product/0262033844/ref=as_li_qf_sp_asin_il_tl?ie=UTF8&tag=everydaymat0e-20&camp=1789&creative=9325&linkCode=as2&creativeASIN=0262033844&linkId=fabcc9c57faf1ad52d33b1a64d727496)
* [The Algorithm Design Manual](https://www.amazon.com/Algorithm-Design-Manual-Steven-Skiena/dp/1848000693/ref=as_sl_pc_tf_til?tag=everydaymat0e-20&linkCode=w00&linkId=9f90bb4613a9e926088f259812a6002d&creativeASIN=1848000693)
* [Discrete Mathematics for Computing](https://www.amazon.com/gp/product/0230216110/ref=as_li_qf_sp_asin_il_tl?ie=UTF8&tag=everydaymat0e-20&camp=1789&creative=9325&linkCode=as2&creativeASIN=0230216110&linkId=4529bbff31d936c5842722d40a28f141)
* [Algorithms \(4th edition\)](https://www.amazon.com/gp/product/032157351X/ref=as_li_qf_sp_asin_il_tl?ie=UTF8&tag=everydaymat0e-20&camp=1789&creative=9325&linkCode=as2&creativeASIN=032157351X&linkId=c4fa79750e9c2454c6703638061258f6)
* [Essential Algorithms by Rod Stephens](https://www.amazon.com/Essential-Algorithms-Practical-Approach-Computer/dp/1118612108/ref=sr_1_1?s=books&ie=UTF8&qid=1475477094&sr=1-1&keywords=rod+stephens)

### Links and Articles

* [Big-About Cheat Sheet ](http://bigocheatsheet.com/)
* [Algorithms: Design and Analysis, Part 1 \(Stanford\)](https://www.coursera.org/specializations/algorithms), [Part 2](https://www.coursera.org/course/algo2) - Courses Stanford algorithms
* [Algorithms, Part I of \(The Princeton\) ](https://www.coursera.org/course/algs4partI)- a course at Princeton
* [an Analysis of Algorithms \(The Princeton\)](https://www.coursera.org/learn/analysis-of-algorithms) - one course at Princeton
* http://visualgo.net - many visualizations of algorithms and data structures
* [Intro to Algorithms \(Udacity\)](https://www.udacity.com/course/intro-to-algorithms--cs215)
* Video from the author of "Cracking the coding interview":
  * [How Companies Evaluate Technical Interviews ](https://www.youtube.com/watch?v=jxAWQN5t6wg)
  * [How to Approach Behavioral Questions](https://www.youtube.com/watch?v=tZxNNKqxXnw)
  * [7 Steps to Solve Algorithm Problems](https://www.youtube.com/watch?v=GKgAVjJxh9w)
  * [3 Algorithm Strategies](https://www.youtube.com/watch?v=84UYVCluClQ)
* [The Mastering the Software Engineering of Interview on Coursera](https://www.coursera.org/learn/cs-tech-interview)

## Coding

                 I regularly see candidates for the hiring committee who know how to solve problems, everyone knows well algorithms, but cannot write code for them. Surprising but true! Such a candidate finds the most the optimal solution, can tell you well why it is optimal, and in general, brilliant copes with the task in the plane of theory. But when it comes to writing to the task code, he gets a gag, and he writes for a long time, with mistakes, and does not have time to finish the interview. So we refuse candidates with the words " _They are, of course, smart and with potential, but it is immediately clear that you need to develop some coding skills._ "

In general, don't be like that candidate. Be sure to practice writing code for tasks. Necessarily! You should be able to write a binary search or quicksort there without coming to consciousness, if I wake you up in the middle of the night!

### What you need to be able to

1. Quickly and without errors write the code of the standard algorithm \(binary search, sorting, depth-first search, breadth-first search, removing an element from a linked list ...\)
2. Quickly and without errors, write the code for your solution to the algorithmic problem in the interview. it means that if you combine several data structures, for example \(well, you never know :\), store the nodes of the graph in a linked list and do something with them in the search process, then you should completely calmly write the code for the graph, and the code for the linked list, and the code for search.
3. Write code that compiles \(avoid pseudocode if possible\).
4. Write neat, [elegant code ](http://programmers.stackexchange.com/questions/97912/how-do-you-define-elegant-code)which reads well. The fewer lines the better but not at the expense of readability. If you have several options - for example, more efficient code, which, however, is less readable, then discuss these options with interviewer.
5. Write code that works with corner cases: null, empty lines, zero, negative numbers
6. Write code that doesn't just work, but works efficiently. For example for C ++, if

   you need to pass a string as a parameter to the function, it will be correct to write

   f \(const string & s\), instead of f \(string s\).

7. Test your code without being reminded and find all errors yourself. Better right away

   start with test cases, at least in the simplest form: that is, you have been assigned a task - write an example \(or several\) of input and output data before writing the actual code. In this way, you are not just setting the stage for further debugging your code, but also make sure that you correctly understand the task set by the interviewer.

8. When testing, try to cover all the code - so that the code coverage is 100%.

### What you need to know

Standard libraries of your programming language. For example, you should know how [remove an element from the middle of the array](http://www.cplusplus.com/reference/vector/vector/erase/) or [find elements of a set that are not in another the set](http://en.cppreference.com/w/cpp/algorithm/set_difference) without looking at the documentation. For C ++ it means knowing quite a lot things from STL and std.

### Advice

1. Keep in mind that the most important thing here is practice, not reading books and articles. In the context of the process preparation for the interview, you can write the code for the solution, and then look at other people's solutions the same task and compare how much the best of them are better than yours and what your decision. Close someone else's solution and rewrite yours to make it more "elegant".  Do this with each task until your solution looks like one of the best among the rest.It is better to rewrite the problem using someone else's solution on the next day, then you will be sure that you really understand how a faster solution works, and not just copied the code seen from the head. 
2. Speak your train of thought. The interviewer doesn't know what's going on in your head if you silently look at the board for five minutes. Maybe you have already thought through and discarded 5 different approaches, but the interviewer may think that your head is empty. Therefore, we must speak. For most people, this is unnatural. Practice with a friend.
3. If you can't immediately come up with the optimal solution to the problem, start with brute force solutions. Tell me that you understand that it is not the best, but you want to start with it, in order to further improve and optimize. Perhaps the interviewer will "push" you in the right direction, but even if not, then it is better to do at least something than look at clean board and look like a complete idiot. 🤨 
4. You probably won't be given an IDE to write code. And without Code Insight, write much more difficult. You may be asked to write the code on the board with a marker, on paper with a pencil, or Alternatively, if it's a remote phonescreen, go to Google Doc. Practice writing code on paper with a friend, and then let him give you feedback on how it looked.
5. Nobody will require you to remember all the methods of all library classes and all parameters of all methods, but you should at least in general terms remember the syntax. Have in mind that writing with a marker on a blackboard is in some respects even more difficult than writing with a pen on paper - because although you can erase your code, markers are usually very thick and on the boards quickly runs out of space. \(In some sources, therefore, even it is advised to bring your markers to the interview, thinner. Just don't bring indelible, otherwise you will definitely remain in the interviewer's memory for a long time, but not in the better context! 🤨 

The advice to practice not alone, but with someone is one of the most difficult to implement, and accordingly, one of the most overlooked. The trouble is that he is also one of the most  
 significant. Believe me, solve the problem yourself and solve it under the watchful eye  
 interviewer, under stress and limited time - these are two big differences. if you there is absolutely no one to ask and no one to cooperate with to evaluate your interview - at worst end, record yourself on camera. Then review and rate. \( I repeat that this is an option really without fish, that is, in the case when you really have absolutely no one ask, or you are so shy that before you ask someone, you need practice alone.\)

### Books

* ["Clean Code: A Handbook of Agile Software Craftsmanship"](http://amzn.to/2cQdAXp)
* ["Code Craft: The Practice of Writing Excellent Code"](http://amzn.to/2csfKes)
* ["The Clean Coder: A Code of Conduct for Professional Programmers \(Robert C. Martin Series\)" ](http://amzn.to/2cW5wjA)
* ["Beautiful Code: Leading Programmers Explain How They Think"](http://amzn.to/2cVxdLb)
* [Effective Java \(2nd Edition\) 2nd Edition by Joshua Bloch](https://amzn.com/B00B8V09HY)

