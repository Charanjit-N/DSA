
class FrogJump2 {
    static int jump(int index,int[] heights, int k){
        if(index ==0) return 0;
        int minVal = Integer.MAX_VALUE;
        for(int a = 1 ;a<=k;a++){
            
            if( index-a >= 0) {
               int energy = jump(index-a, heights,k) + Math.abs(heights[index]-heights[index-a]); 
                minVal = Math.min(minVal, energy);
            }
            
        }
        return minVal;
    }
    public static void main(String[] args){
        int[] heights = {10,5,20,0,15};
        int k =2;
        System.out.println(jump(heights.length-1,heights, k));
    }
}

// Memoization 
class FrogJump2 {
    static int jump(int index,int[] heights, int k, int[] dp){
        if(index ==0) return 0;
        if(dp[index] != -1) return dp[index];
        int minVal = Integer.MAX_VALUE;
        for(int a = 1 ;a<=k;a++){
            if( index-a >= 0) {
               int energy = jump(index-a, heights,k, dp) + Math.abs(heights[index]-heights[index-a]); 
               minVal = Math.min(minVal, energy);
            }
        }
        return dp[index] = minVal;
    }
    public static void main(String[] args){
        int[] heights = {10,5,20,0,15};
        int n = heights.length;
        int k =2;
        int[] dp =  new int[n];
        Arrays.fill(dp,-1);
        System.out.println(jump(n-1,heights, k, dp));
    }
}

// Tabulation 
class FrogJump2 {
    public static void main(String[] args){
        int[] heights = {10,5,20,0,15};
        int k =2;
        int n = heights.length;
        int[] dp = new int[n];
        for(int i=1;i<n;i++){
            int minVal = Integer.MAX_VALUE;
            for(int a = 1;a<=k;a++){
                int energy =0;
                if( i-a >= 0) {
                    energy = dp[i-a] + Math.abs(heights[i]-heights[i-a]); 
                    minVal = Math.min(minVal, energy);
                }   
            }
            dp[i] = minVal;
        }
        System.out.println(dp[n-1]);
    }
}

