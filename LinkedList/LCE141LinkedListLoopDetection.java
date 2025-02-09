/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class LCE141LinkedListLoopDetection {
    public boolean hasCycle(ListNode head) {
        // Optimal : Fast and Slow pointers : T.C -> O(n) , SC->O(1)
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return  true;
        }
        return false;

        //Brute Force : TC-> O(n), SC->O(n)
        // Map<ListNode,Integer> map = new HashMap<>();
        // ListNode temp = head;
        // while(temp!=null){
        //     if(map.containsKey(temp)) return true;
        //     map.put(temp,1);
        //     temp= temp.next;
        // }
        // return false;

        
    }
}