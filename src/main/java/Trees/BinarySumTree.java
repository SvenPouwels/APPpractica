package Trees;


import Trees.Exceptions.InvalidSumPartException;
import Trees.Exceptions.SumTreeNotCorrectlyConstructedException;

import java.util.ArrayList;

public class BinarySumTree extends BinaryTree<SumPart> {

    public BinarySumTree(){
        super();
    }

    public BinarySumTree(String sum){
        super();
        setSum(sum);
    }

    public static void main (String[] args){
        BinarySumTree sumTree = new BinarySumTree("(15+2)*(3-(13-12))*(1+5)");

        sumTree.printInOrder();
        System.out.println("(15+2)*(3-(13-12))*(1+5) = " + sumTree.calculate()); //should be 17*12 = 204

        sumTree.setSum("(5*4+6)*2-(6/2*(2+1)/3)");
        sumTree.printInOrder();
        System.out.println("(5*4+6)*2-(6/2*(2+1)/3) = " + sumTree.calculate()); // should be 52 -3 = 49
    }

    public int calculate(){
        return calculate(root);
    }

    public void setSum(String sum){
        if(sum.length() < 3)
            throw new SumTreeNotCorrectlyConstructedException("A sum should consist of at least three parts, one operator and two operandi");
        if(sum.indexOf(' ') >= 0)
            throw new SumTreeNotCorrectlyConstructedException("Spaces are not allowed in the sum");

        ArrayList<BinaryNode<SumPart>> nodes = new ArrayList<BinaryNode<SumPart>>();
        InfixToPrefixTranslator translator = new InfixToPrefixTranslator(sum);
        sum = translator.translate();

        String[] sumParts = sum.split(" ");

        root = new BinaryNode<SumPart>(new SumPart(sumParts[0]), null, null);
        nodes.add(root);

        BinaryNode<SumPart> node;

        for(int i = 1; i<sumParts.length; i++){
            node = nodes.get(nodes.size()-1);

            if(node.left == null) {
                node.left = new BinaryNode<SumPart>(new SumPart(sumParts[i]), null, null);
                if(SumPart.validOperandus(sumParts[i]))
                    nodes.add(node.left);
            }
            else{
                while (node.right != null) {
                    nodes.remove(nodes.size() - 1);
                    node = nodes.get(nodes.size()-1);
                }

                node.right = new BinaryNode<SumPart>(new SumPart(sumParts[i]), null, null);
                if(SumPart.validOperandus(sumParts[i]))
                    nodes.add(node.right);
            }
        }
    }

    private String getPartSum(String substring) {
        return substring.substring(0, substring.indexOf(' ') == -1 ? substring.length() : substring.indexOf(' '));
    }

    private int calculate(BinaryNode<SumPart> node){
        if(node.left == null || node.right == null)
            throw new SumTreeNotCorrectlyConstructedException("The tree is not constructed correctly");

        int left = node.left.element.operandus == null ? node.left.element.number : calculate(node.left);
        int right = node.right.element.operandus == null ? node.right.element.number : calculate(node.right);

        if (node.element.operandus == null)
            throw new SumTreeNotCorrectlyConstructedException("The tree is not constructed correctly");

        else if (node.element.operandus.equals("+"))
            return left + right;

        else if (node.element.operandus.equals("/"))
            return left / right;

        else if (node.element.operandus.equals("*"))
            return left * right;

        else if (node.element.operandus.equals("-"))
            return left - right;

        else
            throw new InvalidSumPartException();
    }
}
