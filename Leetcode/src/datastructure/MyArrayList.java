package datastructure;

import java.util.ArrayList;
import java.util.Arrays;

public class MyArrayList<T>  {
    private static final int DEFAULT_SIZE = 10;
    private static final Object[] DEFAULT_ELEMENTS = {};
    int size = 0;
    Object[] elements;

    public MyArrayList(){
        this.elements = new Object[]{};
    }

    public void add(T e){
        if (elements.length==size){
            elements = growSize();
        }
        elements[size++] = e;
    }

    public void set(int ind,T e){
        elements[ind] = e;
    }

    public Object[] toArray() {
        return Arrays.copyOf(elements, size);
    }

    public int size() {return size;}

    public boolean isEmpty(){
        return size == 1;
    }



    private Object[] growSize(int sizeNeed){
        int oldCapacity = elements.length;
        if (oldCapacity>0||elements != DEFAULT_ELEMENTS){
            //非第一次扩容
            int newCapacity = oldCapacity+(oldCapacity>>1);
            Object[] newElements = new Object[newCapacity];
            System.arraycopy(elements,0,newElements,0,oldCapacity);
            return elements = newElements;
        }else {
            //第一次加数据，第一次扩容
             return elements = new Object[Math.max(sizeNeed,DEFAULT_SIZE)];
        }
    }

    private Object[] growSize(){
        return growSize(size+1);
    }


}
