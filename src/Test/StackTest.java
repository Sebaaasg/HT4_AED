package Test;

import Stack.IStack;
import Stack.StackList;

import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la implementación de Stack basada en listas.
 */
public class StackTest {

    /**
     * Prueba funcionamiento básico push y pop.
     */
    @Test
    public void testPushPop() {

        IStack<Integer> stack = new StackList<Integer>("singly");

        stack.push(5);
        stack.push(10);

        assertEquals(2, stack.size());
        assertEquals(10, stack.pop());
        assertEquals(5, stack.pop());
        assertTrue(stack.isEmpty());
    }

    /**
     * Verifica que peek retorne el elemento correcto sin removerlo.
     */
    @Test
    public void testPeek() {

        IStack<Integer> stack = new StackList<Integer>("doubly");

        stack.push(100);

        assertEquals(100, stack.peek());
        assertEquals(1, stack.size());
    }

    /**
     * Verifica que se lance excepción al hacer pop en stack vacío.
     */
    @Test
    public void testPopEmptyStack() {

        IStack<Integer> stack = new StackList<Integer>("singly");

        assertThrows(NoSuchElementException.class, stack::pop);
    }

    /**
     * Verifica que se lance excepción si el tipo de lista es inválido.
     */
    @Test
    public void testInvalidListType() {

        assertThrows(IllegalArgumentException.class, () -> {
            new StackList<Integer>("invalid");
        });
    }
}
