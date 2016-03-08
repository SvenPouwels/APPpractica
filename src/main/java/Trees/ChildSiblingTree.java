package Trees;

import java.util.ArrayList;

public class ChildSiblingTree<T> {
    protected ChildSiblingNode<T> root;

    public ChildSiblingTree(){
        root = null;
    }

    public ChildSiblingTree(T element){
        root = new ChildSiblingNode<T>(element, null, null);
    }

    public static void main (String[] args) {
        ChildSiblingTree<String> tree = new ChildSiblingTree<String>();

        ArrayList<ChildSiblingNode<String>> nodes = new ArrayList<ChildSiblingNode<String>>();

        nodes.add(new ChildSiblingNode<String>("M", null, null));
        nodes.add(new ChildSiblingNode<String>("L", null, nodes.get(0)));
        nodes.add(new ChildSiblingNode<String>("K", null, null));
        nodes.add(new ChildSiblingNode<String>("J", nodes.get(1), null));
        nodes.add(new ChildSiblingNode<String>("I", null, nodes.get(3)));
        nodes.add(new ChildSiblingNode<String>("H", null, null));
        nodes.add(new ChildSiblingNode<String>("G", null, nodes.get(5)));
        nodes.add(new ChildSiblingNode<String>("F", nodes.get(2), null));
        nodes.add(new ChildSiblingNode<String>("E", nodes.get(4), null));
        nodes.add(new ChildSiblingNode<String>("D", nodes.get(6), nodes.get(8)));
        nodes.add(new ChildSiblingNode<String>("C", nodes.get(7), null));
        nodes.add(new ChildSiblingNode<String>("B", nodes.get(9), nodes.get(10)));
        nodes.add(new ChildSiblingNode<String>("A", nodes.get(11), null));

        tree.root = nodes.get(12);

        System.out.println("Tree in PreOrder:");
        tree.printPreOrder();
        System.out.println("Tree in PostOrder:");
        tree.printPostOrder();
        System.out.println("Tree in InOrder:");
        tree.printInOrder();
    }

    public ChildSiblingNode<T> getRoot(){
        return root;
    }

    public void setRoot(ChildSiblingNode<T> node){
        root = node;
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
}
