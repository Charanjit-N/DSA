// TC->O(n * log(Max array element −Min array element))
class Solution {
    boolean canWeMake(int[] arr,int days,int m,int k){
        int len = arr.length; 
        int flowerCount = 0;
        int noOfBouq = 0;
        // Counting the number of bouquets:
        for (int i = 0; i < len; i++) {
            if (days >=arr[i]) {
                flowerCount++;
            } else {
                noOfBouq += (flowerCount / k);
                flowerCount = 0;
            }
        }
        noOfBouq += (flowerCount / k);
        return (noOfBouq >= m) ? true:false;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int n=bloomDay.length;
        if((long)m*k > n) return -1;
        // Since in constraints given 1<=bloomDay[i]<=10^9 took 0 instead of Integer.max and min;
        int max =0, min =0; 
        for(int i=0;i<n;i++){
            if(bloomDay[i]>max) max=bloomDay[i];
            if(bloomDay[i]<min) min=bloomDay[i];
        }
        // binary searching the minimum days.
        int low=min,high =max;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(canWeMake(bloomDay,mid,m,k) == true) high = mid-1;
            else low = mid+1;
        }
        return low;
    }
}