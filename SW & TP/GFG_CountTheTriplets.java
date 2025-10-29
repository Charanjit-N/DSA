//Better : TC ->O(n^2 * logn)
class Solution {
    boolean binarySearch(int sum, int low, int high,int arr[]){
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == sum) {
                return true;
            }
            else if (arr[mid] > sum) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return false;
    }
    int countTriplet(int arr[], int n){
        Arrays.sort(arr);
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (binarySearch((arr[i] + arr[j]), j + 1, n - 1,arr)) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}


// Optimal :TC -->O(n^2)
class Solution {
    int countTriplet(int arr[]){
        int n = arr.length;
        Arrays.sort(arr);
        int cnt = 0;
        for(int i=n-1;i>=0;i--){
            int j=0;
            int k = i-1;
            while(j < k){
                int sum = arr[j] + arr[k];
                if(sum == arr[i]){
                    cnt++;
                    j++;
                    k--;
                }
                else if(sum > arr[i]){
                    k--;
                }
                else{
                    j++;
                }
            }
        }
        return cnt;
        
    }
}


