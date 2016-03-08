package Trees.Exceptions;

public class NotInTreeException extends RuntimeException{
    public NotInTreeException(String name) {
        super(name);
    }
}
