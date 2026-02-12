package List;

public interface IList<T> {
    
    public void addFirst(T item);

    public T removeFirst();

    public T getFirst();

    public boolean isEmpty();

    public int size();
}
