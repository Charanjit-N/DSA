
// Used  2 maps and in one map  we store <freq,DoubleLinkedLists> and in another we store all the nodes in our cache <key,DLLNode>

//TC for get(), put() --> O(1);
// SC ->O(capacity);

class DLLNode{
    int key;
    int val;
    int useCount;
    DLLNode next;
    DLLNode prev;
    DLLNode(int key, int val){
        this.key = key;
        this.val = val;
        this.useCount =1;
    }
}
class DoubleLinkedList{
    int listSize ;
    DLLNode head;
    DLLNode tail;
    DoubleLinkedList(){
        this.listSize = 0;
        this.head = new DLLNode(-1,-1);
        this.tail = new DLLNode(-1,-1);
        head.next = tail;
        tail.prev = head;
    }
    public void insertAfterHead(DLLNode nd){   
        DLLNode currentAfterHead = head.next;
        head.next = nd;
        nd.next = currentAfterHead;
        nd.prev = head;
        currentAfterHead.prev = nd;
        listSize++;
    }
    void removeNode(DLLNode nd){
        DLLNode nodePrev = nd.prev;
        DLLNode nodeNext = nd.next;
        nodePrev.next = nodeNext;
        nodeNext.prev = nodePrev;
        listSize--;
    }
}
class LFUCache {
    int minFreq;
    int capacity;
    int curSize ;
    HashMap<Integer, DLLNode> cache;
    HashMap<Integer, DoubleLinkedList> freqMap;

    public LFUCache(int capacity) {
        this.minFreq = 0;
        this.curSize = 0;
        this.capacity = capacity;
        cache = new HashMap<>();
        freqMap = new HashMap<>();
    }
    void updateNode(DLLNode nd){
        int nodeFreq =  nd.useCount;
        DoubleLinkedList nodeDLL = freqMap.get(nodeFreq);
        nodeDLL.removeNode(nd);
        if(nodeFreq == minFreq && nodeDLL.listSize==0){
            minFreq++;
        }
        nd.useCount++;
        DoubleLinkedList newDLL = freqMap.getOrDefault(nd.useCount,new DoubleLinkedList());
        newDLL.insertAfterHead(nd);
        freqMap.put(nd.useCount, newDLL);
    }
    public int get(int key) {
        if(!cache.containsKey(key)) return -1;
        DLLNode nd = cache.get(key);
        updateNode(nd);
        return nd.val;
    }
    public void put(int key, int value) {
        if(capacity ==0) return;
        if(cache.containsKey(key)){
            DLLNode  nd =  cache.get(key);
            nd.val =  value;
            updateNode(nd);
        }
        else{
            curSize++;
            if(curSize >   capacity){     // (or) if(cache.size() == capacity) 
                DoubleLinkedList minFreqDLL = freqMap.get(minFreq);
                cache.remove(minFreqDLL.tail.prev.key);
                minFreqDLL.removeNode(minFreqDLL.tail.prev);
                curSize--;
            }
            minFreq = 1;
            DLLNode newNode = new DLLNode(key,value);
            DoubleLinkedList nodeDLL =  freqMap.getOrDefault(1,new DoubleLinkedList());
            nodeDLL.insertAfterHead(newNode);
            freqMap.put(1,nodeDLL);
            cache.put(key, newNode);
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */