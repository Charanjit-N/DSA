// TC -> O(n), SC->O(1)
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || left == right ) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode lb = dummy;

        for(int i=0;i<left-1;i++){
            lb = lb.next;
        }
        ListNode temp1 = lb.next;
        ListNode temp2 =  temp1;
        ListNode prev = null;
        for(int i=0;i<= right - left  ;i++){
            temp1 =  temp1.next;
            temp2.next = prev;
            prev = temp2;
            temp2 = temp1;
        }

        lb.next.next =  temp1; // = temp2
        lb.next = prev;

        return dummy.next;
        
    }
}