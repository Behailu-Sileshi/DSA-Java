package datastructures.Linear.Stacks;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BalancedExpression {

    private final List<Character> leftBrackets = Arrays.asList('(', '[', '{', '<');
    private final List<Character> rightBrackets = Arrays.asList(')', ']', '}', '>');

    public boolean isBracketMatch(String str) {
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            if (isLeftBracket(ch))
                stack.push(ch);
            if (isRightBracket(ch))
                if (stack.isEmpty()) return false;
                else {
                    char top = stack.pop();
                    if (!isBracketMatch(ch, top)) return false;
                }
        }
            return stack.empty();
    }
    private boolean isLeftBracket(char ch) {
        return (leftBrackets.contains(ch));
    }
    private boolean isRightBracket(char ch) {
        return (rightBrackets.contains(ch));
    }
    private boolean isBracketMatch(char right, char left) {
       return  rightBrackets.indexOf(right) == leftBrackets.indexOf(left);
    }
}
