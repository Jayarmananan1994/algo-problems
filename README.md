#Code Challenges

Trying to solve few code challenges found online.


### 1. Find the smallest positive number that does not exist in array

You are given an unsorted array with both positive and negative elements.
You have to find the smallest positive number missing from the array.

```
Examples

Input:  {2, 3, 7, 6, 8, -1, -10, 15}
Output: 1

Input:  { 2, 3, -7, 6, 8, 1, -10, 15 }
Output: 4

Input: {1, 1, 0, -1, -2}
Output: 2
```

__Explanation:__

The least positive number starts from 1. So if n is the size of the 
array then the least positive number that does not exist in
the array should be between 1 and n+1. 

So we have to iterate from 1 to n and the number that does not 
exist in the array is the answer.


### 2. Non divisible subset

Given a set of distinct integers, print the size of a maximal subset of `S`
where the sum of any `2` numbers in `S'` is not evenly divisible by `K`.

```
Sample Input

Function
--------
S[] size n = 4, k = 3
S = [1, 7, 2, 4]

Sample Output

3

```
### 3. Magic Square
We define a magic square to be an  matrix of distinct positive integers from  to  where the sum of any row, column, or diagonal of length  is always equal to the same number: the magic constant.

You will be given a `3x3` matrix `s` of integers in the inclusive range `[1,9]`. We can convert any digit `a` to any other digit `b` in the range `[1,9]` at cost of |a-b|. Given s, convert it into a magic square at minimal cost. 
Print this cost on a new line.

Note: The resulting magic square must contain distinct integers in the inclusive range [1,9].

```
Example

$s = [[5, 3, 4], [1, 5, 8], [6, 4, 2]]

The matrix looks like this:

5 3 4
1 5 8
6 4 2
We can convert it to the following magic square:

8 3 4
1 5 9
6 7 2
This took three replacements at a cost of |5-8| + |8-9| + |4-7| = 7 .
```

__Solution:__

Since the digits can be used is between the range 1 to 9, the magic sum is 15, and it has 8 possible solution.
Flatten the input matrix and compare the input with 8 possible solution and 
find the cost as mentioned in the above problem statement.

Additionally, if the input matches with any of the solution (ie. have minimum cost) you can 
break out of loop.
