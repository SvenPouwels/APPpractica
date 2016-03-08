package Trees;

public class BinaryNode<T> {
    protected T element;
    protected BinaryNode<T> left;
    protected BinaryNode<T> right;

    public BinaryNode(){
        this(null, null, null);
    }

    public BinaryNode(T element, BinaryNode<T> left, BinaryNode<T> right){
        this.element = element;
        this.left = left;
        this.right = right;
    }

    public T getElement(){
        return element;
    }

    public void setElement(T element){
        this.element = element;
    }

    public BinaryNode<T> getLeft(){
        return left;
    }

    public void setLeft(BinaryNode<T> left){
        this.left = left;
    }

    public BinaryNode<T> getRight(){
        return right;
    }

    public void setRight(BinaryNode<T> right){
        this.right = right;
    }

    public static <T> int size(BinaryNode<T> n){
        if(n == null)
            return 0;
        else
            return 1 + size(n.left) + size(n.right);
    }

    public static <T> int height(BinaryNode<T> n){
        if(n == null)
            return -1;
        else
            return 1 + Math.max(height(n.left), height(n.right));
    }

    public boolean isLeaf(){
        return left == null && right == null;
    }

    public static <T> int numLeaves(BinaryNode<T> n){
        if(n == null)
            return 0;
        int leaf = (n.left == null && n.right == null) ? 1 : 0;
        return leaf + numLeaves(n.left) + numLeaves(n.right);
    }

    public static <T> int numOne(BinaryNode<T> n){
        if(n == null)
            return 0;
        int one = (n.left == null ^ n.right == null) ? 1 : 0;
        return one + numOne(n.left) + numOne(n.right);
    }

    public static <T> int numTwo(BinaryNode<T> n){
        if(n == null)
            return 0;
        int two = (n.left != null && n.right != null) ? 1 : 0;
        return two + numTwo(n.left) + numTwo(n.right);
    }

    public BinaryNode<T> duplicate(){
        BinaryNode<T> root = new BinaryNode<T>(this.element, null, null);

        if(left != null)
            root.left = left.duplicate();
        if(right != null)
            root.right = right.duplicate();

        return root;
    }

    public void printPreOrder(){
        System.out.println(element.toString());

        if(left != null)
            left.printPreOrder();
        if(right != null)
            right.printPreOrder();
    }

    public void printPostOrder(){
        if(left != null)
            left.printPostOrder();
        if(right != null)
            right.printPostOrder();

        System.out.println(element.toString());
    }

    public void printInOrder(){
        if(left != null)
            left.printInOrder();

        System.out.println(element.toString());

        if(right != null)
            right.printInOrder();
    }
}
