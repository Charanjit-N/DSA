/* Structure of Doubly Linked List
class Node
{
	int data;
	Node next;
	Node prev;
	Node(int data)
	{
	    this.data = data;
	    next = prev = null;
	}
}*/

class GFG_DLLInsertionAtGivenPosition
{
    //Function to insert a new node at given position in doubly linked list.
    void addNode(Node head_ref, int pos, int data)
	{
		// TC->O(n) , SC->O(1)
	   //if(head_ref ==  null)  return;
       Node x = new Node(data);
       Node temp = head_ref;
       int cnt = 0;
       while(temp!=null){
           cnt++;
           if(cnt == (pos+1))  break;
           temp = temp.next;
       }
       if(temp.next == null){
           temp.next = x;
           x.prev = temp;
           return;
       }
       x.next = temp.next;
       x.prev = temp;
       temp.next.prev = x;
       temp.next = x;
	}
}