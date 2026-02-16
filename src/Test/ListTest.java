package Test;

import List.IList;
import List.SinglyLinkedList;
import List.DoublyLinkedList;

import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para las implementaciones de listas.
 */
public class ListTest {

    /**
     * Prueba inserción y eliminación en lista simplemente enlazada.
     */
    @Test
    public void testSinglyAddAndRemove() {

        IList<Integer> list = new SinglyLinkedList<>();

        list.addFirst(10);
        list.addFirst(20);

        assertEquals(2, list.size());
        assertEquals(20, list.removeFirst());
        assertEquals(10, list.removeFirst());
        assertTrue(list.isEmpty());
    }

    /**
     * Prueba inserción y eliminación en lista doblemente enlazada.
     */
    @Test
    public void testDoublyAddAndRemove() {

        IList<Integer> list = new DoublyLinkedList<>();

        list.addFirst(1);
        list.addFirst(2);

        assertEquals(2, list.size());
        assertEquals(2, list.removeFirst());
        assertEquals(1, list.removeFirst());
        assertTrue(list.isEmpty());
    }

    /**
     * Verifica que se lance excepción al eliminar de lista vacía.
     */
    @Test
    public void testRemoveFromEmptyList() {

        IList<Integer> list = new SinglyLinkedList<>();

        assertThrows(NoSuchElementException.class, list::removeFirst);
    }

    /**
     * Verifica que no se permitan valores null.
     */
    @Test
    public void testAddNullValue() {

        IList<Integer> list = new SinglyLinkedList<>();

        assertThrows(IllegalArgumentException.class, () -> list.addFirst(null));
    }
}
