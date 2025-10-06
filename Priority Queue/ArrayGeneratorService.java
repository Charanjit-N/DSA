/*

Array Generator Service
Your project team is collaborating with a group of software testers who have requested an array generator service to assist in testing software functionality.

Problem Statement
The service takes the following input parameters:

arr: An array of n positive integers.
state: A string of n characters, where:
'1' indicates that the corresponding arr[i] is available for selection.
'0' indicates that arr[i] is blocked initially.
m: The number of operations to perform.
Operations
To generate an integer sequence S, perform exactly m operations as follows:

Choose any available arr[i] (where state[i] = '1'). The same element can be chosen multiple times.
Append the selected arr[i] to S.
Update the state:
Any state[i] = '0' where state[i-1] = '1' is changed to '1'.
This means that blocked elements adjacent to available ones become available.

Objective
---------
Find the lexicographically largest sequence S that can be obtained after exactly m operations.

Example:
--------
arr = [10, 5, 7, 6]
state = "0101"
m = 2
Operations:
Step	AvailableElements	Chosen Element	Updated State
1	    {5, 6}	            6	            "0111"
2	    {5, 6, 7}	        7	            "0111"
Output
S = [6, 7]
Since [6, 7] is lexicographically larger than [5, 6] or [5, 5], this is the optimal solution.
*/



// TC ->O(m +n ) SC->O(n+m)
import java.util.*;

public class ArrayGeneratorService {

    static List<Integer> solve(int[] v, String s, int m) {
        int n = v.length;
        List<Integer> ret = new ArrayList<>();
        int mx = Integer.MIN_VALUE;
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                mx = Math.max(mx, v[i]);
                q.add(i + 1); 
            }
        }

        if (q.isEmpty()) return ret;

       
        while (m-- > 0) {
            ret.add(mx);
            int qs = q.size();
            while (qs-- > 0) {
                int i = q.poll();
                if (i != n && s.charAt(i) == '0') {
                    mx = Math.max(mx, v[i]);
                    q.offer(i + 1);
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] v = {10, 5, 7, 6};
        String s = "0101";
        int m = 2;

        List<Integer> result = solve(v, s, m);
        for (int x : result) {
            System.out.print(x + " ");
        }
        // Expected Output: 6,7
    }
}
