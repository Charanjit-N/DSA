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
class LCM19RemoveNthNodeFromEndOfLL{
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Optimal : Using Slow and fast pointers
        // TC-> O(N) (N->LinkedList size) , SC->O(1) 
        if(head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        for(int i=0;i<n;i++){
            fast = fast.next;
        }
        if(fast == null){   // Head is the node to be deleted
            head = head.next;
            return head;
        }
        while(fast.next!=null){
            fast=fast.next;
            slow =slow.next;
        }
        slow.next = slow.next.next;
        return head;
        // Brute  :  TC->O(N+ (N-n)) (N->Linked List Size), SC->O(1)
        // if(head==null) return head;

        // ListNode temp = head;
        // int len =0;
        // while(temp!=null){
        //     len++;
        //     temp = temp.next;
        // }
        // if(n==len){                   // deleting head
        //     head = head.next;
        //     return head;
        // }
        // int fromStart = 0; 
        // temp = head;
        // ListNode prev = null;
        // while(temp!=null){
        //     fromStart++;
        //     if(fromStart == len-n+1){
        //         prev.next = temp.next;
        //         break;
        //     }
        //     prev = temp;
        //     temp = temp.next;
        // }
        // return head;

        
      
    }
}