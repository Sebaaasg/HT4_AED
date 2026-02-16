package List;

public abstract class AbstractList<T> implements IList<T> {

    protected int count;

    public AbstractList() {
        this.count = 0;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public abstract void addFirst(T value);

    @Override
    public abstract T removeFirst();

    @Override
    public abstract T getFirst();
}

