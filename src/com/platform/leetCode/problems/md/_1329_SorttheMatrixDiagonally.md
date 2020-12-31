##1329. Sort the Matrix Diagonally
<p>A <strong>matrix diagonal</strong> is a diagonal line of cells starting from some cell in either the topmost row or leftmost column and going in the bottom-right direction until reaching the matrix&#39;s end. For example, the <strong>matrix diagonal</strong> starting from <code>mat[2][0]</code>, where <code>mat</code> is a <code>6 x 3</code> matrix, includes cells <code>mat[2][0]</code>, <code>mat[3][1]</code>, and <code>mat[4][2]</code>.</p>

<p>Given an <code>m x n</code> matrix <code>mat</code> of integers, sort each <strong>matrix diagonal</strong> in ascending order and return <em>the resulting matrix</em>.</p>

<p>&nbsp;</p>
<p><strong>Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/01/21/1482_example_1_2.png" style="width: 500px; height: 198px;" />
<pre>
<strong>Input:</strong> mat = [[3,3,1,1],[2,2,1,2],[1,1,1,2]]
<strong>Output:</strong> [[1,1,1,1],[1,2,2,2],[1,2,3,3]]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>m ==&nbsp;mat.length</code></li>
	<li><code>n ==&nbsp;mat[i].length</code></li>
	<li><code>1 &lt;= m, n&nbsp;&lt;= 100</code></li>
	<li><code>1 &lt;= mat[i][j] &lt;= 100</code></li>
</ul>
