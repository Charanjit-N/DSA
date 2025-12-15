// TC --> O(n), SC-->O(1)
class Solution {
    public int countCollisions(String directions) {
        int n = directions.length();
        char prev = directions.charAt(0);
        int ans = 0;
        int righStreak = (prev == 'R') ?  1 : 0;
        for(int i=1;i<n;i++){
            char cur =  directions.charAt(i);
            if(cur == 'R') righStreak++;
            if(prev == 'R' && cur == 'L' ){
                ans += 2;
                ans += (righStreak-1);
                prev ='S';
                righStreak = 0;
            }
            else if(prev =='R' && cur =='S'){
                ans += (righStreak*1);
                prev ='S';
                righStreak = 0;
            }
            else if(prev =='S' & cur =='L'){
                ans += 1;
                prev ='S';
            }
            else{
                prev = cur;
            }
        }
        return ans;
    }
}



// TC --> O(n), SC-->O(1)
class Solution {
    public int countCollisions(String directions) {
        int n = directions.length();
        int l = 0;
        int r = n - 1;
        while (l < n && directions.charAt(l) == 'L') {
            l++;
        }

        while (r >= l && directions.charAt(r) == 'R') {
            r--;
        }
        int res = 0;
        for (int i = l; i <= r; i++) {
            if (directions.charAt(i) != 'S') {
                res++;
            }
        }
        return res;
    }
}