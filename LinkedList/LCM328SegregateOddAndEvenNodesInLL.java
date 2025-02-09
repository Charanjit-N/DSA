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
class LCM328SegregateOddAndEvenNodesInLL {
    public ListNode oddEvenList(ListNode head) {
        // TC -> O(N) , SC->O(1)
        if(head == null) return null;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode firstEven = head.next;
        while(even!=null && even.next!=null){  // O(N/2) * 2
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }
        odd.next  = firstEven;
        return head;

        // Brute : TC->O(2N) , SC->O(1)
        // if(head == null || head.next == null) return head;
        // List<Integer> ls = new ArrayList<>();
        // ListNode temp = head;
        // while(temp!=null && temp.next!=null){  // O(N/2)
        //     ls.add(temp.val);
        //     temp = temp.next.next;
        // }
        // if(temp!=null) ls.add(temp.val);

        // temp = head.next;
        // while(temp!=null && temp.next!=null){  // O(N/2)
        //     ls.add(temp.val);
        //     temp = temp.next.next;
        // }
        // if(temp!=null) ls.add(temp.val);

        // int i=0;
        // temp = head;
        // while(temp!=null){    //O(N)
        //     temp.val = ls.get(i);
        //     i++;
        //     temp = temp.next;
        // }
        // return head;
    }
}