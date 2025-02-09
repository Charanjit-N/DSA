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
class GFG_DeleteAllOccurancesOfGivenKeyInDLL {
    static Node deleteAllOccurOfX(Node head, int x) {
        // Write your code here
        Node temp = head;
        while(temp!=null){
            if(temp.data == x){
                if(temp==head){
                    head=head.next;
                }
                
                Node nextNode = temp.next;
                Node prevNode = temp.prev;
                if(nextNode != null) nextNode.prev = prevNode;
                if(prevNode != null) prevNode.next = nextNode;
                temp = nextNode;
            }
            else{
                temp = temp.next;
            }
        }
        
        return head;
        
    }
}