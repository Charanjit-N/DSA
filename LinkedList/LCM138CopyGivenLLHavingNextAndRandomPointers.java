/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class LCM138CopyGivenLLHavingNextAndRandomPointers{
    public Node copyRandomList(Node head) {
        //Optimal : TC->(3N) , SC->O(1) {O(N) if you consider that we are using for returing the answer} 
        // Inserting copy node in between the given nodes of the LL:
        Node temp = head;
        while(temp!=null) {
            Node copyNode = new Node(temp.val);
            copyNode.next = temp.next;
            temp.next = copyNode;
            temp = temp.next.next;
        }
        // Connnecting Random pointers
        temp = head;
        while(temp!=null){
            Node copyNode = temp.next;
            if(temp.random != null){
                copyNode.random = temp.random.next;
            }
            else{
                copyNode.random = null;
            }
            temp = temp.next.next;
        }
        // Connecting the next pointers
        temp = head;
        Node dummyNode = new Node(-1);
        Node res =dummyNode;
        while(temp!=null){
            res.next = temp.next;
            temp.next = temp.next.next;
            res = res.next;
            temp = temp.next;
        }
        return dummyNode.next;  

        /* Brute : TC->O(2N) , SC->O(N) + O(N) {One O(N) is for map and Extra O(N) to return the answer not used to solve the problem} */
        // Node temp = head;
        // Map<Node, Node> map = new HashMap<>();
        // while(temp!=null){
        //     Node newNode = new Node(temp.val);
        //     map.put(temp,newNode);
        //     temp = temp.next;
        // }
        // temp = head;
        // while(temp!=null){
        //     Node copyNode = map.get(temp);
        //     copyNode.next = map.get(temp.next);
        //     copyNode.random = map.get(temp.random);
        //     temp = temp.next;
        // }
        // return map.get(head);


    }
}