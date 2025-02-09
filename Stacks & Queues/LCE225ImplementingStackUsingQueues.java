class LCE225ImplementingStackUsingQueues {
    // Using Two queues
    Queue<Integer> q1;
    Queue<Integer> q2;
    public MyStack() {          
        q1=new LinkedList<>();
        q2=new LinkedList<>();
    }
    
    public void push(int x) {     // O(2N)
    
        while(!q1.isEmpty()){
            q2.offer(q1.poll());
        }

        q1.offer(x);

        while(!q2.isEmpty()){
            q1.offer(q2.poll());
        }
       
    }
    
    public int pop() {      //O(1)
        return q1.poll();
    }
    
    public int top() {     //O(1)
        return q1.peek();
        
    }
    
    public boolean empty() {     //O(1)
        return q1.isEmpty();
    }

    // using Single Queue
    // Queue<Integer> q;

    // public MyStack() {
    //     q = new LinkedList<>();
    // }
    
    // public void push(int x) {     //O(N)
    //     int s = q.size();
    //     q.add(x);
    //     for(int i=1;i<=s;i++){
    //         q.add(q.peek());
    //         q.poll();
    //     }
    // }
    
    // public int pop() {       //O(1)
    //     return q.poll();
        
    // }
     
    // public int top() {       //O(1)
    //     return q.peek();
        
    // }
    
    // public boolean empty() {         //O(1)
    //     return q1.isEmpty();
    // }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.offer(x);
 * int param_2 = obj.poll();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */