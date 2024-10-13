class Node{
    int key;
    int val;
    Node next;
    Node prev;
    Node(int key,int val){
        this.key = key;
        this.val = val;
    }
}
class LCM146LRUCacheImplementation {
    // Used a map and DoubleLinkedList

    // SC->O(capacity)

    Map<Integer,Node> map;
    int cap;
    Node head;
    Node tail;

    
    public LCM146LRUCacheImplementation(int capacity) {     // TC->O(1)
        map = new HashMap<>();
        cap = capacity;
       
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
        
    }
    public void insertAfterHead(Node nd){   // TC->O(1)
        Node currentAfterHead = head.next;
        head.next = nd;
        nd.next = currentAfterHead;
        nd.prev = head;
        currentAfterHead.prev = nd;
    }

    // Doesnt mean deleteing node reference just removing the pointers
    public void deleteNode(Node nd){    // TC->O(1)
        Node prevNode = nd.prev;
        Node afterNode = nd.next;
        prevNode.next = afterNode;
        afterNode.prev = prevNode;
    }
    
    public int get(int key) {      // TC->O(1) Assuming map works in O(1)
        if(!map.containsKey(key)) return -1;
        Node nd = map.get(key);
        deleteNode(nd);
        insertAfterHead(nd);
        return nd.val;
    }
    
    public void put(int key, int value) {    // TC->O(1) Assuming map works in O(1)
        if(map.containsKey(key)){
            Node nd = map.get(key);
            nd.val = value;
            deleteNode(nd);
            insertAfterHead(nd);
        }
        else{
            if(map.size()==cap){
                Node LRU = tail.prev;
                map.remove(LRU.key);    
                deleteNode(LRU);
            }
            Node newNode = new Node(key, value);
            map.put(key,newNode);
            insertAfterHead(newNode);

        }
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */