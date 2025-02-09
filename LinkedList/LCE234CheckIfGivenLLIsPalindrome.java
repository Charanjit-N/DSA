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
class LCE234CheckIfGivenLLIsPalindrome {
     ListNode reverseLL(ListNode head){
        ListNode temp1 =head;
        ListNode temp2 =head;
        ListNode prev = null;
        while(temp1!=null){
            temp1 = temp1.next;
            temp2.next = prev;
            prev = temp2;
            temp2 = temp1;
        }
        return prev;
    }
    
    public boolean isPalindrome(ListNode head) {
        // Optimal : TC->O( n/2 + n/2 + n/2 + n/2 ) = O(2N) = O(N) (approximation) , SC->O(1)
        if(head==null || head.next==null) return true;
        ListNode slow = head;
        ListNode fast =head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode node = reverseLL(slow.next);
        ListNode first = head;
        ListNode second = node;
        
        while(second!=null){
            if(first.val != second.val) { 
                // making LL normal as given
                reverseLL(node);

                return false;
            }

            first = first.next;
            second = second.next;
        }
        // making LL normal as given
        reverseLL(node);
        return true;


        // Brute Force : TC->O(2N) , SC->O(N)
        // Stack<Integer> stack = new Stack<>();
        // ListNode temp = head;
        // while(temp!=null){
        //     stack.push(temp.val);
        //     temp = temp.next;
        // }
        // temp = head;
        // while(temp!=null){
        //     if(temp.val != stack.pop()) return false;
        //     temp = temp.next;
        // }
        // return true;
        
    }
}