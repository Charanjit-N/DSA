/*
class Node {
    int data;
    Node next;

    Node() { data = 0; }
    Node(int d) { data = d; }  //constructor to create a new node
}
*/
class GFG_ArrayToLinkedList {
    static Node constructLL(int arr[]) {
        // code here
        // TC->O(n);
        Node head = new Node(arr[0]);
        Node mover = head;
        for(int i=1;i<arr.length;i++){
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover =  mover.next;  // (or) mover = temp;
        }
        return head;
    }
}
