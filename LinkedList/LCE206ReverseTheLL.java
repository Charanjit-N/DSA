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
class LCE206ReverseTheLL {
    public ListNode reverseList(ListNode head) {
        // Optimal : TC->O(N) , SC->O(1)
        ListNode temp1 = head;
        ListNode temp2 = head;
        ListNode prev = null;
        while(temp1 != null){
           temp1 = temp1.next;
           temp2.next = prev;
           prev = temp2;
           temp2 = temp1;
        }
        return prev;

        // Optimal (2) : Using recurssion TC->O(N) , SC->O(N) for recurssive stack space
        
        // if(head == null || head.next == null) return head;

        // ListNode newHead = reverseList(head.next);

        // ListNode front = head.next;
        // front.next = head;
        // head.next = null;

        // return newHead;


        // Brute Force :  as stack is LIFO push LL elements into stack and then set LL values by stack pop()
        // TC->O(2N) , SC->O(N)
        // Stack<Integer> stack = new Stack<>();
        // ListNode temp = head;
        // while(temp!=null){
        //     stack.push(temp.val);
        //     temp = temp.next;
        // }
        // temp = head;
        // while(temp!=null){
        //     temp.val = stack.pop();
        //     temp = temp.next;
        // }
        // return head;
        
    }
}