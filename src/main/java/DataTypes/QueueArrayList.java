package DataTypes;

import java.util.ArrayList;

/**
 * Created by sven_ on 08/03/2016.
 */
public class QueueArrayList<T> {
    ArrayList<T> list = new ArrayList();

    public void enqueue (T value) {
        list.add(value);
    }

    public T dequeue() {
        T value = list.get(0);
        list.remove(0);
        return value;
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}
