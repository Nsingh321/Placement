package Stacks;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    Node head = new Node(0,0) , tail = new Node(0,0);
    Map<Integer , Node> map = new HashMap();
    int capacity ; //capacity of cache

    public LRUCache(int _capacity) {
        capacity = _capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            //get the reference of node(which has the value), as we know that the key is in hashmap
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
        else {
            return -1;
        }
    }

    public void put(int key, int value) {
        //check if key is already in hashmap
        if(map.containsKey(key)){
            // remove from hashmap
            remove(map.get(key));
        }
        //also check the if the capacity of hashmap is full
        if(map.size() == capacity){
            //remove the LRU guy (just before tail)
            remove(tail.prev);
        }
        //insert just after head
        insert(new Node(key,value));

    }

    private void remove(Node node){
        map.remove(node.key); //remove from hashmap

        //remove from doubly linked list
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    //insert() - node after head
    private void insert(Node node){
        map.put(node.key,node); // insert (key,address) in hashmap

        //a new node is inserted after head
        Node headnext = head.next; //node after the head (before the new node inserted)
        head.next = node;
        node.prev = head;
        headnext.prev = node;
        node.next = headnext;
    }

    //Node class
    class Node{
        Node prev,next;
        int key , value;
        Node(int _key,int _value){
            key = _key;
            value = _value;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */