class LCM1423MaximumPointsYouCanObtainFromCards {
    public int maxScore(int[] cardPoints, int k) {
        int total = 0; 
        int j=cardPoints.length-1;
        int i;
        for (i = 0; i < k; i++) {
            total = total + cardPoints[i];
        }
        i--;
        int max = total;

        while (i >= 0) {
            
            total = total - cardPoints[i] + cardPoints[j];
            i--;
            j--;

            max = Math.max(max, total);
            
        }
        return max;
     
      
    }
}