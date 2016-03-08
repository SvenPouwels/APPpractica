package DataTypes;

/**
 * Created by sven_ on 08/03/2016.
 */
public class BalancedSymbolChecker {

    public static boolean symbolsBalanced(String text) {
        Character[][] symbols = {{'(', ')'}, {'[', ']'}, {'{', '}'}};
        HANStack<Character> stack = new HANStack<Character>();

        for (int i = 0; i < text.length(); i++) {
            Character c = text.charAt(i);

            for (Character[] pair: symbols){
                if (c.compareTo(pair[0]) == 0)
                    stack.push(c);
                else if (c.compareTo(pair[1]) == 0) {
                    try {
                        Character popped = stack.pop();
                        if (popped.compareTo(pair[0]) != 0)
                            return false;
                    }
                    catch(Exception e){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
