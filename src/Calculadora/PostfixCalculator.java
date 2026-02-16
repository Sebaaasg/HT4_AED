package Calculadora;

import Stack.IStack;
import Stack.StackFactory;

public class PostfixCalculator {
    
    private StackFactory factory;
    private String tipoPila; 
    private String tipoLista;

    public PostfixCalculator(String tipoPila, String tipoLista) {
        this.factory = new StackFactory();
        this.tipoPila = tipoPila;
        this.tipoLista = tipoLista;
    }

    
    // Convertir de Infix a Postfix
    // Ejemplo de (1+2)*9 a 1 2 + 9 *
    public String infixToPostfix(String expresion) {
        // Crear una pila para guardar operadores temporalmente
        IStack<Character> pila = factory.createStack(tipoPila, tipoLista);
        String resultado = "";
        
        // Recorrer la expresión letra por letra
        for (int i = 0; i < expresion.length(); i++) {
            char caracter = expresion.charAt(i); // Se obtiene la letra actual

            // CASO 1 Si es un número 
            if (esNumero(caracter)) {
                // Se lee el número completo 
                String numero = "";
                while (i < expresion.length() && esNumero(expresion.charAt(i))) {
                    numero = numero + expresion.charAt(i);
                    i++; // avanzar al siguiente dígito
                }
                // Como el while avanzó uno de más, se retrocede uno para que el for no se salte nada
                i--; 
                resultado = resultado + numero + " ";
            }
            // CASO 2 Si es paréntesis de apertura
            else if (caracter == '(') {
                pila.push(caracter);
            }
            // CASO 3 Si es paréntesis de cierre
            else if (caracter == ')') {
                // Se saca todo de la pila hasta encontrar el '('
                while (!pila.isEmpty() && pila.peek() != '(') {
                    resultado = resultado + pila.pop() + " ";
                }
                pila.pop(); // Se elimina el '(' de la pila
            }
            // CASO 4 Si es un operador
            else if (esOperador(caracter)) {
                // Se verifica la jerarquía, si el que está en la pila es más importante, se saca primero
                while (!pila.isEmpty() && jerarquia(caracter) <= jerarquia(pila.peek())) {
                    resultado = resultado + pila.pop() + " ";
                }
                pila.push(caracter); // Se guarda el operador actual
            }
            // Si es un espacio en blanco, se ignora
        }

        // Se vacía lo que haya quedado en la pila
        while (!pila.isEmpty()) {
            resultado = resultado + pila.pop() + " ";
        }

        return resultado.trim(); // Se quitan los espacios sobrantes al final
    }

    
    // Evaluar la expresión Postfix    
    public double evaluatePostfix(String expresion) {
        // Pila para números 
        IStack<Double> pila = factory.createStack(tipoPila, tipoLista);
        
        // Se separa el texto por espacios 
        String[] elementos = expresion.split(" "); 

        for (String token : elementos) {
            // Si el token está vacío se salta
            if (token.isEmpty()) continue;

            // Si es un número, se guarda
            if (esNumero(token.charAt(0))) { 
                pila.push(Double.parseDouble(token));
            } 
            // Si es operador, se sacan los dos últimos números y se opera
            else if (esOperador(token.charAt(0))) {
                if (pila.size() < 2) return 0; // Protección por si acaso
                
                double valorB = pila.pop(); // El último en entrar es el segundo operando
                double valorA = pila.pop(); // El penúltimo es el primero
                
                double resultado = operar(valorA, valorB, token.charAt(0));
                pila.push(resultado);
            }
        }
        
        // El resultado final es lo único que queda en la pila
        return pila.isEmpty() ? 0 : pila.pop();
    }

    //  MÉTODOS AYUDANTES

    // Dice si un caracter es dígito
    private boolean esNumero(char c) {
        return (c >= '0' && c <= '9');
    }

    // Dice si un caracter es operador
    private boolean esOperador(char c) {
        return (c == '+' || c == '-' || c == '*' || c == '/' || c == '^');
    }

    // Devuelve el nivel de jerarquía de un operador
    // Mayor número = Mayor prioridad
    private int jerarquia(char operador) {
        if (operador == '^') return 3;
        if (operador == '*' || operador == '/') return 2;
        if (operador == '+' || operador == '-') return 1;
        return 0; // Cualquier otra cosa tiene prioridad 0
    }

    // Realiza la operación matemática básica
    private double operar(double a, double b, char operador) {
        if (operador == '+') return a + b;
        if (operador == '-') return a - b;
        if (operador == '*') return a * b;
        if (operador == '/') return a / b;
        if (operador == '^') return Math.pow(a, b);
        return 0;
    }
}