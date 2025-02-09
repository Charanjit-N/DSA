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

class Solution {
    
    // Node reverseLL(Node head){
    //     Node temp1 = head;
    //     Node temp2 = head;
    //     Node prev = null;
    //     while(temp1 != null){
    //         temp1 = temp1.next;
    //         temp2.next = prev;
    //         prev = temp2;
    //         temp2 = temp1;
    //     }
    //     return prev;
    // }

    int func(Node temp){
        
        
        if(temp == null) return 1;
        
        int carry = func(temp.next);
        
        temp.data = temp.data + carry;
        if(temp.data < 10) return 0;
        temp.data = 0;
        return 1;
        
        
    }
    
    public Node addOne(Node head) {
        // Optimal : Using Recursion
        // TC -> O(N) SC->O(N) {using recursion stac space}
        int carry = func(head);
        if(carry == 1){
            Node nd = new Node(1);
            nd.next = head;
            return nd;
        }
        return head;
        
        
        // Brute : TC -> O(3N) , SC->O(1)
        // head =  reverseLL(head);   // O(N)
        // Node temp = head;
        // int carry = 1;
        // while(temp!=null){           // O(N)
        //     temp.data = temp.data+carry;
        //     if(temp.data < 10){
        //         carry = 0;
        //         break;
        //     }
        //     else{
        //         temp.data = 0;
        //         carry = 1;
        //     }
        //     temp = temp.next;
        // }
        // if(carry == 1){
        //     Node nd =  new Node(1);
        //     head = reverseLL(head);    
        //     nd.next = head;
        //     return nd;
        // }
        // head = reverseLL(head);      // O(N)
        // return head;
    }
}