import java.util.*;
class LCM155ConstructMinStack {
    // Optimal : OPtimized SC to: SC->O(N)
    
    long min;
    Stack<Long> st;

    public LCM155ConstructMinStack() {
        st = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {      // TC->O(1)
        if(st.isEmpty()) {
            min = val;
            st.push((long)val);
        }
        else {
            if(val >= min) st.push((long)val);
            else{
                st.push(2*(long)val-min);
                min = val;
            }
        }
    }
    
    public void pop() {       // TC->O(1)
        if(st.isEmpty()) return;
        long x = st.peek();
        st.pop();
        if(x < min){
            min = 2*min - x;
        }
    }
    
    public int top() {           // TC->O(1)
        if(st.isEmpty()) return -1;
        long x = st.peek();
        if(x < min) return (int)min;
        return (int)x; 
        
    }
    
    public int getMin() {          // TC->O(1)
        return (int)min;
        
    }

    
    // Better : SC->O(2N) (2 elements in each pair , N such pairs in our stack);

    // Stack<Pair<Integer, Integer>> st;

    // public MinStack() {
    //     st = new Stack<>();
    // }
    
    // public void push(int val) {      // TC->O(1)
    //     if(st.isEmpty()){
    //         st.push(new Pair<>(val,val));
    //     }
    //     else{
    //         st.push(new Pair<>(val,Math.min(val,st.peek().getValue())));
    //     }
    // }
    
    // public void pop() {       // TC->O(1)
    //     st.pop();
        
    // }
    
    // public int top() {           // TC->O(1)
    //     return st.peek().getKey();
        
    // }
    
    // public int getMin() {          // TC->O(1)
    //     return st.peek().getValue();
        
    // }
    

    // Brute Force : For getMin() method traverse and find the minimum. Takes TC->O(N) for getMin().

}




/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */