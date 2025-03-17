// TC-> O(n * log K) k-> range of binary search = min(ranks)*(cars^2) - min(ranks)
// SC->O(1)

// Binary Search On Answers

class LCM2594_MinimumTimeToRepair {
    public long repairCars(int[] ranks, int cars) {
        int min = Integer.MAX_VALUE;
        for(int x :  ranks){
            min =  Math.min(x, min);
        }
        
        long low = min, high = min* (long)cars*cars;
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
        for(int rank : ranks){
            cars =  cars - (int)Math.sqrt(minutes/rank);
            if(cars <=0) return true;
        }
        return false;
    }
}