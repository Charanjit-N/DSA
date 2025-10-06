/*
Problem statement:
-------------------
The warehouse head wants to measure the efficiency of the way parcels are shipped. The volume of each parcel is represented in an array parcel. Each day, the first and last parcels in the array are shipped until all of them are dispatched.

The head comes up with metrics to calculate warehouse efficiency. Each day before shipping, any parcel in the warehouse is chosen, and its volume is added to the sum of total efficiency. A parcel can only be chosen once.

Given the array parcel, find the maximum possible efficiency of the warehouse.

Constraints:
1 <= T <= 10^5
1 <= n <= 10^5
0 <= parcel[i] <= 10^9
The sum of n over all test cases doesn't exceed 10^5

Sample Input:
4
4
1 5 5 2
6
4 4 8 5 3 2
7
2 1 8 5 6 2 4
3
2 0 3

Sample Output:
10
17
23
3

*/


// TC ->T(n*logn ), SC->O(n)

public class Solution {
    int solve(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for (int val : arr) sum += val;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n / 2; i++) {
            pq.offer(-arr[i]);
            pq.offer(-arr[n - 1 - i]);
            sum += pq.peek();
            pq.poll();
        }
        return sum;
    }

   
}
