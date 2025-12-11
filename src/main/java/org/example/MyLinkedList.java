package org.example;


public class MyLinkedList<E> {

    private int size = 0;
    private Node<E> firstNode;
    private Node<E> lastNode;

    private static class Node<E>{

         Node<E> prev;
         E value;
         Node<E> next;

         Node(Node<E> prev, E value, Node<E> next) {
             this.prev = prev;
             this.value = value;
             this.next = next;
         }
    }


    public void add(E value) {
        Node<E> last = lastNode;
        Node<E> newNode = new Node<>(last, value, null);
        if(last == null) {
            firstNode = newNode;
        }
        else {
            last.next = newNode;
        }

        lastNode = newNode;

        size++;
    }

    private Node<E> NodeAtIndex(int index){
        Node<E> currentNode = index > size / 2 ? lastNode : firstNode;

        if (index <= size / 2) {
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
        } else {

            for (int i = size; i > index; i--) {
                currentNode = currentNode.prev;
            }
        }
        return currentNode;
    }

    private void removeLastNode() {
        Node<E> tmp = lastNode;
        lastNode = tmp.prev;
        tmp.prev.next = null;
        tmp.value = null;
    }
    private void removeFirstNode(){
        Node<E> tmp = firstNode;
        firstNode = tmp.next;
        firstNode.prev = null;
        tmp.next = null;
        tmp.value = null;
    }

    public void remove(int index) {
        Node<E> currentNode = NodeAtIndex(index);
        if (currentNode == lastNode){
            removeLastNode();
            size--;
            return;
        }
        if (currentNode == firstNode){
            removeFirstNode();
            size--;
            return;
        }

        currentNode.prev.next = currentNode.next;
        currentNode.next.prev = currentNode.prev;

        currentNode.next = null;
        currentNode.prev = null;
        currentNode.value = null;

        size--;
    }

    public void clear() {
        lastNode = null;

        Node<E> currentNode = firstNode;
        firstNode = null;

        while (currentNode.next != null) {
            currentNode.prev = null;
            currentNode.value = null;
            currentNode = currentNode.next;
            currentNode.prev.next = null;
            currentNode.prev = null;
        }

        size = 0;
    }

    public E get(int index) {
        return NodeAtIndex(index).value;
    }

    public int size() {
        return size;
    }
}
