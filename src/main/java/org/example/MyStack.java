package org.example;

import java.util.Arrays;

public class MyStack<E> {
    private Object[] array = new Object[0];

    public void push(E value)
    {
        array = Arrays.copyOf(array, array.length + 1);

        array[array.length - 1] = value;
    }

    public void remove(int index)
    {
        if (index < array.length)
            for(int i = index; i < array.length - 1; i++)
                array[i] = array[i + 1];
    }

    public void clear()
    {
        array = new Object[0];
    }

    public int size()
    {
        return array.length;
    }

    public Object peek()
    {
        return array.length > 0 ? array[array.length - 1] : null;
    }

    public Object pop()
    {
        Object tmp = null;
        if (array.length > 0) {
            tmp = array[array.length - 1];

            array = Arrays.copyOf(array, array.length - 1);
        }

        return tmp;
    }
}
