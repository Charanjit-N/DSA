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
class LCM2AddTwoLinkedLists {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // TC->O(max(size of l1, size of l2))
        // SC-> O(1) {Taking space of O(max(size of l1, size of l2)) to return result no extra space is used to solve the problem.}
        ListNode dummyNode = new ListNode(-1); 
        ListNode temp = dummyNode; 
        int carry = 0;
        while( l1 != null || l2 != null) {
            int sum = 0; 
            if(l1 != null) {
                sum += l1.val; 
                l1 = l1.next; 
            }
            
            if(l2 != null) {
                sum += l2.val; 
                l2 = l2.next; 
            }
            
            sum += carry; 
            carry = sum / 10; 
            ListNode nd = new ListNode(sum % 10); 
            temp.next = nd; 
            temp = temp.next; 
        }

        if(carry != 0){
            ListNode nd = new ListNode(carry); 
            temp.next = nd; 
        }

        return dummyNode.next;
        
    }
}