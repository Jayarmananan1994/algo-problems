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
where the sum of any `2` numbers in `S` is not evenly divisible by `K`.

```
Sample Input

Function
--------
S[] size n = 4, k = 3
S = [1, 7, 2, 4]

Sample Output

3

```
__Solution:__
Sum of two numbers `a` and `b` are divisible by number `n` if the reminder of `a` divided by `n` 
and `b` divided by `n` is also divided by `n`. 
For example, lets take [8,3,4] and n=3 . Here 8%3(2) +4%3(1) = 3 which is again divisile by 3.
So 8 and 4 cannot be together.

So first we have to create list containing the reminder. For example if s[] = [1,3,2,4,6,11] and `k=7`
then the reminder list will be `[1,3,2,4,6,4]`. Now we can traverse through the list. 
In the resultant subset we can have either `1` or `6` . 
Here, frequency of 1 is equal to 6. So either 1 or 6 has to go into result list
then, frequency of 3 is less than 4, so we have to include 4.
next 2 can go into list since there is no number with reminder 5.

In end we have result list [1,2,4,6,4] . So the max length of non-divisible subset is 5.



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

### 4. Climb up the Leaderboard

An arcade game player wants to climb to the top of the leaderboard and track their ranking. The game uses Dense Ranking, so its leaderboard works like this:

The player with the highest score is ranked number  on the leaderboard.
Players who have equal scores receive the same ranking number, and the next player(s) receive the immediately following ranking number.
```
Example
ranked = [100,90,90,80]
player = [70,80,105]

```
The ranked players will have ranks 1,2,2, and 3, respectively. 
If the player's scores are 70, 80 and 105, their rankings after each game are 4th, 3rd and 1st. 
Return `[4,3,1]`.

__Solution:__

First we need to either construct a map of ranking for the `ranked`. For
example for `[100,90,90,80]` the ranking list should be like `[1,2,2,3]`.

Next we need to find the correct position where the player score can fit it.
Let's example lets take the score `70` for the input ranked list `[100,90,90,80]`.
`70` is lesser than last ranked score `80`. so it should rank 5. To obtain that
we can traverse the list and compare them with each element in ranked. If any of the element in ranked list is lesser that the score with which we compare, then the score will take rank of that particular element. 
The rank for that element can be obtained from the rank list that we generated earlier. The two other case is if the score is greater than first element it will be ranked 1 and if it is less than last element 
it will be ranked +1 of the last ranked element. For better performance try using the binary search. 

### 5. Repeated String

There is a string, s, of lowercase English letters that is repeated infinitely many times. Given an integer,n, 
find and print the number of letter a's in the first n letters of the infinite string.

```
Example

s = 'abcac'
n=10
```

The substring we consider is `abcacabcac`, the first 10 characters of the infinite string. 
There are 4 occurrences of a in the substring.

### 6. Queen's Move:

You will be given a square chess board with one queen and a number of obstacles placed on it. 
Determine how many squares the queen can attack.

A queen is standing on an nxn chessboard. The chess board's rows are numbered from 1 to n, going from bottom to top. Its columns are numbered from 1 to n, going from left to right. 
Each square is referenced by a tuple, (r,c), describing the row, r, and column, c, where the square is located.

The queen is standing at position . In a single move, she can attack any square in any of the eight directions (left, right, up, down, and the four diagonals). In the diagram below, the green circles denote all the cells the queen can attack from :

There are obstacles on the chessboard, each preventing the queen from attacking any square beyond it on that path. For example, an obstacle at location  in the diagram above prevents the queen from attacking cells , , and :

Given the queen's position and the locations of all the obstacles, find and print the number of squares the queen can attack from her position at (r_q,c_q). In the board above, there are 24 such squares.
```
Sample Input 1

5 3
4 3
5 5
4 2
2 3

Sample Output 0

10

Explanation 1

The queen is standing at position 4x3 on a 5x5  chessboard with k=3 obstacles:

The number of squares she can attack from that position is 10.
```