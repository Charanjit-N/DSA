class LCM1423MaxSumOfKElementsChoosenFromEndsOfArray {
    public int maxScore(int[] cardPoints, int k) {

        // Optimal : TC -> O(2K) , SC->O(1)
        int n = cardPoints.length;
        int leftSum = 0, rightSum = 0, maxSum = 0;
        for(int i=0;i<k;i++){
            leftSum += cardPoints[i];
        }
        
        maxSum = leftSum;

        int r = n-1;

        for(int i=k-1;i>=0;i--){
            leftSum -= cardPoints[i];
            rightSum += cardPoints[r];
            r--;
            maxSum = Math.max(maxSum , (leftSum+rightSum));
        }
        return maxSum;
        
    }
}