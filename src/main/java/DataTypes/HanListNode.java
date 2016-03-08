package DataTypes;

/**
 * Created by sven_ on 03/03/2016.
 */
public class HanListNode<T> {
    private T value;
    private HanListNode next;

    public HanListNode(T value) {
        this.value = value;
    }

    public HanListNode(T value, HanListNode next) {
        this.value = value;
        this.next = next;
    }

    public void setNextNode(HanListNode next) {
        this.next = next;
    }

    public HanListNode getNextNode() {
        return next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
