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
