package Stack;

// se evita repetir el código de isEmpty() en cada implementación
public abstract class AbstractStack<T> implements IStack<T> {

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
    
}
