package List;

import java.util.NoSuchElementException;

public class DoublyLinkedList<T> extends AbstractList<T> {

    private DoubleNode<T> head;
    private DoubleNode<T> tail;

    // Nodo Doble (Tiene Anterior y Siguiente)
    private class DoubleNode<E> {
        E data;
        DoubleNode<E> next;
        DoubleNode<E> prev;

        DoubleNode(E data) {
            this.data = data;
        }
    }

    public DoublyLinkedList() {
        super();
        head = null;
        tail = null;
    }

    @Override
    public void addFirst(T value) {

        if (value == null) {
            throw new IllegalArgumentException("Null values are not allowed");
        }

        DoubleNode<T> newNode = new DoubleNode<>(value);

        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        count++;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Cannot remove from an empty list");
        }

        T value = head.data;

        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }

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
