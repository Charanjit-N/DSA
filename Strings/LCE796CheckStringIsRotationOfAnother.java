class LCE796CheckStringIsRotationOfAnother{
    public boolean rotateString(String s, String goal) {
        //  Approach 1 :  T.C-> O(n) , S.C-> O(n)
        //  if (s.length()!= goal.length()) return false; 
        //  return (s + s).contains(goal);

        // Approach 2 :  Using Queues T.C -> O(n), S.C-> O(n)
        Queue<Character> q1 = new LinkedList<>(); 
        Queue<Character> q2 = new LinkedList<>();  

        for(int i =0;i<s.length();i++){
            q1.add(s.charAt(i));
        }
        for(int i =0;i<goal.length();i++){
            q2.add(goal.charAt(i));
        }

        int k = q2.size();

        while(k!=0){
            char ch = q2.peek();
            q2.poll(); // removes first element in queue
            q2.add(ch); // add it to last 
            if(q1.equals(q2)) return true;
            k--;
        }
        return false;
        
    }
}