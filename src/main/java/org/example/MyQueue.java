package org.example;

import java.util.Arrays;

public class MyQueue<E> {
    private int size = 0;
    private Object[] array = new Object[0];

    private void grow(int minSize){
        int oldLength = array.length;

        int newLength = Math.max(minSize - oldLength, oldLength / 2) + oldLength;

        array = Arrays.copyOf(array, newLength);
    }

    public void add(E value){
        if(size == array.length){
            grow(size + 1);
        }

        array[size] = value;
        size++;
    }
    public void clear() {
        array = new Object[0];
    }
    public int size() {
        return array.length;
    }
    public Object peek() {
        if(array.length == 0)
            return null;

        return array[0];
    }
    public Object poll(){
        Object tmp = null;

        if (array.length > 0) {
            tmp = array[0];

            for (int i = 0; i < array.length - 1; i++) {
                array[i] = array[i + 1];
            }

            array = Arrays.copyOf(array, array.length - 1);
        }
        size--;
        return tmp;
    }

}
