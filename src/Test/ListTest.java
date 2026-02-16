package Test;

import List.SinglyLinkedList;
import List.DoublyLinkedList;
import List.IList;
import org.junit.Test;
import static org.junit.Assert.*;

public class ListTest {

    @Test
    public void testSinglyLinkedListOperations() {
        IList<String> list = new SinglyLinkedList<>();
        
        assertTrue("La lista nueva debe estar vacía", list.isEmpty());
        
        list.addFirst("A");
        list.addFirst("B");
        
        assertEquals("El tamaño debe ser 2", 2, list.size());
        assertEquals("LIFO: El primero debe ser B", "B", list.getFirst());
        
        String removed = list.removeFirst();
        assertEquals("Se debió remover B", "B", removed);
        assertEquals("Ahora el primero debe ser A", "A", list.getFirst());
    }

    @Test
    public void testDoublyLinkedListOperations() {
        IList<Integer> list = new DoublyLinkedList<>();
        
        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);
        
        assertEquals("El tamaño debe ser 3", 3, list.size());
        
        Integer val = list.removeFirst();
        assertEquals("Se debió sacar el 30", Integer.valueOf(30), val);
        
        assertEquals("Ahora el tamaño es 2", 2, list.size());
    }
}