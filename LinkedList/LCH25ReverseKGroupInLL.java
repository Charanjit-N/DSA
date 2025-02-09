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

    ListNode getKThNode(ListNode temp, int k){
        k = k-1;
        while(temp!=null && k>0){
            k--;
            temp = temp.next;
        }
        return temp;
        
    }
    
    ListNode reverseLL(ListNode head){
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
    }
    public ListNode LCH25ReverseKGroupInLL(ListNode head, int k) {
        // Optimal Method 2: TC->O(2N) , SC->O(1) 
        ListNode temp = head;
        ListNode prevLast = null;
        while(temp!=null){
            ListNode kThNode = getKThNode(temp, k);
            if(kThNode == null){
                if(prevLast != null) prevLast.next = temp;
                break;
            }
            ListNode nextNode = kThNode.next;
            kThNode.next = null;
            reverseLL(temp);
            if(temp== head) head = kThNode;
            else prevLast.next = kThNode;

            prevLast = temp;
            temp = nextNode;
        }
        return head;

        // Optimal Method 1: TC->O(2N) , SC->O(1)
        // int cnt = 0;
        // ListNode left =  head;
        // ListNode right = head;
        // ListNode temp = head;
        // ListNode revTail = null;
        
        // while(temp != null){
        //     cnt++;
        //     if(cnt == k ){
        //         right = temp;
        //         temp = temp.next;
        //         right.next = null;
        //         head = reverseLL(left); 
        //         revTail = left;
        //         left = temp;
        //         break;
        //     }
        //     temp = temp.next;
        // }

        // cnt = 0;
        
        // while(temp!=null){
        //     cnt++;
        //     if(cnt == k){
        //         right = temp;
        //         temp = temp.next;
        //         right.next = null;
        //         revTail.next = reverseLL(left);
        //         revTail = left;
        //         left =temp;
        //         cnt = 0;
        //     }
        //     else{
        //          temp = temp.next;
        //     }
        // }
        // if(cnt != 0 && temp == null){
        //         revTail.next = left;

        // }
        // return head;
        
    }
}