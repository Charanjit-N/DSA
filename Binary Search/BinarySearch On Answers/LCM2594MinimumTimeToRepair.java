/* 
Intuition :  Binary Search On Answers
When you come to a conclusion that we need to minimize the maximum of each case or the other way round like maximize the minimum of each case apply Binary Search on Answer that we need to find (Ex : Leetcode 2594 : Minimum Time to repair , We see that there are many possible distributions of cars among the mechanics and in each case we needed  the maximum time taken by mechanic and we need to minimize that at the end So here the answer we need to find is "time taken to repair" So apply Binary Search for finding time.
*/

// TC-> O(n * log K) k-> range of binary search = min(ranks)*(cars^2) - min(ranks)
// SC->O(1)

class LCM2594MinimumTimeToRepair{
    public long repairCars(int[] ranks, int cars) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int x :  ranks){
            min = Math.min(min, x);
            max =  Math.max(max, x);
        }
        long low = min, high = max* (long)cars*cars;
        long ans = 0;
        while(low<=high){
            long mid = low + (high-low)/2;
            if(isPossibleToRepair(mid,ranks,cars)){
                ans = mid;
                high = mid -1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
    boolean isPossibleToRepair(long minutes, int[] ranks, int cars){
        long carsFixed=0;
        for(int rank : ranks){
            carsFixed =  carsFixed + (long)Math.sqrt(minutes/rank);
        }
        return carsFixed>=cars;
    }
}