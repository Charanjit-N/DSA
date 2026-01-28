// Recursion : TC -> Exponential (TLE) 
class Solution {
    static final int MOD = (int)1e9 + 7;
    int solve(int idx, int p1, int p2, int p3, int n) {
        if (idx == n) return 1;
        long ways = 0;
        for (int c1 = 1; c1 <= 3; c1++) {
            for (int c2 = 1; c2 <= 3; c2++) {
                for (int c3 = 1; c3 <= 3; c3++) {
                    if (c1 == c2 || c2 == c3) continue;
                    if (c1 == p1 || c2 == p2 || c3 == p3) continue;
                    ways += solve(idx + 1, c1, c2, c3, n);
                }
            }
        }
        return (int)(ways % MOD);
    }
    public int numOfWays(int n) {
        return solve(0, 0, 0, 0, n);
    }
}

// Memoization :  TC -> O(n), SC->O(n)

// dp[idx][prev1][prev2][prev3] = number of ways to color rows from idx to n-1 given previous row (idx-1) colors are prev1, prev2, prev3 (idx → current row index prev1, prev2, prev3 ∈ {0,1,2,3} here 0 means “no previous row” (that is for idx = 0))
// state count : n x 4 x 4 x 4 = 64n
// Transitions : 3 x 3 x 3 = 27 possibilities per state
// Total TC : O(n × 64 × 27) ≈ O(n)
class Solution {
    static final int MOD = (int)1e9+7;
    Integer[][][][] dp;
    int solve(int idx, int p1, int p2, int p3, int n) {
        if (idx == n) return 1;
        if (dp[idx][p1][p2][p3] != null) return dp[idx][p1][p2][p3];
        long ways = 0;
        for (int c1 = 1; c1 <= 3; c1++) {
            for (int c2 = 1; c2 <= 3; c2++) {
                for (int c3 = 1; c3 <= 3; c3++) {
                    if (c1 == c2 || c2 == c3) continue;
                    if (c1 == p1 || c2 == p2 || c3 == p3) continue;
                    ways += solve(idx + 1, c1, c2, c3, n);
                }
            }
        }
        return dp[idx][p1][p2][p3] = (int)(ways % MOD);
    }
    public int numOfWays(int n) {
        dp = new Integer[n][4][4][4];
        return solve(0, 0, 0, 0, n);
    }
}


// Tabulation :O(n x 64 x 27) ≈ O(n)
class Solution {
    static final int MOD = (int)1e9 + 7;
    int[][][][] dp;
    public int numOfWays(int n) {
        dp = new int[n + 1][4][4][4];
        // Base case: if(idx == n) → 1 way 
        for (int p1 = 0; p1 < 4; p1++) {
            for (int p2 = 0; p2 < 4; p2++) {
                for (int p3 = 0; p3 < 4; p3++) {
                    dp[n][p1][p2][p3] = 1;
                }
            }
        }
        for (int idx = n - 1; idx >= 0; idx--) {
            for (int p1 = 0; p1 < 4; p1++) {
                for (int p2 = 0; p2 < 4; p2++) {
                    for (int p3 = 0; p3 < 4; p3++) {
                        long ways = 0;
                        // Try all color combinations for current row
                        for (int c1 = 1; c1 <= 3; c1++) {
                            for (int c2 = 1; c2 <= 3; c2++) {
                                for (int c3 = 1; c3 <= 3; c3++) {
                                    if (c1 == c2 || c2 == c3) continue;
                                    if (c1 == p1 || c2 == p2 || c3 == p3) continue;
                                    ways += dp[idx + 1][c1][c2][c3];
                                }
                            }
                        }
                        dp[idx][p1][p2][p3] = (int)(ways % MOD);
                    }
                }
            }
        }
        return dp[0][0][0][0]; // Start with "no previous row"
    }
}


// DP with Space Optimization (only two states)
// TC -> O(n), SC->O(1)
class Solution {
    public int numOfWays(int n) {
        long MOD = (int)1e9 + 7;
        long same = 6; 
        long diff = 6; 
        for (int i = 2; i <= n; i++) {
            long newSame = (same * 3 + diff * 2) % MOD;
            long newDiff = (same * 2 + diff * 2) % MOD;
            same = newSame;
            diff = newDiff;
        }
        return (int)((same + diff) % MOD);
    }
}