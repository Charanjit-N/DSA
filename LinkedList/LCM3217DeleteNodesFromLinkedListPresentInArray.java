// TC ->O(n), SC->O(n)
class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for(int x : nums) set.add(x);
        ListNode nd = head;
        ListNode temp2 = new ListNode(-1);
        ListNode dummy = temp2;
        while(nd != null){
            if(!set.contains(nd.val)){
                temp2.next = nd;
                temp2 = temp2.next;

            }
            nd = nd.next;
            
        }  
        temp2.next = null;  
        return dummy.next;    
    }
}