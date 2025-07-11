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
public class LCM142LinkedListLoopStartingNode{
    public ListNode detectCycle(ListNode head) {
        // Optimal : Fast and Slow pointers : T.C -> O(n) , SC->O(1)
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                slow = head;
                while(slow !=fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow; // (or) return fast;
            }
        }
        return null;

        //Brute Force : TC-> O(n), SC->O(n)
        // Map<ListNode,Integer> map = new HashMap<>();
        // ListNode temp = head;
        // while(temp!=null){
        //     if(map.containsKey(temp)) return temp;
        //     map.put(temp,1);
        //     temp= temp.next;
        // }
        // return  null;
        
    }
}