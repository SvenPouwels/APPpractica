package Trees;

import java.util.ArrayList;

public class BinaryTree<T> {
    protected BinaryNode<T> root;

    public BinaryTree(){
        root = null;
    }

    public BinaryTree(T element){
        root = new BinaryNode<T>(element, null, null);
    }

    public static void main (String[] args) {
        BinaryTree<String> tree = new BinaryTree<String>();
        ArrayList<BinaryNode<String>> nodes = new ArrayList<BinaryNode<String>>();

        nodes.add(new BinaryNode<String>("M", null, null));
        nodes.add(new BinaryNode<String>("L", null, null));
        nodes.add(new BinaryNode<String>("K", null, null));
        nodes.add(new BinaryNode<String>("J", nodes.get(1), nodes.get(0)));
        nodes.add(new BinaryNode<String>("I", null, null));
        nodes.add(new BinaryNode<String>("H", null, null));
        nodes.add(new BinaryNode<String>("G", null, null));
        nodes.add(new BinaryNode<String>("F", null, nodes.get(2)));
        nodes.add(new BinaryNode<String>("E", nodes.get(4), nodes.get(3)));
        nodes.add(new BinaryNode<String>("D", nodes.get(6), nodes.get(5)));
        nodes.add(new BinaryNode<String>("C", null, nodes.get(7)));
        nodes.add(new BinaryNode<String>("B", nodes.get(9), nodes.get(8)));
        nodes.add(new BinaryNode<String>("A", nodes.get(11), nodes.get(10)));

        tree.root = nodes.get(12);

        System.out.println("Root of the tree:" + tree.root.element);

        for(BinaryNode<String> node: nodes) {
            if (node.isLeaf())
                System.out.print(node.element + ", ");
        }
        System.out.println();

        System.out.println("Height for each node: ");
        for(BinaryNode<String> node: nodes)
            System.out.println(node.element + " - " + BinaryNode.height(node));

        System.out.print("Number of leaves in tree: ");
        System.out.println(BinaryNode.numLeaves(tree.root));

        System.out.print("Number of nodes with one non-null child: ");
        System.out.println(BinaryNode.numOne(tree.root));

        System.out.print("Number of nodes with two non-null children: ");
        System.out.println(BinaryNode.numTwo(tree.root));

        System.out.println("Tree in PreOrder:");
        tree.printPreOrder();
        System.out.println("Tree in PostOrder:");
        tree.printPostOrder();
        System.out.println("Tree in InOrder:");
        tree.printInOrder();
    }

    public BinaryNode<T> getRoot(){
        return root;
    }

    public int size(){
        return BinaryNode.size(root);
    }

    public int height(){
        return BinaryNode.height(root);
    }

    public void printPreOrder(){
        if(root != null)
            root.printPreOrder();
    }

    public void printPostOrder(){
        if(root != null)
            root.printPostOrder();
    }

    public void printInOrder(){
        if(root != null)
            root.printInOrder();
    }

    public void makeEmpty(){
        root = null;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public void merge(T element, BinaryTree<T> t1, BinaryTree<T> t2){
        if(t1.root == t2.root && t1.root != null)
            throw new IllegalArgumentException();

        root = new BinaryNode<T>(element, t1.root, t2.root);

        if(this != t1)
            t1.root = null;
        if(this != t2)
            t2.root = null;
    }
}
