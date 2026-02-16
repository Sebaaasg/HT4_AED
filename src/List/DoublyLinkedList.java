package List;

public class DoublyLinkedList<T> extends AbstractList<T> {

    // Nodo Doble (Tiene Anterior y Siguiente)
    private class DoubleNode {
        T data;
        DoubleNode next;
        DoubleNode prev;

        DoubleNode(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private DoubleNode head; // Solo se necesita el head para esta implementación

    public DoublyLinkedList() {
        this.head = null;
    }

    @Override
    public void addFirst(T item) {
        DoubleNode newNode = new DoubleNode(item);
        
        // Si ya hay algo en la lista, se conecta el actual head con el nuevo
        if (head != null) {
            newNode.next = head; // El nuevo mira al viejo head
            head.prev = newNode; // El viejo head mira atrás al nuevo
        }
        // El nuevo pasa a ser el jefe
        head = newNode;
        size++;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) return null;

        T data = head.data;
        
        // Si solo hay un elemento
        if (head.next == null) {
            head = null;
        } else {
            // Si hay más, se mueve el head al siguiente
            head = head.next;
            head.prev = null; // El nuevo head ya no tiene nadie atrás
        }
        
        size--;
        return data;
    }

    @Override
    public T getFirst() {
        if (isEmpty()) return null;
        return head.data;
    }
}