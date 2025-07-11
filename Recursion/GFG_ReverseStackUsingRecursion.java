class GFG_ReverseStackUsingRecursion
{ 
    // static void pushingAtBottom(Stack<Integer> s , int temp){  TC->O(n)
    //     if(s.isEmpty()){
    //         s.push(temp);
    //         return;
    //     }
    //     int val = s.peek();
    //     s.pop();
    //     pushingAtBottom(s,temp);
    //     s.push(val);
        
    // }
    
    static Queue<Integer> q = new LinkedList<>();
    
    static void reverse(Stack<Integer> s)  
    {
        // Approach 1 : 
        /*TC->O(n^2){The reverse function is called  n times, 
        and each call to reverse subsequently calls a few pushingAtBottom() functions, 
        that take O(n) time.}
         SC->O(n) {The space complexity due to the recursion
          stack will be O(n) since the maximum depth 
          of recursion will be n.
        */
        // if(s.size()==1) return;
        // int temp = s.peek();
        // s.pop();
        // reverse(s);
        // pushingAtBottom(s,temp);
        
        // Approach 2 (Better): Reversing  a stack using recusion with the help of a FIFO Data Structure (queue)
        //TC-> O(n) {n->recursion depth} , SC->O(n + n ) {n-> queue , n-> recursion stack space}
        if(s.isEmpty()) return;
        q.offer(s.peek());
        s.pop();
        reverse(s);
        s.push(q.peek());
        q.poll();
    }
}