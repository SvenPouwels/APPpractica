package DataTypes;

/**
 * Created by sven_ on 03/03/2016.
 */
public class HanLinkedList<T> {

    private HanListNode header;

    public HanLinkedList() {
        header = new HanListNode(null);
    }

    public void addFirst(T value) {
        HanListNode newNode = new HanListNode(value, header.getNextNode());
        header.setNextNode(newNode);
    }

    public void removeFirst() {
        header.setNextNode(header.getNextNode().getNextNode());
    }

    public void insert(int index, T value) {

    }

    public void delete(int index) {

    }

    public T get(int index) {

        return null;
    }
}
