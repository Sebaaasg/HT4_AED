package Stack;

import List.IList;
import List.ListFactory;

// Hace que una lista se comporte como una pila
public class StackList<T> extends AbstractStack<T> {

    private IList<T> internalList;// La lista real que guarda los datos

    // Constructor: Recibe "1" o "2"
    public StackList(String listType) {

        // se usa el Patrón Factory para seleccionar la implementación de la lista.
        ListFactory listFactory = new ListFactory();
        this.internalList = listFactory.createList(listType);
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
