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
class LCE21MergeTwoSortedLL {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // TC -> O(n) , SC->O(1)
        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                temp.next = list1;
                temp = list1;
                list1 = list1.next;
            }
            else{
                temp.next = list2;
                temp = list2;
                list2 = list2.next;
            }
        }
        if(list1 != null) temp.next = list1;
        else temp.next = list2;
        return dummyNode.next;
        
    }
}