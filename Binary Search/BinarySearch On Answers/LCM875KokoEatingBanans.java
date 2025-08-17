//T.C --> O(n * log(max array element))
class Solution {
    long timeTaken(int[] arr,int eatingRate){
        long time = 0;
        for(int i=0;i<arr.length;i++){
            time = time + (long)Math.ceil((double)arr[i]/eatingRate);
        }
        return time;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int len = piles.length;
        int maxPile = 0;
        for(int i=0;i<len;i++){    
            if(piles[i]>maxPile) maxPile =piles[i];
        }
        int low = 1,high = maxPile;
        int ans = 0;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(timeTaken(piles,mid)<=h){
                ans = mid;
                high = mid-1;
            }
            else low = mid+1;
        }
        return ans;
    // Brute Force: T.C -->  O( Max element in array * n ) , SC--> O(1)
    //     int len = piles.length;
    //     int maxPile = 0;
    //     int ans = 0;
    //     for(int i=0;i<len;i++){    
    //         if(piles[i]>maxPile) maxPile =piles[i];
    //     }
    //     for(int rate=1;rate<=maxPile;rate++){
            
    //         int time = timeTaken(piles,rate);   // This function : TC->O(n)
    //         if(time<=h) { ans =rate; break;}
    //     }
    //     return ans; 
    }
}