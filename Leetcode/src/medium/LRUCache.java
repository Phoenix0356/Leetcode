package medium;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class LRUCache {
    AtomicInteger integer;

    int capacity;
    HashMap<Integer,Node> map;
    DoubleList list;

    public LRUCache(int capacity) {
        integer.get();
        this.capacity = capacity;
        map = new HashMap<>();
        list = new DoubleList();
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            list.remove(node);
            list.addLast(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node node = new Node(key, value);
        if(map.containsKey(key)){
            Node curNode = map.get(key);
            list.remove(curNode);
            list.addLast(node);
            map.put(key,node);
            return;
        }

        if(list.size()==capacity){
            int keyOfRemoved = list.removeFirst();
            map.remove(keyOfRemoved);
        }

        map.put(key,node);
        list.addLast(node);
    }


    static class DoubleList{
        Node head,tail;
        int size;
        public DoubleList(){
            this.size = 0;

            this.head = new Node(0, 0);
            this.tail = new Node(0, 0);

            head.next = tail;
            tail.prev = head;
        }

        public void addLast(Node node){

            node.next = tail;
            node.prev = tail.prev;

            tail.prev.next = node;
            tail.prev = node;
            size++;
        }

        public int removeFirst(){
            if(head.next == tail){
                return -1;
            }
            Node first = head.next;
            int key = first.key;
            remove(first);
            return key;
        }

        public void remove(Node node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        public int size(){
            return size;
        }

    }
    static class Node{
        int key,val;
        Node prev,next;
        public Node(int key,int val){
            this.key = key;
            this.val = val;
        }
    }
}
