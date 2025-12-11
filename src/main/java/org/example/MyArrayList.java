package org.example;


import java.util.Arrays;

public class MyArrayList<E> {

    private final int defaultSize = 10;
    private final Object[] defaultArray = {};

    private int size = 0;
    private Object[] array;

    public MyArrayList(){
        array = defaultArray;
    }

    private void grow(int minSize){
        int oldSize = array.length;
        if(oldSize > 0 || array != defaultArray){
            int newSize = Math.max(minSize - oldSize, oldSize / 2) + oldSize;
            array = Arrays.copyOf(array, newSize);
        }
        else {
            array = new Object[Math.max(defaultSize, minSize)];
        }
    }

    public void add(E object) {
        if (size == array.length){
            grow(size);
        }
        array[size + 1] = object;
        size++;
    }

    public int size() {
        return size;
    }

    public Object get(int index) {
        return array[index];
    }

    public void remove(int index)
    {
            for (int i = index; i < array.length - 1; i++) {
                array[i] = array[i + 1];
            }
            array = Arrays.copyOf(array, array.length - 1);
            size--;
    }

    public void clear()
    {
      array = new Object[0];
      size = 0;
    }
}
