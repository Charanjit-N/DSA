/*
You are given two integers n and k where n represents the total number of people who are standing in a circle, and k represents the person who gets killed in each iteration.You need to find which person is the last man standing. The indexing here starts from zero. The counting starts from the zeroth person and after each killing, the counting resets and start from the next neighbor of the killed person.
*/
// TC->O(n), SC->O(n) 
class Solution {
    public static int josephus(int n, int k) {
        
        // Your code here
        LinkedList<Integer> ls = new LinkedList<>();
        for(int i=0;i<n;i++) ls.add(i);
        
        int i = 0;
        while(ls.size()>1){
            i =  (i+k-1) % ls.size();
            ls.remove(i);
        }
        return ls.get(0);
    }
}



// Using recursion , TC->O(n), SC->O(n) : recursion stack space
class Solution {
    public static int josephus(int n, int k) {
        if (n == 1) {
            return 0;
        } else {
            return (josephus(n - 1, k) + k) % n;
        }
    }
}