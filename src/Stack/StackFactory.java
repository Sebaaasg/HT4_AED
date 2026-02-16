package Stack;


// Patrón para la creación de pilas.
// Permite desacoplar la lógica de la calculadora de la implementación específica de la pila
public class StackFactory {

    // Constantes para evitar errores de "dedo" 
    public static final String ARRAYLIST = "1";
    public static final String VECTOR = "2";
    public static final String LIST = "3";


    // Crea una instancia de pila según el tipo solicitado.
    // @param type El tipo de pila deseada
    // @return Una instancia de IStack
    public <T> IStack<T> createStack(String type) {
        switch (type) {
            case ARRAYLIST:
                return new StackArrayList<>();
            case VECTOR:
                return new StackVector<>();
            case LIST:
                // return new StackList<>(); 
                throw new UnsupportedOperationException("La implementación de Lista aún no está lista.");
            default:
                return null;
        }
    }
}