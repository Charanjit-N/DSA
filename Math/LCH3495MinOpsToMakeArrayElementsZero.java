/*Intuition :
To reduce a number n to 0 by repeated division by say x we need floor(logₓn) + 1 operations. So we can group numbers based on the no. of operations they need.
All numbers in [1, 3] (i.e., from 4⁰ to 4¹ - 1) require 1 division.
All numbers in [4, 15] (i.e., from 4¹ to 4² - 1) require 2 divisions.
All numbers in [16, 63] (i.e., from 4² to 4³ - 1) require 3 divisions.
and so on

Approach :
Now 4¹⁶ is greater than 1e9 so we need to atmost 16 intervals which is sufficient to cover all the numbers given in the range [l, r] of each query.
Which is what is done in code, i.e., for each query:
d represents the number of divisions required for numbers in a particular range.
prev is set to 4 ^ (d - 1) (the start of the interval).
cur is 4 ^ d (so the interval is [prev, cur − 1]).
now we check overlap of numbers with each interval and add to operations the no. of divisions required i.e., (length of interval) * d.
Then, we slide the interval (prev = cur) --> d = 1 : [1, 3] -> d = 2 : [4, 15] -> d = 3 : [16, 63]...
Finally, since we can choose 2 numbers at a time we would need ceil(total operations / 2).  */

//TC-> O(n): n-> Queries.length , SC->O(1) 
class LCH3495MinOpsToMakeArrayElementsZero {
    public long minOperations(int[][] queries) {
        long ans =0 ;
        for(int[] query  : queries){
            long start = query[0] , end = query[1];
            long operations = 0;
            long L = 1;
            for(int i=1;i<=16;i++){   // i-> number of divisions
                long R = L * 4;
                // Find the intersection between the query interval [start, end] and [L, R - 1]
                long a = Math.max(start, L);
                long b = Math.min(end , R-1);
                if(b >= a){
                    operations += (b-a+1)*i;
                }
                L = R;
            }
            // Each operation can take 2 digits and do floor(num/4), so ceil(operations / 2)
            ans += (operations + 1)/2;
        }
        return ans;
    }
}