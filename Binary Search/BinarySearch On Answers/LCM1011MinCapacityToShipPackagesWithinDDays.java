// T.C --> O( n * log(sum of array elements - max array element) ) 
class Solution {
    int calculateDays(int[] arr,int capacity){
        int sum=0;
        int noOfDays = 1;    // First Day
        for(int i=0;i<arr.length;i++){
            if(sum + arr[i] > capacity){
                noOfDays += 1;
                sum = arr[i];
            }
            else{
                sum += arr[i];
            }
        }
        return noOfDays;
    }
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        if(days>n) return -1;
        int maxCap=0,minCap=0,ans=0;
        for(int i=0;i<n;i++) {
            // minimum capacity of the ship should be max weight if not that weight can never be shipped
            if(weights[i]>minCap){
                minCap=weights[i];  
            }
            //maximum Capacity = sum of all weights => shipping can be done in just one day
            maxCap += weights[i];    
        }
        int low = minCap, high = maxCap;
        while (low <= high) {
            int mid = (low + high) / 2;
            int numberOfDays = calculateDays(weights, mid);
            if (numberOfDays <= days) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
        
    }
}