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
class LCE876MiddleElementOfLinkedList {
    public ListNode middleNode(ListNode head) {
        //Slow and Fast pointer concept : TC-> O(n/2) {single pass}, SC->O(1)
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

        // Brute Force : Tc -> O(n + n/2) = O(n) {double pass}, SC->O(1)
        // int len = 0;
        // ListNode temp = head;
        // while(temp!=null){
        //     temp = temp.next;
        //     len++;
        // }
        // int cnt = 0;
        // temp = head;
        // while(temp!=null){
        //     cnt++;
        //     if(cnt == (len+2)/2) {
        //         return temp;
        //     }
        //     temp = temp.next; 
        // }
       
        // return null; 
        
    }
}