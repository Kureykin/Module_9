package org.example;

public class MyHashMap<K, V> {

    final private int defauktSize = 16;

    private int size;
    private Node<K, V>[] hashTable = new Node[defauktSize];

    private static class Node<K, V>
    {
        final int hash;
        final K key;
        V value;
        Node<K, V> nextNode;

        Node(int hash, K key, V object, Node<K, V> nextNode)
        {
            this.hash = hash;
            this.key = key;
            this.value = object;
            this.nextNode = nextNode;
        }
    }

    static final int hash(Object key)
    {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    public void put(K key, V value)
    {
        Node<K, V> newNode = new Node<>(hash(key), key, value, null);
        int i = hashTable.length - 1 & newNode.hash;


        if(hashTable[i] == null)
        {
            hashTable[i] = newNode;
        }
        else
        {
            Node<K,V> currentNode = hashTable[i];
            while(currentNode.nextNode != null)
            {
                if (currentNode.key.equals(newNode.key))
                {
                    currentNode.value = newNode.value;
                    return;
                }

                currentNode = currentNode.nextNode;
            }

            currentNode.nextNode = newNode;


        }
        size++;
    }

    public void remove(K key)
    {
        int i = hashTable.length - 1 & hash(key);
        Node<K,V> currentNode = hashTable[i];
        Node<K,V> prevNode = null;

        while (currentNode.key != key)
        {
            prevNode = currentNode;
            currentNode = currentNode.nextNode;
        }

       if(prevNode != null)
           prevNode.nextNode = (currentNode.nextNode == null) ? null : currentNode.nextNode;
       else
           hashTable[i] = null;

       currentNode.nextNode = null;
       currentNode.value = null;

        size--;
    }

    public void clear()
    {
        for (int i = 0; i < hashTable.length; i++)
        {
            hashTable[i] = null;
        }
        size = 0;
    }

    public int size()
    {
        return size;
    }

    public Object get(K key)
    {
        int i = hashTable.length - 1 & hash(key);
        Node<K,V> currentNode = hashTable[i];

        while (!currentNode.key.equals(key) && currentNode != null)
        {
            currentNode = currentNode.nextNode;
        }

        return currentNode == null ? null: currentNode.value;
    }
}
