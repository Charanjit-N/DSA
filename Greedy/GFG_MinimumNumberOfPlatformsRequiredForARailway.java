// TC->2*O(n * logn) = O(n*logn), SC->O(1)
class Solution {
    int findPlatform(int arr[], int dep[]) {
        int n = arr.length;
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i=0, j=0;
        int cnt = 0;
        int maxCnt = 0;
        while(i<n && j<n){
            if(arr[i] <= dep[j]){
                cnt++;
                maxCnt = Math.max(maxCnt, cnt);
                i++;
            }
            else{
                cnt--;
                j++;
            }
        }
        return maxCnt;
        
    }
}

// TC -> O(2n log(2n)) = O(n*logn), SC->(2n) =O(n)
class Pair{
    int time;
    char action;
    Pair(int time, char action){
        this.time = time;
        this.action = action;
    }
}
class Solution {
    int findPlatform(int arr[], int dep[]) {
        int n = arr.length;
        Pair[] p = new Pair[2*n];
        for(int i =0;i<n;i++){
            p[i]= new Pair(arr[i],'A');
        }
        for(int i =n;i<2*n;i++){
            p[i]= new Pair(dep[i-n],'D');
        }
        Arrays.sort(p, (x,y)->x.time-y.time);
        
        int cnt = 0;
        int maxCnt = Integer.MIN_VALUE;
        for(int i=0;i<2*n;i++){
            if(p[i].action == 'A'){
                cnt++;
                maxCnt = Math.max(maxCnt, cnt);
            }
            else cnt--;
        }
        return maxCnt;
    }
}



