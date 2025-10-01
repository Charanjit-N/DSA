// TC ->O(n) , SC->O(n)
class Solution {
    public int distinctPoints(String s, int k) {
        int n = s.length();
        if(n == k) return 1;
        int left =0, right =0, up=0,down=0;
        int x = 0, y=0;
        for(int i=0;i<s.length();i++){
            char ch  = s.charAt(i);
            if(ch == 'L') x--;
            else if(ch =='R') x++;
            else if(ch == 'U') y++;
            else y--;
        }
        Set<Long> set = new HashSet<>();
        for(int a =0;a<k;a++){
            char ch = s.charAt(a);
            if(ch == 'L') left++;
            else if(ch == 'R') right++;
            else if(ch == 'U') up++;
            else down++;
        }
        int i = 0, j= k-1;
        while(j < n){    
            int curX = x;
            int curY = y;
            curX += left;
            curX -= right;
            curY -= up;
            curY += down;
            set.add(1000000L*curX +  curY);
    
            char ch1 = s.charAt(i);
            if(ch1 == 'L') left--;
            else if(ch1 == 'R') right--;
            else if(ch1 == 'U') up--;
            else down--;
            i++;
            j++;
            if(j<n){
                char ch2 = s.charAt(j);
                if(ch2 == 'L') left++;
                else if(ch2 == 'R') right++;
                else if(ch2 == 'U') up++;
                else down++;
            }
        }
        return set.size();
    }
}