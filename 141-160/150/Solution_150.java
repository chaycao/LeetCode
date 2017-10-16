import java.util.Stack;

/**
 * Created by chayc on 2017/10/16.
 */
public class Solution_150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String s = tokens[i];
            int a, b;
            switch (s) {
                case "+":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a+b);
                    break;
                case "-":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a-b);
                    break;
                case "*":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a*b);
                    break;
                case "/":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a/b);
                    break;
                default:
                    stack.push(Integer.valueOf(s));
                    break;
            }
        }
        return stack.pop();
    }
}
