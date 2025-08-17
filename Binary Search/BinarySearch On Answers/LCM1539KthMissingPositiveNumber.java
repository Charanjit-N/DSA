// optimal : TC->O(log n), SC->O(1)


//Optimal :  T.C-> O(logn) , S.C->O(1)
class Solution {
    public int findKthPositive(int[] arr, int k) {  
        int n = arr.length;
        int low = 0, high = n-1;
        while(low<=high){
            int mid = low+(high - low)/2;
            int missing = arr[mid] - (mid+1);
            if(missing<k) low = mid+1;
            else high = mid-1;

        }
        return high+1+k; // (or) return low + k ;
    }
}

// Better: T.C->O(n), S.C->O(1);
class Solution {
    public int findKthPositive(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= k) k++; //shifting k
            else break;
        }
        return k;
    }
}

// Brute Force: T.C->O(n^2), S.C->O(1);
class Solution {
    boolean isPresent(int[] arr, int x){
        for(int num :  arr){
            if(num == x) return true;
        }
        return false;
    }
    public int findKthPositive(int[] arr, int k) {
        int ans = 0; 
        int i = 1;
        int cnt = 0;
        while(true){
            if(!isPresent(arr,i)) cnt++;
            if(cnt == k){
                ans = i;
                break;
            }
            i++;
        }
        return ans;
    }
}