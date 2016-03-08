package Trees;


import Trees.Exceptions.NotInTreeException;

public class ChildSiblingNode<T>{
    protected T element;
    protected ChildSiblingNode<T> firstChild;
    protected ChildSiblingNode<T> nextSibling;

    public ChildSiblingNode(){
        this(null, null, null);
    }

    public ChildSiblingNode(T element, ChildSiblingNode<T> firstChild, ChildSiblingNode<T> nextSibling){
        this.element = element;
        this.firstChild = firstChild;
        this.nextSibling = nextSibling;
    }

    public void addChild(ChildSiblingNode<T> child){
        if(firstChild == null)
            firstChild = child;
        else
            getLastChild().nextSibling = child;
    }

    public void deleteChild(int index) {
        ChildSiblingNode<T> node = index < 1 ? null : getChild(index - 1);

        if (node == null){
            if (firstChild == null)
                throw new NotInTreeException("This node does not exist");
            else
                firstChild = null;
        }
        else {
            if (node.nextSibling == null)
                throw new NotInTreeException("This node does not exist");
            else
                node.nextSibling = node.nextSibling.nextSibling;
        }
    }

    public ChildSiblingNode<T> getChild(int index){
        if(firstChild == null)
            throw new NotInTreeException("This node has no children");

        ChildSiblingNode<T> node = firstChild;

        for(int i = 0; i<index; i++) {
            if(node.nextSibling == null)
                throw new NotInTreeException("There is no node at this index");

            node = firstChild.nextSibling;
        }

        return node;
    }

    private ChildSiblingNode<T> getLastChild() {
        if(firstChild == null)
            throw new NotInTreeException("This node has no children");

        ChildSiblingNode<T> node = firstChild;

        while (node != null && node.nextSibling != null)
            node = node.nextSibling;

        return node;
    }

    public boolean isLeaf(){
        return firstChild == null;
    }

    public void printPreOrder() {
        System.out.println(element.toString());

        if(firstChild != null)
            firstChild.printPreOrder();
        if(nextSibling != null)
            nextSibling.printPreOrder();

       // printPreOrder(0);
    }

    private void printPreOrder(int indent) {
        for (int i = 0; i < indent; i++)
            System.out.print(" ");

        System.out.println(element.toString());
        ChildSiblingNode<T> node = firstChild;
        while (node != null) {
            node.printPreOrder(indent+3);
            node = node.nextSibling;
        }
    }

    public void printPostOrder(){
        if(firstChild != null)
            firstChild.printPostOrder();

        System.out.println(element.toString());

        if(nextSibling != null)
            nextSibling.printPostOrder();

        //printPostOrder(0);
    }

    public void printPostOrder(int indent){
        ChildSiblingNode<T> node = firstChild;
        while (node != null) {
            node.printPostOrder(indent+3);
            node = node.nextSibling;
        }
        for (int i = 0; i < indent; i++)
            System.out.print(" ");

        System.out.println(element.toString());
    }

    public void printInOrder(){
        if(firstChild != null)
            firstChild.printInOrder();

        System.out.println(element.toString());

        if (firstChild != null && firstChild.nextSibling != null)
            firstChild.nextSibling.printInOrder();



    }
}
