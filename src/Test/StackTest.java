package Test;

import Stack.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest {

    // Se prueba que el StackArrayList funcione como Pila
    @Test
    public void testStackArrayList() {
        IStack<Integer> stack = new StackArrayList<>();
        testStandardStackBehavior(stack);
    }

    // Se Prueba que el StackVector funcione como Pila
    @Test
    public void testStackVector() {
        IStack<Integer> stack = new StackVector<>();
        testStandardStackBehavior(stack);
    }

    // Se prueba que el StackList funcione como Pila
    @Test
    public void testStackListSimple() {
        // "1" indica lista simple
        IStack<Integer> stack = new StackList<>("1");
        testStandardStackBehavior(stack);
    }

    // 4. Probamos que el StackList (con lista doble) funcione como Pila
    @Test
    public void testStackListDouble() {
        // "2" indica lista doble
        IStack<Integer> stack = new StackList<>("2");
        testStandardStackBehavior(stack);
    }

    // Método auxiliar para no repetir código de prueba
    private void testStandardStackBehavior(IStack<Integer> stack) {
        // Debe iniciar vacía
        assertTrue("La pila nueva debe estar vacía", stack.isEmpty());
        assertEquals(0, stack.size());

        // Push
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Verificar tamaño
        assertEquals(3, stack.size());
        

        // Pop
        Integer val = stack.pop();
        assertEquals(Integer.valueOf(30), val);
        assertEquals(Integer.valueOf(20), stack.peek()); // Ahora el tope es 20
        assertEquals(2, stack.size());
    }
}