
// Brute Force : TC->O(n^2), SC->O(1)
class Solution{
    int[] subarrayWithGivenSum(int[] arr, int sum){
        int n = arr.length;
        int start = -1;
        int end = -1;
        for(int i=0;i<n;i++){
            int curSum = 0;
            start = i;
            for(int j=i;j<n;j++){
                curSum += arr[j];
                if(curSum == sum){
                    end = j;
                    return new int[]{start, end};
                }
            }
        }
        return new int[]{-1,-1};
    }
}


// Sliding Window : TC->O(n), SC->O(1)
// Optimal if the array has only +ve numbers and zeros 
// This approach doesnt work if the array has -ve numbers
class Solution{
    int[] subarrayWithGivenSum(int[] arr, int sum){
        int n = arr.length;
        int curSum = 0;
        int left = 0 , right = 0;
        while(right<n){
            curSum +=  arr[right];
            while(curSum > sum && left < right){
                curSum -= arr[left];
                left++;
                
            }
            if(curSum == sum){
                return new int[]{left, right};
            }
            right++;
        }
        return new int[]{-1,-1};
    }
}


// Optimal even if we have -ve numbers  in array
// TC->O(n), SC->O(n)
class Solution{
    int[] subarrayWithGivenSum(int[] arr, int sum){
        int n = arr.length;
        int curSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            curSum += arr[i];
            if(curSum == sum){
                return new int[]{0,i};
            }
            int rem = curSum - sum;
            if(map.containsKey(rem)){
                int start = map.get(rem)+1;
                int end = i;
                return new int[]{start , end};
            }
            map.put(curSum, i);
        }
        return new int[]{-1,-1};
    }
}