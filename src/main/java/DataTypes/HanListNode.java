package DataTypes;

/**
 * Created by sven_ on 03/03/2016.
 */
public class HanListNode {
    private Object value;
    private HanListNode next;

    public HanListNode(Object value) {
        this.value = value;
    }

    public HanListNode(Object value, HanListNode next) {
        this.value = value;
        this.next = next;
    }

    public void setNextNode(HanListNode next) {
        this.next = next;
    }

    public HanListNode getNextNode() {
        return next;
    }
}
