package Stack;

import java.util.Vector;


// Implementación de Pila basada en Vector
// Similar al ArrayList pero sincronizada
public class StackVector<T> extends AbstractStack<T> {

    private Vector<T> data;

    public StackVector() {
        this.data = new Vector<>();
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
        return data.lastElement();
    }

    @Override
    public int size() {
        return data.size();
    }
}