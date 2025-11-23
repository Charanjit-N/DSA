// Tabulation with space optimzation(one variable) TC->O(n), SC->O(1)
class Solution {
    public int findTheWinner(int n, int k) {
        int ans = 0;
        for(int i=2;i<=n;i++){
            ans  = (ans+k) % i;
        }
        return ans+1;
    }
}

// Tabulation with space optimzation(two variables) TC->O(n), SC->O(1)
class Solution {
    public int findTheWinner(int n, int k) {
        int prev = 0;
        int cur = 0;
        for(int i=2;i<=n;i++){
            cur = (prev+k) % i;
            prev = cur;
        }
        return cur+1;
    }
}

//  Tabulation :  TC ->O(n), SC->O(n)
class Solution {
    public int findTheWinner(int n, int k) {
        int[] dp = new int[n+1];
        dp[1] = 0;
        for(int i=2;i<=n;i++){
            dp[i] = (dp[i-1]+k) % i;
        }
        return dp[n]+1;
    }
}

// Memoization :  TC ->O(n), SC->O(n)
class Solution {
    int solve(int n, int k,int[] dp){
        if(n==1) return 0;
        if(dp[n] != -1)return dp[n];
        return dp[n] = (solve(n-1,k,dp) + k) % n;
    }
    public int findTheWinner(int n, int k) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n,k,dp)+1;
    }
}

// Recursion :TC ->O(n), SC->O(n): recursion stack space
class Solution {
    int solve(int n, int k){
        if(n==1) return 0;
        return (solve(n-1,k) + k) % n;
    }
    public int findTheWinner(int n, int k) {
        return solve(n,k)+1;
    }
}


// Using queue  TC->O(n x k), SC->O(k)
class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=n;i++) q.add(i);
        while(q.size()>1){
            for(int i=1;i<k;i++){
                q.add(q.poll());
            }
            q.poll();
        }
        return q.peek();
    }
}



// Using list remove mthid TC ->O(n^2), SC->O(n)class Solution {
class Solution {
    public int findTheWinner(int n, int k) {
        List<Integer> ls = new ArrayList<>();
        for(int i=1;i<=n;i++) ls.add(i);
        int startIndex = 0;
        while(ls.size()>1){
            int removeIndex =  (startIndex + k - 1)%ls.size();
            ls.remove(removeIndex);
            startIndex = removeIndex;
        }
        return ls.get(0);
        
    }
}