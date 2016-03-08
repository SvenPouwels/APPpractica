package Trees;


import Trees.Exceptions.DuplicateItemException;
import Trees.Exceptions.ItemNotFoundException;

public class BinarySearchTree extends BinaryTree<Integer>{

    public BinarySearchTree(){
        super();
    }

    public BinarySearchTree(int element){
        super(element);
    }

    public static void main (String[] args){
        BinarySearchTree searchTree = new BinarySearchTree();
        searchTree.insert(3);
        searchTree.insert(1);
        searchTree.insert(4);
        searchTree.insert(6);
        searchTree.insert(9);
        searchTree.insert(2);
        searchTree.insert(5);
        searchTree.insert(7);

        System.out.println("De boom in InOrder:");
        searchTree.printInOrder();

        searchTree.remove(3);
        System.out.println("De boom in InOrder na verwijderen root:");
        searchTree.printInOrder();

        System.out.println(searchTree.find(9) + " is gevonden");
        System.out.println(searchTree.findMin() + " = de laagste waarde");

        System.out.println("De boom:");
        searchTree.printInOrder();

        System.out.println("De boom nadat 7 is verwijderd:");
        searchTree.remove(7);
        searchTree.printInOrder();

        System.out.println("De boom nadat de laagste waarde (1) is verwijderd:");
        searchTree.removeMin(searchTree.root);
        searchTree.printInOrder();
    }

    public void insert(int value){
        root = insert(value, root);
    }

    public void remove(int value) {
        root = remove(value, root);
    }

    public int findMin(){
        return elementAt(findMin(root));
    }

    public int findMax(){
        return elementAt(findMax(root));
    }

    public int find(int value){
        return elementAt(find(value, root));
    }

    private int elementAt(BinaryNode<Integer> n){
        if(n == null)
            throw new ItemNotFoundException();

        return n.element;
    }

    private BinaryNode<Integer> find(int value, BinaryNode<Integer> n){
        if(n == null)
            throw new ItemNotFoundException();
        if(n.element == value)
            return n;
        else if (n.element > value)
            return find(value, n.left);
        else
            return find(value, n.right);

        /*
        while(n != null){
            if(n.element == value)
                return n;
            else if (n.element > value)
                n = n.left;
            else if (n.element < value)
                n = n.right;
        }

        return null;
        */
    }

    protected BinaryNode<Integer> findMin(BinaryNode<Integer> n){
        if(n.left == null)
            return n;
        else
            return findMin(n.left);
        /*
        if(n != null) {
            while (n.left != null)
                n = n.left;
        }
        return n;
        */
    }

    protected BinaryNode<Integer> findMax(BinaryNode<Integer> n){
        if(n.right == null)
            return n;
        else
            return findMax(n.right);
        /*
        if(n != null){
            while (n.right != null)
                n = n.right;
        }
        return n;
        */
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
            throw new DuplicateItemException(Integer.toString(value));
        return n;
    }

    protected BinaryNode<Integer> removeMin(BinaryNode<Integer> n){
        if(n == null)
            throw new ItemNotFoundException();

        else if(n.left != null) {
            n.left = removeMin(n.left);
            return n;
        }
        else
            return n.right;

    }

    protected BinaryNode<Integer> remove(int value, BinaryNode<Integer> n){
        if(n == null)
            throw new ItemNotFoundException();

        if(value < n.element)
            n.left = remove(value, n.left);
        else if (value > n.element)
            n.right = remove(value, n.right);
        else if (n.left != null && n.right != null){
            n.element = findMin(n.right).element;
            n.right = removeMin(n.right);
        }
        else
            n = (n.left != null) ? n.left : n.right;
        
        return n;
    }
}
