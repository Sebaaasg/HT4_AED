package Stack;

import java.util.ArrayList;


// Implementación de Pila basada en ArrayList
public class StackArrayList<T> extends AbstractStack<T> {
    
    // atributo
    private ArrayList<T> data;

    // Constructor
    public StackArrayList() {
        this.data = new ArrayList<>();
    }

    @Override
    public void push(T item) {
        data.add(item);
    }

    @Override
    public T pop() {
        if (isEmpty()) return null;
        return data.remove(data.size() - 1);
    }

    @Override
    public T peek() {
        if (isEmpty()) return null;
        return data.get(data.size() - 1);
    }

    @Override
    public int size() {
        return data.size();
    }
}