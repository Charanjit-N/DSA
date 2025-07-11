// Recursion :  TC-> >> O(2^n) as we are taking same index multiple times, SC-> O(bagWeight):recursion stack space
class KnapsackUnbounded{
    static int solve(int index, int wt, int[] weights,int[] values){
        if(index==0){
            return (wt/weights[0]) * values[0];
        }
        int notPick = 0 + solve(index-1 , wt, weights,values);
        int pick = (int)-1e9;
        if(weights[index] <= wt) pick = values[index] + solve(index, wt-weights[index],weights,values);
        return Math.max(pick, notPick);
    }S
    public static void main(String args[]){
        int[] weights = {2,4,6};
        int[] values ={5,11,13};
        int bagWeight = 10 ;
        int n = weights.length;
        System.out.println(solve(n-1, bagWeight,weights,values));
    }
}

//Memoization :  TC->O(n x bagWeight), SC->O(bagWeight):recursion stack space + O(n x bagWeight) : dp array
class KnapsackUnbounded{
    static int solve(int index, int wt, int[] weights,int[] values,int[][] dp){
        if(index==0){
            return (wt/weights[0]) * values[0];
        }
        if(dp[index][wt] != -1) return dp[index][wt];
        int notPick = 0 + solve(index-1 , wt, weights,values,dp);
        int pick = (int)-1e9;
        if(weights[index] <= wt) pick = values[index] + solve(index, wt-weights[index],weights,values,dp);
        return dp[index][wt] = Math.max(pick, notPick);
    }
    public static void main(String args[]){
        int[] weights = {2,4,6};
        int[] values ={5,11,13};
        int bagWeight = 10 ;
        int n = weights.length;
        int[][] dp =  new int[n][bagWeight+1];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        System.out.println(solve(n-1, bagWeight,weights,values,dp));
    }
}

//Tabulation :  TC->O(n x bagWeight), SC->O(n x bagWeight) : dp array
class KnapsackUnbounded{
    public static void main(String args[]){
        int[] weights = {2,4,6};
        int[] values ={5,11,13};
        int bagWeight = 10 ;
        int n = weights.length;
        int[][] dp = new int[n][bagWeight+1];
        for(int wt=0;wt<=bagWeight;wt++){
            dp[0][wt] = (wt/weights[0]) *  values[0];
        }
        for(int index = 1;index<n;index++){
            for(int wt = 0;wt<=bagWeight;wt++){
                int notPick = 0 + dp[index-1][wt];
                int pick = (int)-1e9;
                if(weights[index] <= wt) pick = values[index] + dp[index][wt-weights[index]];
                dp[index][wt] = Math.max(pick, notPick);
            }
        }
        System.out.println(dp[n-1][bagWeight]);
    }
}

//Tabulation with space optimization (2 arrays) :  TC->O(n x bagWeight), SC->O(2 * bagWeight) : extra arrays
class KnapsackUnbounded{
    public static void main(String args[]){
        int[] weights = {2,4,6};
        int[] values ={5,11,13};
        int bagWeight = 10 ;
        int n = weights.length;
        int[] prev = new int[bagWeight+1];
        int[] cur = new int[bagWeight+1];
        for(int wt=0;wt<=bagWeight;wt++){
            prev[wt] = (wt/weights[0]) *  values[0];
        }
        for(int index = 1;index<n;index++){
            for(int wt = 0;wt<=bagWeight;wt++){
                int notPick = 0 + prev[wt];
                int pick = (int)-1e9;
                if(weights[index] <= wt) pick = values[index] + cur[wt-weights[index]];
                cur[wt] = Math.max(pick, notPick);
            }
            for(int wt=0;wt<=bagWeight;wt++){
                prev[wt] = cur[wt];
            }
        }
        System.out.println(prev[bagWeight]);
    }
}



//Tabulation with space optimization (1 array) :  TC->O(n x bagWeight), SC->O(bagWeight) : extra array
class KnapsackUnbounded{
    public static void main(String args[]){
        int[] weights = {2,4,6};
        int[] values ={5,11,13};
        int bagWeight = 10 ;
        int n = weights.length;
        int[] prev = new int[bagWeight+1];
        for(int wt=0;wt<=bagWeight;wt++){
            prev[wt] = (wt/weights[0]) *  values[0];
        }
        for(int index = 1;index<n;index++){
            for(int wt = 0 ; wt<=bagWeight;wt++){
                int notPick = 0 + prev[wt];
                int pick = (int)-1e9;
                if(weights[index] <= wt) pick = values[index] + prev[wt-weights[index]];
                prev[wt] = Math.max(pick, notPick);
            }
        }
        System.out.println(prev[bagWeight]);
    }
}