
// Used  2 maps and in one map  we store DoubleLinkedLists.

class LCH460LFUCacheImplementation {
    int capacity;
    int curSize;
    int minFrequency;
    Map<Integer, DLLNode> cache;
    Map<Integer, DoubleLinkedList> frequencyMap;


    public LCH460LFUCacheImplementation(int capacity) {
        this.capacity = capacity;   
        this.curSize = 0;
        this.minFrequency = 0;

        this.cache = new HashMap<>();
        this.frequencyMap = new HashMap<>();

    }
    public void updateNode(DLLNode curNode){
        int curFreq = curNode.useCounter;
        DoubleLinkedList curDLL = frequencyMap.get(curFreq);
        curDLL.removeNode(curNode);

        if(curFreq == minFrequency && curDLL.listSize == 0){
            minFrequency++;
        }

        curNode.useCounter++;

        DoubleLinkedList newDLL = frequencyMap.getOrDefault(curNode.useCounter, new DoubleLinkedList());
        newDLL.addNode(curNode);
        frequencyMap.put(curNode.useCounter, newDLL);
    }
    
    public int get(int key) {
        if(!cache.containsKey(key))  return -1;
        DLLNode curNode  = cache.get(key);
        updateNode(curNode);
        return curNode.val;
    }
    
    public void put(int key, int value) {
        if(capacity ==0) return;
        if(cache.containsKey(key)){
            DLLNode curNode = cache.get(key);
            curNode.val = value;
            updateNode(curNode);
        }
        else{
            curSize++;
            if(curSize> capacity){
                DoubleLinkedList minFreqDLL = frequencyMap.get(minFrequency);
                
                cache.remove(minFreqDLL.tail.prev.key);
                minFreqDLL.removeNode(minFreqDLL.tail.prev);

                curSize--;
            }
            minFrequency = 1;
            DLLNode newNode = new DLLNode(key, value);

            DoubleLinkedList curDLL = frequencyMap.getOrDefault(1, new DoubleLinkedList());
            curDLL.addNode(newNode);
            frequencyMap.put(1,curDLL);
            cache.put(key, newNode);

        }
        
    }
}

class DLLNode{
    int key;
    int val;
    int useCounter;
    DLLNode prev;
    DLLNode next;
    public DLLNode(int key, int val){
        this.key = key;
        this.val = val;
        this.useCounter = 1;
    }
}

class DoubleLinkedList{
    int listSize;
    DLLNode head;
    DLLNode tail;
    public DoubleLinkedList(){
        this.listSize =0;
        this.head = new DLLNode(0,0);
        this.tail = new DLLNode(0,0);
        head.next = tail;
        tail.prev = head;
    }

    public void addNode(DLLNode curNode){   // Adding After head
        DLLNode initialAfterHead = head.next;
        curNode.next = initialAfterHead;
        curNode.prev = head;
        head.next = curNode;
        initialAfterHead.prev = curNode;
        listSize++;
    }

    // Doesnt mean deleteing node reference just removing the pointers
    public void removeNode(DLLNode curNode){
        DLLNode prevNode = curNode.prev;
        DLLNode afterNode = curNode.next;

        prevNode.next = afterNode;
        afterNode.prev = prevNode;
        listSize--;
    }


}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */