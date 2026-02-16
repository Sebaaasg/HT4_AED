import Calculadora.PostfixCalculator;
import Stack.StackFactory;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("== Calculadora de Expresiones Infix a Postfix ==");
        System.out.println("Seleccione la implementación del Stack:");
        System.out.println("1. ArrayList");
        System.out.println("2. Vector");
        System.out.println("3. Lista");
        System.out.print("Opción: ");
        
        String tipoStack = scanner.nextLine();
        
        // Validación básica
        if (!tipoStack.equals("1") && !tipoStack.equals("2") && !tipoStack.equals("3")) {
            System.out.println("Opción no válida. Usando ArrayList por defecto.");
            tipoStack = StackFactory.ARRAYLIST;
        }

        try {
            String expresion = leerArchivo("datos.txt");
            System.out.println("\nExpresión leída del archivo: " + expresion);
            
            PostfixCalculator calculadora = new PostfixCalculator(tipoStack);
            
            // Convertir
            String postfix = calculadora.infixToPostfix(expresion);
            System.out.println("Expresión Postfix generada: " + postfix);
            
            // Evaluar
            double resultado = calculadora.evaluatePostfix(postfix);
            System.out.println("Resultado de la evaluación: " + resultado);
            
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    
    // Lee la primera línea del archivo datos.txt
    // @param ruta Ruta del archivo
    
    public static String leerArchivo(String ruta) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea = br.readLine();
            if (linea == null) {
                throw new IOException("El archivo está vacío");
            }
            return linea;
        }
    }
}