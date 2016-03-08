package DataTypes;

/**
 * Created by sven_ on 08/03/2016.
 */
public class HANStack<T> {
    private HanLinkedList<T> list = new HanLinkedList();
    public void push(T value) {
        list.addFirst(value);
    }

    public T pop() {
        T value = list.get(0);
        list.removeFirst();

        return value;
    }

    public T top(){
        return list.get(0);
    }

    public String toString() {
        return list.toString();
    }
}
