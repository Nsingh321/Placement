package Stacks;

import java.util.HashMap;
import java.util.Map;

class lfuCache {
    final int capacity; // given capacity of cache
    int curSize; // current size of cache
    int minFrequency; // minimum frequency node
    Map<Integer , DLLNode> cache; //this map stores the key,node(address of that node)
    Map<Integer , DoubleLinkedList> frequencyMap; //this map stores the frequency and LL of that frequency

    public lfuCache(int capacity) {
        this.capacity = capacity;
        this.curSize = 0;
        this.minFrequency = 0;
        this.cache = new HashMap<>();
        this.frequencyMap = new HashMap<>();
    }

    //get the value for the passed key
    public int get(int key) {
        DLLNode curNode = cache.get(key); //get the current node from the cache map
        if(curNode == null) return -1; //if it does not exist then return -1

        updateNode(curNode); //the frequency of this node will increase
        return curNode.val; //we need the value of this current Node
    }

    public void put(int key, int value) {
        if(capacity == 0) return; //edge case
        if(cache.containsKey(key) == true){
            DLLNode curNode = cache.get(key); //get the current node for the given key
            curNode.val = value; //update the value for this node
            updateNode(curNode);//the frequency of this node will increase
        }
        else{
            //key is not in cache
            curSize++; //size of cache will increase
            if(curSize > capacity){
                //get LFU
                DoubleLinkedList minFreqList = frequencyMap.get(minFrequency);
                cache.remove(minFreqList.tail.prev.key); //remove from cache
                minFreqList.removeNode(minFreqList.tail.prev);//remove from min. freq list
                curSize -- ; //current size of cache will reduce

            }
            //minFrequency = 1 because of adding a new node (that new node will have frequency = 1)
            minFrequency = 1;
            DLLNode newNode=new DLLNode(key,value);
            //get the list with frequency 1, and then add new node into that list as well as into LFU Cache
            DoubleLinkedList curList = frequencyMap.getOrDefault(1,new DoubleLinkedList());
            curList.addNode(newNode);
            frequencyMap.put(1,curList); //put also in frequency map
            cache.put(key,newNode); //put in cache also
        }
    }


    //this takes a node and removes it from current LL(because the frequency of this node is increased)
    public void updateNode(DLLNode curNode){
        int curFreq = curNode.frequency; //take freq. of current node

        //from that freq figure out the LL which have that freq. in the 'frequency map'
        DoubleLinkedList curList = frequencyMap.get(curFreq);

        //from that LL remove that node because its frequency is increased
        curList.removeNode(curNode);

        //if current List the last list which has lowest frequency and current node is the only node in that list .
//         curList.listSize == 0(after remove the list size becomes zero)
        if(curFreq == minFrequency && curList.listSize == 0){
            minFrequency++;
        }
        curNode.frequency++; //increase the frequency of current node

        //add current node to another list
        DoubleLinkedList newList =frequencyMap.getOrDefault(curNode.frequency,new DoubleLinkedList());
        newList.addNode(curNode);//add current node to new List
        frequencyMap.put(curNode.frequency,newList);//put into frequency map
    }

    class DLLNode{
        int key;
        int val;
        int frequency;
        DLLNode prev;
        DLLNode next;
        public DLLNode(int key , int val){
            this.key = key;
            this.val = val;
            this.frequency = 1; //inital frequency is always 1
        }
    }

    class DoubleLinkedList{
        int listSize;
        DLLNode head;
        DLLNode tail;
        public DoubleLinkedList(){
            this.listSize = 0;
            this.head = new DLLNode(0,0);
            this.tail = new DLLNode(0,0);
            head.next = tail;
            tail.prev = head;
        }

        //add new node into the head of list and increse list size+1
        public void addNode(DLLNode curNode){
            DLLNode nextNode = head.next;
            curNode.next = nextNode;
            curNode.prev = head;
            head.next = curNode;
            nextNode.prev = curNode;
            listSize++;
        }

        //remove input node and decrease list size + 1
        public void removeNode(DLLNode curNode){
            DLLNode prevNode = curNode.prev;
            DLLNode nextNode = curNode.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            listSize--;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
