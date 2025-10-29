// Brute Force TC->O(n^3), SC->O(1)
class Solution{
    int countTripletsSumDividibleByD(int[] arr, int d){
        int cnt = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    if(((arr[i]+arr[j]+arr[k]) % d) ==0) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}


// Optimal usiing hashing TC->O(n^2), SC->O(n);
class Solution{
    int countTripletsSumDividibleByD(int[] nums, int d){
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        int cnt = 0;
        for(int j=0;j<n;j++){
            for(int k=j+1;k<n;k++){
                int rem =  (d - ((nums[j]+nums[k])%d) + d )%d;
                cnt += map.getOrDefault(rem,0);
            }
            map.put(nums[j]%d , map.getOrDefault(nums[j]%d , 0)+1);
        }
        return cnt;
    }
}


