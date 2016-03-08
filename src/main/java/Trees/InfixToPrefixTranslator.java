package Trees;

import java.util.Stack;

public class InfixToPrefixTranslator
{
    static private String expression;
    private Stack<Character> stack = new Stack<Character>();

    public InfixToPrefixTranslator(String infixExpression)
    {
        expression = infixExpression;
    }

    public String translate()
    {
        StringBuilder output = new StringBuilder();
        char character;

        for(int limit = expression.length()-1; limit >= 0 ; limit--)
        {
            character = expression.charAt(limit);

            if(isOperator(character))
            {
                if(!stack.isEmpty() && isOperator(stack.peek()) && (precedence(stack.peek()) > precedence(character))) {
                    output.append(stack.pop());
                    output.append(' ');
                }
                stack.push(character);
            }
            else if(character == ')')
            {
                stack.push(character);
            }
            else if(character == '(')
            {
                while(!stack.peek().equals(')')) {
                    output.append(stack.pop());
                    output.append(' ');
                }
                stack.pop();
            }
            else if (Character.isDigit(character))
            {
                output.append(character);
                while(limit >= 0 && Character.isDigit(expression.charAt(limit-1))) {
                    output.append(expression.charAt(limit-1));
                    limit--;
                }
                output.append(' ');
            }
        }

        while(!stack.isEmpty())
        {
            output.append(stack.pop());
            output.append(' ');
        }

        return output.reverse().deleteCharAt(0).toString();
    }

    public static int precedence(char operator)
    {
        if(operator == '+' || operator =='-')
            return 1;
        else if(operator == '*' || operator == '/')
            return 2;
        else
            return 0;
    }

    public boolean isOperator(char element)
    {
        if(element == '*' || element == '-' || element == '/' || element == '+')
            return true;
        else
            return false;
    }

}