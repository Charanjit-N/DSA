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
class LCM61RotateLinkedList{
    //Optimal : TC->O(2N) , SC->O(1);
    public ListNode rotateLinkedList(ListNode head, int k) {
        if(head==null || head.next == null ) return head;
        ListNode tail = head;
        int len = 1;
        while(tail.next!=null){
            len++;
            tail = tail.next;
        }
        if(k%len ==0 ) return head;  // Implies K = length og LL.

        ListNode temp = head; 
        ListNode prev = null;
        int cnt = 0;
        while(temp!=null){
            cnt++;
            if(cnt == (len-(k%len))){
                prev = temp;
                temp = temp.next;
                prev.next = null;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        tail.next = head;
        head = temp;
        return head;

        /*Brute: K times carry out the opertaion of finding the last element of the linked list and putting it at the start.
        TC->O(k*N)
        SC->O(1)
        */
        
    }
}