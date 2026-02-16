package List;

import java.util.NoSuchElementException;

public class SinglyLinkedList<T> extends AbstractList<T> {

    private Node<T> head;

    private class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    public SinglyLinkedList() {
        super();
        head = null;
    }

    @Override
    public void addFirst(T value) {

        if (value == null) {
            throw new IllegalArgumentException("Null values are not allowed");
        }

        Node<T> newNode = new Node<>(value);
        newNode.next = head;
        head = newNode;
        count++;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Cannot remove from an empty list");
        }

        T value = head.data;
        head = head.next;
        count--;
        return value;
    }

    @Override
    public T getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }

        return head.data;
    }
}
