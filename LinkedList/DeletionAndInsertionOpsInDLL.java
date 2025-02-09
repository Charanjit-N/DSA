
class Node{
    int data;
    Node next;
    Node back;
    Node(int data){
        this.data = data;
    }
    Node(int data, Node next,Node back){
        this.data = data;
        this.next = next;
        this.back = back;
    }
}

class DeletionAndInsertionOpsInDLL{

    // print    TC->O(n)
    static void print(Node head){
        if(head==null) return;
        while(head.next!=null){
            System.out.print(head.data+"->");
            head = head.next;
        }
        System.out.println(head.data);
    }
    // Array to DLL    : TC->O(n)
    static Node convertArr2DLL(int[] arr){
        if(arr.length == 0) return null;
        Node head = new Node(arr[0]);
        Node prev = head;
        for(int i=1;i<arr.length;i++){
            Node temp = new Node(arr[i],null,prev);  // (or) Node temp = new Node(arr[i]); temp.next = null;  temp.back = prev;
            prev.next = temp;
            prev = prev.next;    // (or) prev = temp;
        }
        return head;

    }
    // Delete Head  : TC->O(1)
    static Node deleteHead(Node head){
        if(head==null) return head;
        Node prev = head;
        head = head.next;
        head.back = null;
        prev.next = null;
        return head;
    }
    // Delete Tail  : TC->O(n)
    static Node deleteTail(Node head){
        if(head == null || head.next==null) return null;
        Node temp = head;
        while(temp.next.next!=null){
            temp = temp.next;
        }   
        temp.next.back= null;
        temp.next = null;
        return head;  

        // (or)
        // if(head == null || head.next==null) return null;
        // Node temp = head;
        // while(temp.next!=null){
        //     temp=temp.next;
        // }
        // temp.back.next = null;  // (or) Node newTail = temp.back;  newTail.next = null;
        // temp.back = null;
        // return head;
    }

    //Delete Kth element from DLL : TC->O(n)
    static Node deleteKthElement(Node head, int k){
        if(head == null) return null;
        Node temp = head;
        int cnt=0;
        while(temp!=null){
            cnt++;
            if(cnt==k) break;
            temp = temp.next;
        } // Now temp will be pointing to kth element (or) node.
        Node front = temp.next;
        Node prev = temp.back;

        if(prev==null && front == null) return null; // It means only one element in DLL and k=1;
        else if(prev == null){
            // It means (k=1) => delete head we can call deleteHead() function.
            Node before = head;
            head = head.next;
            head.back = null;
            before.next = null;
            return head;
            // (or) deleteHead(head);
        }
        else if(front  == null){
            // It means deleting tail we can call deleteTail() function.
            prev.next = null;  
            temp.back = null;
            return head;
            // (or) deleteTail(head);

        }
        prev.next = front;
        front.back = prev;
        temp.next = null;
        temp.back = null;

        return head;        
    }
   
    // Delete Given Node from DLL :  TC->O(1)
    static void deleteGivenNode(Node nd){
        Node prev = nd.back;
        Node front = nd.next;
        if(front == null){   // It is like Deleting tail
            prev.next = null;
            nd.back = null;
            return;
        }
        prev.next = front;
        front.back = prev;
        nd.next = nd.back = null;
    }

    // inserting new head  :  TC->O(1)
    static Node insertBeforeHead(Node head, int val){
        Node newHead = new Node(val, head, null);
        head.back = newHead;
        return newHead;
    }
    // Inserting before tail of the DLL : TC->O(n)
    static Node insertBeforeTail(Node head, int val){
        if(head.next == null){  //  Single element => Is like Insert before head
            Node newHead = new Node(val, head, null);
            head.back = newHead;
            return newHead;
        }
        Node tail = head;
        while(tail.next!=null){
            tail=tail.next;
        } 
        Node nd = new Node(val,tail,tail.back);
        tail.back.next = nd;
        tail.back = nd;
        return head;  
    }

    // Inserting before Kth Element of the DLL : TC->O(n)
    static Node insertBeforeKthElement(Node head, int val, int k){
        if(head == null)  return new Node(val,null,null);
        if(k==1) {   // Is is inserBeforeHead() function you can call it.
            Node newHead = new Node(val, head, null);
            head.back = newHead;
            return newHead;
        }
        Node temp = head;
        int cnt = 0;
        while(temp!=null){
            cnt++;
            if(cnt==k) break;
            temp = temp.next;
        }
        Node prev = temp.back;
        Node newNode = new Node(val,temp,prev);
        prev.next = newNode;
        temp.back = newNode;
        return head;
    }

    // Inserting before Give Node of DLL  : TC->O(1)
    static void insertBeforeGivenNode(Node nd, int val){
        Node prev = nd.back;
        Node newNode = new Node(val, nd,prev);
        prev.next = newNode;
        nd.back = newNode;
    }


    public static void main(String[] args){
        int[] arr = {12,5,9,6};
        Node head = convertArr2DLL(arr);

        // head = deleteHead(head);  // 5->9->6
        // head = deleteTail(head);    //12->5->9
        // head = deleteKthElement(head,3); // 12->5->6;
        // deleteGivenNode(head.next.next); // 12->5->6    In this we assume that head is never asked to delete
        
        // head = insertBeforeHead(head,20); //  20->12->5->9->6
        // head = insertBeforeTail(head, 30);  // 12->5->9->6->30
        // head = insertBeforeKthElement(head,40,3); // 12->5->40->9->6
           insertBeforeGivenNode(head.next,50); // 12->50->5->9->6

        print(head);


    }
}