package org.example;


import java.util.Arrays;

public class MyArrayList<E> {
    private Object[] array = new Object[0];

    public void add(E object) {
        array = Arrays.copyOf(array, array.length + 1);
        array[array.length - 1] = object;

    }

    public int size() {
        return array.length;
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
    }

    public void clear()
    {
      array = new Object[0];
    }
}
