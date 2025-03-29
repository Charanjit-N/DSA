Class InterviewBit_NearestSmallerElementOnTheLeft {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        ArrayList<Integer> bse = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<A.size();i++){
            while(!st.isEmpty() && st.peek()>=A.get(i)){
                st.pop();
            }
            if(st.isEmpty()) bse.add(-1);
            else bse.add(st.peek());
            st.push(A.get(i));
        }
        return bse;
    }
}