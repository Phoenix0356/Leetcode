package datastructure;

public class MyHashSet<T> {
    Thread thread;
    Node[] table;
    Integer i;
    MyHashSet(){
        table = new Node[16];
    }

    public boolean add(T item){
        int hash = item.hashCode();
        int hashInd = hash%7;

        if (table[hashInd]==null){
            table[hashInd] = new Node(item);
        }else {
            Node cur = table[hashInd];

            while (cur.next!=null){
                if (cur.item.equals(item)){
                    return false;
                }
                cur = cur.next;
            }

            if (cur.item.equals(item)){
                return false;
            }

            cur.next = new Node(item);

        }
        return true;
    }


    public void print() {
        for (Node node:table){
            if (node == null) {
                System.out.println("null");
                continue;
            }
            System.out.println(node.item.toString());
        }
    }
}
class Node{

    Node(Object item){
        this.item = item;
        this.next = null;
    }
    Node(Object item, Node next){
        this.item = item;
        this.next = next;
    }
    Object item;
    Node next;
}

