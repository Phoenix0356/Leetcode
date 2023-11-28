package medium;

import java.util.ArrayList;

public class FrontMiddleBackQueue {
    ArrayList<Integer> list;
    public FrontMiddleBackQueue() {
        list=new ArrayList<>();

    }

    public void pushFront(int val) {
        list.add(0,val);
    }

    public void pushMiddle(int val) {
        list.add(list.size()/2,val);
    }

    public void pushBack(int val) {
        list.add(val);
    }

    public int popFront() {
        if (isEmpty(list.size())) return -1;
        int val= list.get(0);
        list.remove(0);
        return val;
    }

    public int popMiddle() {
        if (isEmpty(list.size())) return -1;
        int val= list.get((list.size()-1)/2);
        list.remove((list.size()-1)/2);
        return val;
    }

    public int popBack() {
        if (isEmpty(list.size())) return -1;
        int val= list.get(list.size()-1);
        list.remove(list.size()-1);
        return val;
    }

    boolean isEmpty(int size){
        return size==0;
    }
}
