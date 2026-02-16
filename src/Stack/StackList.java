package Stack;

import List.IList;
import List.SinglyLinkedList;
import List.DoublyLinkedList;

public class StackList<T> extends AbstractStack<T> {

    private IList<T> internalList;

    public StackList(String listType) {
        if (listType.equalsIgnoreCase("singly")) {
            internalList = new SinglyLinkedList<>();
        } else if (listType.equalsIgnoreCase("doubly")) {
            internalList = new DoublyLinkedList<>();
        } else {
            throw new IllegalArgumentException("Invalid list type");
        }
    }

    @Override
    public void push(T item) {
        internalList.addFirst(item);
    }

    @Override
    public T pop() {
        return internalList.removeFirst();
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


