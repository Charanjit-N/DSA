/*
https://leetcode.com/problems/permutation-sequence/description/

The set [1, 2, 3, ..., n] contains a total of n! unique permutations.
By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Example 1:
Input: n = 3, k = 3
Output: "213"
*/


// Optimal :  TC-> approx O(n^2)


// Sort the array or object on which you are searching for kth permutation lexicographical/dictionary sequence if not in sorted then extra O(nlogn) : for sorting
class LCH60KthPermutationSequence {
    public String getPermutation(int n, int k) {
        int fact = 1;
        ArrayList<Integer> ls = new ArrayList< >();
        for(int i=1;i<=n;i++){
            fact = fact * i;
            ls.add(i);
        }
        String ans ="";

        fact = fact/n;
        k = k-1;
     
        while(true){
            
            ans = ans + ls.get(k/fact);
            ls.remove(k/fact);   //O(n)
            if(ls.size()==0) break;
            k = k % fact;
            fact = fact/ls.size();


        }
        return ans;
        
    }
}


// Better : TC->O(n!)

// Sort the array or object on which you are searching for kth permutation lexicographical/dictionary sequence if not in sorted then extra O(nlogn) : for sorting

class Solution {
    public String getPermutation(int n, int k) {

        List<List<Integer>> ans = new ArrayList<>();
        boolean marking[] = new boolean[n];
        findPermutations(n,marking,new ArrayList<>(),ans);
        // System.out.println(ans);
        StringBuilder sb = new StringBuilder();

        for (Integer num : ans.get(k-1)) {
            sb.append(num);
        }

        return sb.toString();
        

    }

    void findPermutations(int n,boolean[] marking,List<Integer> ls, List<List<Integer>> ans ){
        if(ls.size() == n){
            ans.add(new ArrayList<>(ls));
            return;
        }
        for(int i=0;i<marking.length;i++){
            if(marking[i] == false){
                marking[i]= true;
                ls.add(i+1);
                findPermutations(n,marking,ls,ans);
                ls.remove(ls.size()-1);
                marking[i]=false;
            }
        }
    }                                                                   
}