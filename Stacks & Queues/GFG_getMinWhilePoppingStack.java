

//Efficient , TC->O(n) for _getMInAtPop()

class GetMin {
    public static Stack<Integer> _push(int arr[], int n) {
        // code here
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<arr.length;i++){
            st.push(arr[i]);
        }
        return st;
        
    }
    static void _getMinAtPop(Stack<Integer> s) {
        
        // code here
        Stack<Integer> s2 = new Stack<>();
        while(!s.isEmpty()) s2.push(s.pop());
        ArrayList<Integer> ls = new ArrayList<>();
        
        while(!s2.isEmpty()){
            if(ls.size()==0) ls.add(s2.pop());
            else ls.add(Math.min(s2.pop(), ls.get(ls.size()-1)));
        }
        for(int i=ls.size()-1;i>=0;i--){
            System.out.print(ls.get(i)+" ");
        }
    }
}



// Brute : TC->O(n^2) for  for _getMInAtPop()

class GetMin {
    public static Stack<Integer> _push(int arr[], int n) {
        // code here
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<arr.length;i++){
            st.push(arr[i]);
        }
        return st;
        
    }
    static void _getMinAtPop(Stack<Integer> s) {
        
        // code here
        while(!s.isEmpty()){
            Stack<Integer> s2 = (Stack<Integer>)s.clone();
            int min = Integer.MAX_VALUE;
            while(!s2.isEmpty()){
                min = Math.min(min,s2.pop());
            }
            System.out.print(min+" ");
            s.pop();
        }
    }
}



