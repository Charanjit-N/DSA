// Binary Search On Answers
class LCM2226MaxCandiesAllocatedToKChildren {
    public int maximumCandies(int[] candies, long k) {
        int max =  Integer.MIN_VALUE;
        long sum = 0;
        for(int x : candies){
            max =  Math.max(max, x);
            sum+=x;
        }
        if(sum<k) return 0;

        int low =  1;
        int high  = max;
        int ans = 0;
        while(low<=high){
            int mid = low +(high-low)/2;
            long val = solve(mid, candies);
            System.out.println("-->"+low+" "+high+" "+mid+" "+val);
            if(val >= k){
                ans =  mid;
                low = mid+1;
            }
            else high = mid-1;
        }
        return ans;
    }
    long solve(int x, int[] candies){
        long val =0 ;
        for(int i=0;i<candies.length;i++){
            val  = val + candies[i]/x;
        }
        return val;
    }
}

 // Brute Force : max(candies[i]) * n  (n-> length oof candies array)

// class LCM2226MaxCandiesAllocatedToKChildren {
    // public int maximumCandies(int[] candies, long k) {
        // int max =  Integer.MIN_VALUE;
        // long sum = 0;
        // for(int x : candies){
        //     max =  Math.max(max, x);
        //     sum+=x;
        // }
       
        // if(sum<k) return 0;

        // for(int maxCandies = max;maxCandies>=1;maxCandies--){
        //     long cnt = 0;
        //     for(int j=0;j<candies.length;j++){
        //         cnt = cnt + candies[j]/maxCandies;
        //     }
        //     if(cnt >= k) return maxCandies;
        // }
        // return 0;
//     }
// }