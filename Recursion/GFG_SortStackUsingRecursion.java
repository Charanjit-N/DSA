class GFG_SortStackUsingRecursion {
    /*TC->O(n^2){The sortStack() function is called  n times, 
        and each call to sortStack() subsequently calls a few insert() functions 
        that takes O(n) time.}
      SC->O(n) {The space complexity due to the recursion
          stack will be O(n) since the maximum depth 
          of recursion will be n.
    */

    void insert(Stack<Integer> s, int temp){
        if(s.size()==0 || s.peek()<=temp){
            s.push(temp);
            return;
        }
        int val = s.peek();
        s.pop();
        insert(s,temp);
        s.push(val);
        return;
    }
    
    void sortStack(Stack<Integer> s){
        if(s.size()==1) return;
        int temp = s.peek();
        s.pop();
        sortStack(s);
        insert(s,temp);
    }
    public Stack<Integer> sort(Stack<Integer> s) {
        // add code here.
        sortStack(s);
        return s;
    }
}