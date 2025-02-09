

/*Given an array nums of distinct integers, return all the possible 
permutations
. You can return the answer in any order.

Example 1:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

 */

// TC-> O(n * n!)   { n-> for loop , n!-> no.of permutations}
// SC-> O(n) + O(n) { n-> "ls" list , n-> marking array, neglecting recursion Stack(O(n)) and "ans" list O((n!)) space any way "ans" list is to return the answer we cant optimize it as it is asked in the problem statement that to return}

 class LCM46Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] marking = new boolean[nums.length]; 
        findPermutations(nums,marking,new ArrayList<>(), ans);
        return ans;
        
    }
    void findPermutations(int[] nums,boolean[] marking,List<Integer> ls, List<List<Integer>> ans){
        if(ls.size() == nums.length){
            ans.add(new ArrayList<>(ls));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(marking[i]!=true){
                marking[i]= true;
                ls.add(nums[i]);
                findPermutations(nums,marking,ls,ans);
                ls.remove(ls.size()-1);
                marking[i]= false;
            }
        }
    }
}

// Avoiding Extra Space (O(n)) for Map (marking array) by swapping array elements

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        findPermutations(0,nums, ans);
        return ans;
        
    }
    void findPermutations(int index, int[] nums,List<List<Integer>> ans){
        if(index == nums.length){
            List<Integer> ls = new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                ls.add(nums[i]);
            }
            ans.add(ls);
            return;
        }
        for(int i=index;i<nums.length;i++){
            swap(nums, index, i);
            findPermutations(index+1,nums,ans);
            swap(nums, index, i);
            
        }
    }
    void swap(int[] arr, int i , int j){
        arr[i] = arr[i]+arr[j]-(arr[j]=arr[i]);
    }

}