
/*
Each wizard must wait for both the previous wizard to finish brewing the same potion and their own completion of the previous potion.
The start time of each wizard is: max(pre wizard time to brew, time required for prev potion)

For the second potion, the wizard i + 1 can start working when:
wizard i + 1 is done with the first potion
wizard i is done with the second potion.
that is, max(arr[i + 1], arr[i]).
Now, we need to make sure there are no delays.

For that, we go back from the last to the first wizard, and adjust array to remove any gap.
*/

// TC ->O(m*n), SC->O(n)
class LCM3494MinimumAmountOfTimeToBrew {

    long minTime(int[] skill, int[] mana) {
        int n = skill.length;
        int m = mana.length;
        long[] arr = new long[n + 1];
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++)
                arr[i + 1] = Math.max(arr[i+1],arr[i]) + mana[j] * skill[i];
            
            for (int i = n - 1; i > 0; i--)
                arr[i] = arr[i + 1] - (long)mana[j] * skill[i]; 
            
              
        }
        return arr[arr.length-1];
    }
}

// Brute Force : Binary Search on Possible Answers
// TC-> O(N∗Log(Range)), SC->O(N)
class LCM3494MinimumAmountOfTimeToBrew {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length;
        int m = mana.length;
        int start = 0;
        long arr[] = new long[n+1];
        arr[0] = start;
        for(int i=1;i<=n;i++){
            arr[i] = arr[i-1] + mana[0] *skill[i-1];
        }
        // System.out.println(Arrays.toString(arr));
        //  System.out.println("-------------"); 
        long sum1  = 0, sum2 = 0;
        for(int x : skill){ sum1 += x;}
        for(int y :  mana) { sum2 += y;}
        long maxTime = sum1*sum2;
        
        for(int i=1;i<m;i++){
            long secondLast= arr[n];
            long low  = secondLast;
            long high = maxTime;
            while(low<=high){
                long mid = low +(high-low)/2;
                boolean bool = check(mid,arr,skill,mana[i]);
                // System.out.print(low +" "+high+" "+mid+" "+bool);
                if(bool == true){
                    secondLast  =mid;
                    high = mid-1;
                    
                }
                else{
                    low = mid+1;
                }
                // System.out.println("   Latest SL=" + secondLast);
            }
            arr[n-1] = secondLast;
            arr[n] = secondLast + skill[n-1]*mana[i];
            for(int x=n-2;x>=0;x--){
                arr[x] = arr[x+1] - skill[x]*mana[i];
            }
           // System.out.println(Arrays.toString(arr)); 
            // System.out.println("-------------"); 
        }
        return arr[n];
    }
    
    boolean check(long secondLast , long[] arr,int[] skill,int mana){
        int len = arr.length;
        long var = secondLast;
        for(int i = len-2;i>=1;i--){
            var = var - mana*skill[i-1];
            // System.out.println(i+" -->"+var+" ");
            if(var < arr[i]) return false;
        }
        return true;
    }
}