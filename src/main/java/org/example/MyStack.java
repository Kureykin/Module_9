package org.example;

import java.util.Arrays;

public class MyStack<E> {
    private int size = 0;
    private Object[] array = new Object[0];

    private void grow(int minSize){
        int oldLength = array.length;

        int newLength = Math.max(minSize - oldLength, oldLength / 2) + oldLength;

        array = Arrays.copyOf(array, newLength);
    }

    public void push(E value) {
        if(size == array.length){
            grow(size + 1);
        }

        array[size] = value;
        size++;
    }

    public void remove(int index) {
        if (index < array.length){
            for(int i = index; i < array.length - 1; i++)
                array[i] = array[i + 1];
        }

        size--;
    }

    public void clear() {
        array = new Object[0];
    }

    public int size() {
        return array.length;
    }

    public Object peek() {
        return array.length > 0 ? array[array.length - 1] : null;
    }

    public Object pop() {
        Object tmp = null;
        if (array.length > 0) {
            tmp = array[array.length - 1];

            array = Arrays.copyOf(array, array.length - 1);
        }
        size--;
        return tmp;
    }
}
