package List;

public class SinglyLinkedList<T> extends AbstractList<T> {

    // Clase interna NODO (Solo vive aquí adentro para evitar la creación innecesaria de archivos)
    private class Node {
        T data;
        Node next; // Puntero al siguiente

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head; // Cabeza de la lista

    public SinglyLinkedList() {
        this.head = null;
    }

    @Override
    public void addFirst(T item) {
        Node newNode = new Node(item);
        // 1. El nuevo nodo apunta al actual head
        newNode.next = head;
        // 2. El head se actualiza al nuevo nodo
        head = newNode;
        size++;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) return null;

        T data = head.data;
        // Movemos el head al siguiente, "olvidando" el primero (Garbage Collector lo borra)
        head = head.next;
        size--;
        return data;
    }

    @Override
    public T getFirst() {
        if (isEmpty()) return null;
        return head.data;
    }
}