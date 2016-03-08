package Trees;

public class AVLTree extends BinarySearchTree{
    
    public AVLTree(){
        super();
    }

    public static void main (String[] args) {
        AVLTree avlTree = new AVLTree();
        avlTree.insert(10);
        avlTree.insert(1);
        avlTree.insert(15);
        avlTree.insert(5);
        avlTree.insert(2);
        avlTree.insert(3);
        avlTree.insert(20);
        avlTree.insert(6);

        avlTree.printInOrder();
    }

    public void insert(int value){
        root = insert(value, root);

        unbalance(unBalancedNode(root));
    }

    protected BinaryNode<Integer> insert(int value, BinaryNode<Integer> n){
        if(n == null)
            n = new BinaryNode<Integer>(value, null, null);
        else if(value < n.element){
            n.left = insert(value, n.left);
        }
        else if (value > n.element){
            n.right = insert(value, n.right);
        }
        else
            throw new IllegalStateException(Integer.toString(value));

        return n;
    }

    private void unbalance(BinaryNode<Integer> n){
        if(n != null) {
            if (n.left == null && n.right != null) {
                if (n.right.left != null)
                    doubleRotateWithRightChild(n);
                else if (n.right.right != null)
                    rotateWithRightChild(n);
            } else if (n.right == null && n.left != null) {
                if (n.left.left != null)
                    rotateWithLeftChild(n);
                else if (n.left.right != null)
                    doubleRotateWithLeftChild(n);
            }
        }
    }

    private BinaryNode<Integer> unBalancedNode(BinaryNode<Integer> n){
        if(n == null || (n.left == null && n.right == null))
            return null;

        else if (n.left != null && unBalancedNode(n.left) != null)
            return unBalancedNode(n.left);
        else if (n.right != null && unBalancedNode(n.right) != null)
            return unBalancedNode(n.right);

        else if(n.left == null && (n.right.left != null || n.right.right != null))
            return n;
        else if(n.right == null && (n.left.left != null || n.left.right != null))
            return n;

        return null;
    }

    private BinaryNode<Integer> getParent(BinaryNode<Integer> n){
        if(root == n)
            return null;

        return getParent(root, n);
    }
    
    private BinaryNode<Integer> getParent(BinaryNode<Integer> nHigher, BinaryNode<Integer> n){
        if((nHigher.left != null && nHigher.left.element.compareTo(n.element) == 0)
                || (nHigher.right != null && nHigher.right.element.compareTo(n.element) == 0))
            return nHigher;

        else if(nHigher.element.compareTo(n.element) > 0)
            return getParent(nHigher.left, n);
        else if (nHigher.element.compareTo(n.element) < 0)
            return getParent(nHigher.right, n);

        return null;
    }
    
    private BinaryNode<Integer> rotateWithLeftChild(BinaryNode<Integer> n2){
        BinaryNode<Integer> n1 = n2.left;
        n2.left = n1.right;
        n1.right = n2;

        BinaryNode<Integer> parent = getParent(n2);

        if(parent != null) {
            if (parent.left != null && parent.left.element.equals(n1.right.element))
                parent.left = n1;
            else
                parent.right = n1;
        }

        return n1;
    }

    private BinaryNode<Integer> rotateWithRightChild(BinaryNode<Integer> n1){
        BinaryNode<Integer> n2 = n1.right;
        n1.right = n2.left;
        n2.left = n1;

        BinaryNode<Integer> parent = getParent(n1);

        if(parent != null) {
            if (parent.left != null && parent.left.element.equals(n2.left.element))
                parent.left = n2;
            else
                parent.right = n2;
        }

        return n2;
    }

    private BinaryNode<Integer> doubleRotateWithLeftChild(BinaryNode<Integer> n){
        n.left = rotateWithRightChild(n.left);
        return rotateWithLeftChild(n);
    }

    private BinaryNode<Integer> doubleRotateWithRightChild(BinaryNode<Integer> n){
        n.right = rotateWithLeftChild(n.right);
        return rotateWithRightChild(n);
    }
}
