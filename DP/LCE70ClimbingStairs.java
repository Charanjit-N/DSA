class Solution {
    int climb(int n ){
        if(n==0) return 1;
        if(n<0) return 0;
        return climb(n-1) + climb(n-2);
    }
    public int climbStairs(int n) {
        return climb(n);
    }
}