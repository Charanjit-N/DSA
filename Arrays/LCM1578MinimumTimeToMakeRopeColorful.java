// TC -->O(N)
class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        int i=1;
        int sum = neededTime[0];
        int max =  neededTime[0];
        int ans = 0;
        while(i < n){
            if(colors.charAt(i)==colors.charAt(i-1)){
                sum += neededTime[i];
                max = Math.max(max,neededTime[i]);
                if(i == n-1){
                    ans += (sum-max);
                }
            }else{
                ans +=   (sum - max);
                max =neededTime[i];
                sum = neededTime[i];
            }
            i++;
        }
        return ans;       
    }
}


