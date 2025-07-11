class Solution {
    public int LCM201BitwiseAndOfNumbersInRange(int left, int right) {
        // Optimal 1: TC-> O(logn) : O(log(Max(left,right))), SC->O(1)
        int shiftCount=0;
        while(left!=right){
            left =  left>>1;
            right = right>>1;
            shiftCount++;
            
        }
        return left<<shiftCount; // or right<<shiftCount; as left == right then while breaks;

        // Optimal 2:  TC-> almost O(logn) -> we are avoiding some cases of brue force, SC->O(1)
        // while(right>left){
        //     right = right & (right-1);
            
        // }
        // return right;

        // Brute Force : TLE : tC->O(n), SC->O(1)
        // int and = left;
        // for(int i=left+1;i<=right;i++){
        //     and = and & i;
        // }
        // return and;
        
    }
}