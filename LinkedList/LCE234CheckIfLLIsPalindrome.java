/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class LCE234CheckIfLLIsPalindrome{
    // Brute Force : TC->O(2N) , SC->O(N)
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode temp = head;
        while(temp!=null){
            stack.push(temp.val);
            temp = temp.next;
        }
        temp = head;
        while(temp!=null){
            if(temp.val != stack.pop()) return false;
            temp = temp.next;
        }
        return true;
        
    }
}