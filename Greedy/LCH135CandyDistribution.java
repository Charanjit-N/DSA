// TC->O(3N), SC->O(2N)
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        left[0] =1;
        for(int i=1;i<n;i++){
            if(ratings[i] > ratings[i-1]){
                left[i] = left[i-1]+1;
            }
            else{
                left[i] =  1;
            }
        }
        int[] right = new int[n];
        right[n-1] =1;
        for(int i=n-2;i>=0;i--){
            if(ratings[i] > ratings[i+1]){
                right[i] = right[i+1]+1;
            }
            else{
                right[i] =  1;
            }
        }
        int sum = 0;
        for(int i=0;i<n;i++){
            sum += Math.max(left[i], right[i]);
        }
        return sum;
    }
}

// TC ->O(2N), SC->O(N)
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        left[0] =1;
        for(int i=1;i<n;i++){
            if(ratings[i] > ratings[i-1]){
                left[i] = left[i-1]+1;
            }
            else{
                left[i] =  1;
            }
        }
        int right = 1;
        int sum = Math.max(1,left[n-1]);
        for(int i=n-2;i>=0;i--){
            if(ratings[i] > ratings[i+1]){
                right++;
            }
            else{
                right =  1;
            }
            sum += Math.max(left[i],right);
        }
        return sum;
    }
}

// Optimal : TC->O(N), SC-->O(1)
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int i = 1;
        int sum =1;
        while(i<n){
            if(ratings[i]== ratings[i-1]){
                sum += 1;
                i++;
                continue;
            }
            int peak = 1;
            while(i<n && ratings[i]> ratings[i-1]){
                peak += 1;
                sum += peak;
                i++;
            }
            int down = 1;
            while(i<n && ratings[i]<ratings[i-1]){
                sum += down;
                down += 1;
                i++;
            }
            if(down > peak){
                sum += (down-peak);
            }
        }
        return sum;
    }
}