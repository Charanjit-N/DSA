// Better  : Two pointers , TC-->O(n), SC-->O(n)
class Solution {
        public String removeDuplicates(String s, int k) {
        int i = 0, n = s.length();
        int[] cnt = new int[n];
        char[] arr = s.toCharArray();
        for (int j = 0; j < n; ++j, ++i) {
            arr[i] = arr[j];
            cnt[i] = ( i > 0 && arr[i - 1] == arr[j] ) ? (cnt[i - 1] + 1) : 1;
            if (cnt[i] == k) i -= k;
        }
        return new String(arr, 0, i);
    }
}


// using stack : TC-->O(n) , SC-->O(n)
class Pair{
    char ch;
    int cnt;
    Pair(char ch , int cnt){
        this.ch = ch;
        this.cnt = cnt;
    }
}
class Solution {
    public String removeDuplicates(String s, int k) {
        int n = s.length();
        Stack<Pair> st = new Stack<>();
        int cnt = 0;
        for(int i=0;i<n;i++){
            char x = s.charAt(i);
            if(!st.isEmpty() && st.peek().ch == x){
                st.peek().cnt++;
                if(st.peek().cnt == k){
                    st.pop();
                } 
            }else{
                st.push(new Pair(x,1));
            }
        }
        String ans ="";
        while(!st.isEmpty()){
            Pair p = st.pop();
            int count = p.cnt;
            char ch = p.ch;
            for(int i=1;i<=count;i++){
                ans  = ch + ans;
            }
        }
        return ans;
    }
}