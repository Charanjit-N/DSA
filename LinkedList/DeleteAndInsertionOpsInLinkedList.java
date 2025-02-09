class Node{
    int data;
    Node next;
    
    Node(int data){
        this.data = data;
    }
    Node(int data, Node next){
        this.data = data;
        this.next = next;
    }
}

class DeleteAndInsertionOpsInLinkedList{
    // print   T.C->O(n)
    static void print(Node head){
        while(head.next!=null){
            System.out.print(head.data+"->");
            head = head.next;
        }
        System.out.println(head.data);
    }
    
     // Delete Head  TC->O(1)
    static Node DeleteHead(Node head){
        if(head==null) return head;
        head = head.next;
        return head;
    }

    //Delete Tail   TC->O(n)
    static Node DeleteTail(Node head){
        if(head==null || head.next == null) return null;
        Node temp =head;
        // We need to get temp to point at second last element
        while(temp.next.next!=null){
            temp = temp.next;
        }
        //making second last element's next to point to null
        temp.next = null;

        return head;
    }

    //Delete Kth element from LL  TC->O(n)
    static Node DeleteKthElement(Node head, int k){
        if(head == null) return head;
        if(k==1){
            head = head.next;
            return head;
        }
        int cnt = 0;
        Node temp = head;
        Node prev = null;
        while(temp!=null){
            cnt++;
            if(cnt==k){
                prev.next  = temp.next;  // (or) prev.next = prev.next.next;
                // temp.next = null;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }
    
    //Delete given element from LL  TC->O(n)
    static Node DeleteGivenElement(Node head, int ele){
        if(head == null) return head;
        if(head.data == ele){
            head = head.next;
            return head;
        }

        Node temp = head;
        Node prev = null;
        while(temp!=null){
            if(temp.data==ele){
                prev.next  = temp.next; // (or) prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }
    // Inserting an element at head TC->O(1);
    static Node InsertAtHead(Node head, int val){
        Node newHead = new Node(val, head);
        return newHead ;
    }
    //Inserting an element at tail TC->O(n)
    static Node InsertAtTail(Node head, int val){
        if(head == null) return new Node(val);
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        Node newNode = new Node(val);
        temp.next = newNode;          
        // (or) temp.next = new Node(val);
        
        return head;
    }

    // Insert At Kth place  TC->O(n)
    static Node InsertAtKthPlace(Node head, int val, int k){
        if(head == null){
            if(k==1) return new Node(val,null);
            else return null;
        }
        if(k == 1){
            return new Node(val, head);
        }
        int cnt = 0;
        Node temp = head;
        while(temp!=null){
            cnt++;
            if(cnt==k-1){
                Node newNode = new Node(val);
                newNode.next = temp.next;    // Above two lines Node can be : Node newNode = new Node(val,temp.next);
                temp.next = newNode;
                break;
            }
            temp = temp.next;
        }
        return head;
    }
    // Inserting an element before given element of the LL TC->O(n);
    static Node InsertValueBeforeGivenElement(Node head, int val, int ele){
        if(head == null) return null;
        if(head.data == ele) return new Node(val,head);
        Node temp = head;
        while(temp.next!=null){
            if(temp.next.data == ele){
                Node newNode = new Node(val,temp.next);
                temp.next = newNode;
                break;
            }
            temp = temp.next;
        }
        return head;

    }
    

    public static void main(String[] args){
        Node head = new Node(5);
        head.next = new Node(12);
        head.next.next = new Node(6);
        head.next.next.next = new Node(8);

        // head = DeleteHead(head);     // 12->6->8
        // head = DeleteTail(head);     // 5->12->6
        head = DeleteKthElement(head,3); // 5->12->8
        // head = DeleteGivenElement(head,12);   // 5->6->8

        // head = InsertAtHead(head, 21);  // 21->5->12->6->8
        // head = InsertAtTail(head,35);    // 5->12->6->8->35
        // head = InsertAtKthPlace(head,17,3);  // 5->12->17->6->8
        //    head = InsertValueBeforeGivenElement(head,23,6); // 5->12->23->6->8
        print(head);
    }
}