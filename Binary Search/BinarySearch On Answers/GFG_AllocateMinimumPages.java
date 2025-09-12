// TC->O(n * log(sum of elements in arr - max element in arr))
class Solution {
    int countStudents(int[] arr, int maxPages){
        int students = 1;
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            if(sum + arr[i] <= maxPages){
               sum += arr[i];
            }
            else{
                students++;
                sum = arr[i];
            }
        }
        return students;
    }
    public int findPages(int[] arr, int k) {
        if(k > arr.length) return -1;
        int sum = 0;
        int  max = Integer.MIN_VALUE;
        for(int x : arr){
            max =  Math.max(max, x);
            sum +=  x;
        }
        int low = max;
        int high = sum;
        int ans =-1;
        while(low <= high){
            int mid =  low + (high - low)/2;
            int students =  countStudents(arr, mid);
            if(students <= k){
                ans = mid;
                high = mid-1;
            } 
            else {
                low = mid+1;
            }
        }
        return ans; // (or) return low;
    }
}


// Brute Force :
// TC->O(n * (sum of elements in arr - max element in arr))
class Solution {
    int countStudents(int[] arr, int maxPages){
        int students = 1;
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            if(sum + arr[i] <= maxPages){
               sum += arr[i];
            }
            else{
                students++;
                sum = arr[i];
            }
        }
        return students;
    }
    public int findPages(int[] arr, int k) {
        if(k > arr.length) return -1;
        int sum = 0;
        int  max = Integer.MIN_VALUE;
        for(int x : arr){
            max =  Math.max(max, x);
            sum +=  x;
        }
        int low = max;
        int high = sum;
        int ans = 0;
        for(int i=low;i<=high;i++){
            if(countStudents(arr,i) <= k){
                ans =  i;
                break;
            }
        }
        return ans;
    }
}

