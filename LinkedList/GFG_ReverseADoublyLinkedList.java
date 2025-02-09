/*
class DLLNode {
    int data;
    DLLNode next;
    DLLNode prev;

    DLLNode(int val) {
        data = val;
        next = null;
        prev = null;
    }
}
*/
class GFG_ReverseADoublyLinkedList{
    public DLLNode reverseDLL(DLLNode head) {
       //TC->O(n) , SC->O(1)
       
        DLLNode temp1 = head;
        DLLNode temp2 = head;
        DLLNode before = null;
        while(temp1!=null){
            temp1 = temp1.next;
            temp2.next = before;
            temp2.prev = temp1;
            before = temp2;
            temp2 = temp1;
        }
        //pointer "before" will be our new head.
        return before;
    }
}