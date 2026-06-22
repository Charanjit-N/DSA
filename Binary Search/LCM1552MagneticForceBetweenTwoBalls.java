// TC --> O(n * logn + n*logD) = O(n*logn) , sc -> O(1) + O(log n ): sort function recursive stack space 
class Solution {
    boolean canWePlace(int minGap, int[] position, int m){
        int count = 1; 
        int lastPlaced = position[0];
        for (int i = 1; i < position.length; i++) {
            if (position[i] - lastPlaced >= minGap) {
                count++;
                lastPlaced = position[i];

                if (count >= m) {
                    return true;
                }
            }
        }

        return false;
    }
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int len = position.length;
        int low = 1;
        int high = position[len-1] - position[0];
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(canWePlace(mid,position,m)){
                ans = mid;
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return ans;
    }
}