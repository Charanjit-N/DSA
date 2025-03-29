class LCM901OnlineStockSpan {
    // Optimal (using monotonic stack "pge" concept)
    // Over All for all next() function calls  : TC-> O(2N) SC->O(N) {N -> number of total next() function calls}

    Stack<Pair<Integer,Integer>> st;
    int index;
    public LCM901OnlineStockSpan() {
        st = new Stack<>();
        index = -1;
        
    }
    public int next(int price) {
        index = index+1;
        while(!st.isEmpty()&& st.peek().getKey() <= price){
            st.pop();
        }
        int pge  = st.isEmpty() ? -1 : st.peek().getValue();
        int ans = index - pge;
        st.push(new Pair<>(price,index) );
        return ans;
    }

    /* Brute : Using ArrayLIist and for each next() call iterate through list to find the <= elements
    // For every next() call :  TC->O(No of days till now) , SC->O(No.of next() calls till now)
    ArrayList<Integer> ls;

    public LCM901OnlineStockSpan() {
        ls = new ArrayList<>();   
    }
    public int next(int price) {
        int cnt = 0;
        for(int i=ls.size()-1;i>=0;i--){
            if(ls.get(i) > price) break;
            cnt++;
        }
        ls.add(price);
        
        return cnt+1;
    }
    */
}

/**
 * Your LCM901OnlineStockSpan object will be instantiated and called as such:
 * LCM901OnlineStockSpan obj = new LCM901OnlineStockSpan();
 * int param_1 = obj.next(price);
 */