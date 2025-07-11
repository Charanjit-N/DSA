/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/
class GFG_LinkedListInsertionAtEnd {
    // Function to insert a node at the end of the linked list.
    Node insertAtEnd(Node head, int x) {

        // TC -> O(n)

       Node  newNode=new Node(x);

        //if the list is empty
        
        if(head==null)  return newNode;
        
        //if list contain elements, store the first element value in one node
        
        Node last=head;
        
        //check for the last node
        
        while(last.next!=null)   { last=last.next; }
        
        //add the newNode at the last node
        
        last.next=newNode;
        
        //return the newNode value
        
        return head; 
    }
}