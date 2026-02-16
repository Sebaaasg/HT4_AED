package Stack;

import List.DoublyLinkedList;
import List.IList;
import List.SinglyLinkedList;

// Hace que una lista se comporte como una pila
public class StackList<T> extends AbstractStack<T> {

    private IList<T> internalList;// La lista real que guarda los datos

    // Constructor: Recibe "1" o "2"
    public StackList(String listType) {

        if (listType == null) {
            throw new IllegalArgumentException("List type cannot be null");
        }

        if (listType.equalsIgnoreCase("singly")) {
            internalList = new SinglyLinkedList<>(); // Por defecto usamos la Simple
        } else if (listType.equalsIgnoreCase("doubly")) {
            internalList = new DoublyLinkedList<>();
        } else {
            throw new IllegalArgumentException("Invalid list type");
        }
    }

    @Override
    public void push(T item) {
        internalList.addFirst(item); //Pila LIFO
    }

    @Override
    public T pop() {
        return internalList.removeFirst(); //Sacamos al inicio
    }

    @Override
    public T peek() {
        return internalList.getFirst();
    }

    @Override
    public int size() {
        return internalList.size();
    }
}
