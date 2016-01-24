package zadanie4;

@FunctionalInterface
public interface Executeable<T>{
    public T execute(T t);
}