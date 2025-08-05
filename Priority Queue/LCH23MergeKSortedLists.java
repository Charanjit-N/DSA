

// Optimal Using heap/Priority Queue:
// TC->→O(k*logK) + O(KN*(log(K))) 
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
 class Pair{
    int nodeVal;
    ListNode node;
    Pair(int nodeVal, ListNode node){
        this.nodeVal = nodeVal;
        this.node = node;
    }
 }
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Pair> pq =  new PriorityQueue<>((x,y)->x.nodeVal-y.nodeVal);
        for (ListNode head : lists) {
            if (head != null) {
                pq.add(new Pair(head.val, head));
            }
        }
        ListNode dummyHead = new ListNode(-1);
        ListNode temp = dummyHead;
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            ListNode smallNode = p.node;
            temp.next = smallNode;
            temp = temp.next;
            if (smallNode.next != null) {
                pq.add(new Pair(smallNode.next.val, smallNode.next));
            }
        }
        return dummyHead.next;
    }
}