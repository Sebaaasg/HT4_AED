package List;


// PATRÓN FACTORY
public class ListFactory {

    public <T> IList<T> createList(String listType) {
        if (listType == null) {
            throw new IllegalArgumentException("List type cannot be null");
        }

        // Se hace que la fábrica entienda tanto los números del Main como las palabras de los Tests
        if (listType.equals("1") || listType.equalsIgnoreCase("singly")) {
            return new SinglyLinkedList<>();
        } else if (listType.equals("2") || listType.equalsIgnoreCase("doubly")) {
            return new DoublyLinkedList<>();
        } else {
            throw new IllegalArgumentException("Invalid list type: " + listType);
        }
    }
}