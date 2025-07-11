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
class LCM2095DeleteMiddleNodeInLL {
    public ListNode deleteMiddle(ListNode head) {
        // Optimal : Using Slow and fast pointers
        // TC-> O(N)  , SC->O(1) 
        if(head == null || head.next==null) return null;
        ListNode slow = head;
        ListNode fast = head.next.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return head;
        
        // Brute  :  TC->O(N + N/2)), SC->O(1)
        // if(head==null) return head;

        // ListNode temp = head;
        // int len =0;
        // while(temp!=null){
        //     len++;
        //     temp = temp.next;
        // }
        
        // int fromStart = -1; 
        // temp = head;
        // ListNode prev = null;
        // while(temp!=null){
        //     fromStart++;
        //     if(fromStart == len/2){
        //         prev.next = temp.next;
        //         break;
        //     }
        //     prev = temp;
        //     temp = temp.next;
        // }
        // return head;
    }
}