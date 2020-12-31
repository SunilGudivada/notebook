##724. Find Pivot Index
<p>Given an array of integers <code>nums</code>, write a method that returns the &quot;pivot&quot; index of this array.</p>

<p>We define the pivot index as the index where the sum of all the numbers to the left of the index is equal to the sum of all the numbers to the right of the index.</p>

<p>If no such index exists, we should return -1. If there are multiple pivot indexes, you should return the left-most pivot index.</p>

<p>&nbsp;</p>
<p><strong>Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,7,3,6,5,6]
<strong>Output:</strong> 3
<strong>Explanation:</strong>
The sum of the numbers to the left of index 3 (nums[3] = 6) is equal to the sum of numbers to the right of index 3.
Also, 3 is the first index where this occurs.
</pre>

<p><strong>Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,2,3]
<strong>Output:</strong> -1
<strong>Explanation:</strong>
There is no index that satisfies the conditions in the problem statement.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The length of <code>nums</code> will be in the range <code>[0, 10000]</code>.</li>
	<li>Each element <code>nums[i]</code> will be an integer in the range <code>[-1000, 1000]</code>.</li>
</ul>
