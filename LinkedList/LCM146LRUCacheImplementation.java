class DLLNode{
    int key;
    int val;
    DLLNode next;
    DLLNode prev;
    DLLNode(int key,int val){
        this.key = key;
        this.val = val;
    }
}
class LRUCache {
    // Used a map and DoubleLinkedList

    // SC->O(capacity)

    Map<Integer,DLLNode> map;
    int cap;
    DLLNode head;
    DLLNode tail;

    
    public LRUCache(int capacity) {     // TC->O(1)
        map = new HashMap<>();
        cap = capacity;

        head = new DLLNode(-1,-1);
        tail = new DLLNode(-1,-1);
        head.next = tail;
        tail.prev = head;
        
    }
    public void insertAfterHead(DLLNode nd){   // TC->O(1)
        DLLNode currentAfterHead = head.next;
        head.next = nd;
        nd.next = currentAfterHead;
        nd.prev = head;
        currentAfterHead.prev = nd;
    }

    // Doesnt mean deleteing node reference just removing the pointers
    public void deleteNode(DLLNode nd){    // TC->O(1)
        DLLNode prevNode = nd.prev;
        DLLNode afterNode = nd.next;
        prevNode.next = afterNode;
        afterNode.prev = prevNode;
    }
    
    public int get(int key) {      // TC->O(1) Assuming map works in O(1)
        if(!map.containsKey(key)) return -1;
        DLLNode nd = map.get(key);
        deleteNode(nd);
        insertAfterHead(nd);
        return nd.val;
    }
    
    public void put(int key, int value) {    // TC->O(1) Assuming map works in O(1)
        if(map.containsKey(key)){
            DLLNode nd = map.get(key);
            nd.val = value;
            deleteNode(nd);
            insertAfterHead(nd);
        }
        else{
            if(map.size()==cap){
                DLLNode LRU = tail.prev;
                map.remove(LRU.key);    
                deleteNode(LRU);
            }
            DLLNode newNode = new DLLNode(key, value);
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