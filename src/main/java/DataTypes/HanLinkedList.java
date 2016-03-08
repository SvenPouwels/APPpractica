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
        HanListNode<T> node = header;

        for(int i = 0; i<index + 1; i++) {
            if (node.getNextNode() == null)
                throw new ArrayIndexOutOfBoundsException();

            node = node.getNextNode();
        }
        node.setValue(value);
    }

    public void delete(int index) {
        HanListNode<T> node = header;
        HanListNode<T> PreviousNode = header;
        for(int i = 0; i<index + 1; i++) {
            if (node.getNextNode() == null)
                throw new ArrayIndexOutOfBoundsException();

            node = node.getNextNode();
        }
        for(int i = 0; i<index; i++) {
            if (node.getNextNode() == null)
                throw new ArrayIndexOutOfBoundsException();

            PreviousNode = node.getNextNode();
        }
        PreviousNode.setNextNode(node.getNextNode());
    }

    public T get(int index){
        HanListNode<T> node = header;

        for(int i = 0; i<index + 1; i++) {
            if (node.getNextNode() == null)
                throw new ArrayIndexOutOfBoundsException();

            node = node.getNextNode();
        }

        return node.getValue();
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Items in List: [");

        HanListNode<T> node = header;
        while(node.getNextNode() != null) {
            builder.append(node.getNextNode().getValue());
            node = node.getNextNode();
            if (node != null) {
                builder.append(", ");
            }
        }

        builder.append("]");
        return builder.toString();
    }
}
