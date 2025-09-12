class LCE232ImplementingQueueUsingStacks {

    Stack<Integer> s1;
    Stack<Integer> s2;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
        
    }
    
    // O(2N)
    public void push(int x) {    //offer()
        while(!s1.isEmpty()){
            s2.push(s1.peek());
            s1.pop();
        }
        s1.push(x);
        while(!s2.isEmpty()){
            s1.push(s2.peek());
            s2.pop();
        }
        
    }
    
    //O(1)
    public int pop() {    //poll()
        return s1.pop();
        
    }
    
    //O(1)
    public int peek() {    
        return s1.peek();
        
    }
    
    //O(1)
    public boolean empty() {
        return s1.isEmpty();  
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */