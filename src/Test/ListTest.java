package Test;

import List.IList;
import List.SinglyLinkedList;
import List.DoublyLinkedList;
import org.junit.Test;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * Pruebas unitarias para las implementaciones de listas.
 */
public class ListTest {

    // Verifica el comportamiento de inserción y eliminación en la Lista Simple.
    // Se espera que los datos entren y salgan respetando la lógica de "agregar al inicio"
    @Test
    public void testSinglyAddAndRemove() {
        IList<Integer> list = new SinglyLinkedList<>();

        // se agregan elementos al inicio de la lista
        list.addFirst(10); 
        list.addFirst(20); 

        // se comprueba que el tamaño se haya actualizado correctamente a 2
        assertEquals(2, list.size());
        
        // Como '20' fue el último en entrar al inicio, debe ser el primero en salir
        assertEquals(Integer.valueOf(20), list.removeFirst());
        
        // El siguiente en salir debe ser el '10'
        assertEquals(Integer.valueOf(10), list.removeFirst());
        
        // Al sacar ambos elementos, la lista debe reportar que está vacía
        assertTrue(list.isEmpty());
    }

    // Verifica el comportamiento en la Lista Doblemente Enlazada.
    // La lógica debe ser idéntica a la simple para el usuario externo
    @Test
    public void testDoublyAddAndRemove() {
        IList<Integer> list = new DoublyLinkedList<>();
        
        list.addFirst(1);
        list.addFirst(2);

        assertEquals(2, list.size());
        assertEquals(Integer.valueOf(2), list.removeFirst());
        assertEquals(Integer.valueOf(1), list.removeFirst());
        assertTrue(list.isEmpty());
    }

    // Sintaxis clásica de JUnit 4 para probar si se lanza un error
    @Test(expected = NoSuchElementException.class)
    public void testRemoveFromEmptyList() {
        IList<Integer> list = new SinglyLinkedList<>();
        list.removeFirst(); // Esto debe lanzar el error
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddNullValue() {
        IList<Integer> list = new SinglyLinkedList<>();
        list.addFirst(null); // Esto debe lanzar el error
    }
}