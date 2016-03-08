package Trees.Exceptions;

public class DuplicateItemException extends RuntimeException{
    public DuplicateItemException(String name) {
        super(name);
    }
}
