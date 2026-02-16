package Stack;

import List.IList;
import List.SinglyLinkedList;
import List.DoublyLinkedList;

// Hace que una lista se comporte como una pila
public class StackList<T> extends AbstractStack<T> {

    private IList<T> internalList; // La lista real que guarda los datos

    // Constructor: Recibe "1" o "2"
    public StackList(String listType) {
        if (listType.equals("2")) {
            this.internalList = new DoublyLinkedList<>();
        } else {
            // Por defecto usamos la Simple
            this.internalList = new SinglyLinkedList<>();
        }
    }

    @Override
    public void push(T item) {
        internalList.addFirst(item); // Pila LIFO 
    }

    @Override
    public T pop() {
        return internalList.removeFirst(); // Sacamos del inicio
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