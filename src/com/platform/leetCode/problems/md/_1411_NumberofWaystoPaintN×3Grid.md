##1411. Number of Ways to Paint N × 3 Grid
<p>You have a <code>grid</code> of size <code>n x 3</code> and you want to paint each cell of the grid with exactly&nbsp;one of the three colours: <strong>Red</strong>, <strong>Yellow</strong> or <strong>Green</strong>&nbsp;while making sure that no two adjacent cells have&nbsp;the same colour (i.e no two cells that share vertical or horizontal sides have the same colour).</p>

<p>You are given <code>n</code> the number of rows of the grid.</p>

<p>Return <em>the number of ways</em> you can paint this <code>grid</code>. As the answer may grow large, the answer <strong>must be</strong> computed modulo&nbsp;<code>10^9 + 7</code>.</p>

<p>&nbsp;</p>
<p><strong>Example 1:</strong></p>

<pre>
<strong>Input:</strong> n = 1
<strong>Output:</strong> 12
<strong>Explanation:</strong> There are 12 possible way to paint the grid as shown:
<img alt="" src="https://assets.leetcode.com/uploads/2020/03/26/e1.png" style="width: 450px; height: 289px;" />
</pre>

<p><strong>Example 2:</strong></p>

<pre>
<strong>Input:</strong> n = 2
<strong>Output:</strong> 54
</pre>

<p><strong>Example 3:</strong></p>

<pre>
<strong>Input:</strong> n = 3
<strong>Output:</strong> 246
</pre>

<p><strong>Example 4:</strong></p>

<pre>
<strong>Input:</strong> n = 7
<strong>Output:</strong> 106494
</pre>

<p><strong>Example 5:</strong></p>

<pre>
<strong>Input:</strong> n = 5000
<strong>Output:</strong> 30228214
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == grid.length</code></li>
	<li><code>grid[i].length == 3</code></li>
	<li><code>1 &lt;= n &lt;= 5000</code></li>
</ul>