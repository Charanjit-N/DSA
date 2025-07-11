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
class Solution {
    ListNode findMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    ListNode mergeTwoLL(ListNode headL, ListNode headR){
        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;
        while(headL != null && headR != null){
            if(headL.val < headR.val){
                temp.next = headL;
                temp = headL;
                headL = headL.next;
            }
            else{
                temp.next = headR;
                temp = headR;
                headR = headR.next;
            }
        }
        if(headL != null) temp.next = headL;
        else temp.next = headR;
        return dummyNode.next;
    }
    public ListNode sortList(ListNode head) {
        //Optimal : Using Merge Sort concept (Divide and Conquer)
        // TC-> O((n+n/2) * logn)   
        // SC-> O(logn) If we consider the recursion stack space. Depth of the recursion tree is O(log n) because each recursive call splits the list into halves, which results in a logarithmic number of levels of recursion. If we neglect this then SC->O(1) 
        if(head == null || head.next == null) return head;
        ListNode middle  = findMiddle(head);  // O(n/2)
        ListNode leftHead = head;
        ListNode rightHead = middle.next;
        middle.next = null;

        leftHead = sortList(leftHead);
        rightHead = sortList(rightHead);
        return mergeTwoLL(leftHead, rightHead);    // O(n)


        // Brute Force : TC->O(nlogn) , SC->O(n)
        // List<Integer> ls = new ArrayList<>();
        // ListNode temp = head;
        // while(temp != null){
        //     ls.add(temp.val);
        //     temp = temp.next;
        // }
        // Collections.sort(ls);
        // temp = head;
        // for(int i = 0; i < ls.size(); i++){
        //     temp.val = ls.get(i); 
        //     temp = temp.next; 
        // }
        // return head; 
         
    }
}