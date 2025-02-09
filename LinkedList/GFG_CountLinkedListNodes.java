/*Complete the function below*/
/*
class Node{
    int data;
    Node next;
    Node(int a){  data = a; next = null; }
}*/

class GFG_CountLinkedListNodes {
    // Function to count nodes of a linked list.
    // TC -> O(n)
    public int getCount(Node head) {
        // code here
        Node temp = head;
        int len = 0;
        while(temp!=null){
            temp = temp.next;
            len++;
        }
        return len;
    }
}