package Test;

import Stack.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Pruebas unitarias para TODAS las implementaciones de Stack.
 */
public class StackTest {

    // Prueba la implementación de pila basada en el ArrayList de Java.
    @Test
    public void testStackArrayList() {
        IStack<Integer> stack = new StackArrayList<>();
        testStandardStackBehavior(stack);
    }

    // Prueba la implementación de pila basada en el Vector de Java.
    @Test
    public void testStackVector() {
        IStack<Integer> stack = new StackVector<>();
        testStandardStackBehavior(stack);
    }

    // Prueba la implementación del Patrón Adapter usando una Lista Simplemente Enlazada.
    @Test
    public void testStackListSimple() {
        // Probamos usando la palabra clave de tu compañero
        IStack<Integer> stack = new StackList<>("singly");
        testStandardStackBehavior(stack);
    }

    // Prueba la implementación del Patrón Adapter usando una Lista Doblemente Enlazada.
    @Test
    public void testStackListDouble() {
        // "doubly" le indica al Factory interno que construya una lista doble
        IStack<Integer> stack = new StackList<>("doubly");
        testStandardStackBehavior(stack);
    }

    // Método auxiliar para no repetir código
    private void testStandardStackBehavior(IStack<Integer> stack) {

        // Una pila recién creada debe estar vacía
        assertTrue("La pila debe iniciar vacía", stack.isEmpty());
        
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // se verifica el tamaño y el último elemento sin sacarlo 
        assertEquals(3, stack.size());
        assertEquals(Integer.valueOf(30), stack.peek()); // LIFO

        Integer val = stack.pop();
        assertEquals(Integer.valueOf(30), val);

        // se comprueba que el tope se actualizó y el tamaño disminuyó
        assertEquals(Integer.valueOf(20), stack.peek());
        assertEquals(2, stack.size());
    }

    // Prueba de la excepción al crear una lista inválida (Idea rescatada de tu compañero)
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidListType() {
        new StackList<Integer>("inválido");
    }
}