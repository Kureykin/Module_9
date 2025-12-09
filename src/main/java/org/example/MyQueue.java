package org.example;

import java.util.Arrays;

public class MyQueue<E> {
    private Object[] array = new Object[0];

    public void add(E value)
    {
        array = Arrays.copyOf(array, array.length + 1);
        array[array.length - 1] = value;
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
        if(array.length == 0)
            return null;

        return array[0];
    }
    public Object poll()
    {
        Object tmp = null;

        if (array.length > 0)
        {
            tmp = array[0];

            for (int i = 0; i < array.length - 1; i++) {
                array[i] = array[i + 1];
            }

            array = Arrays.copyOf(array, array.length - 1);
        }

        return tmp;
    }

}
