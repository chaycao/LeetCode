import java.util.Stack;

/**
 * Created by chayc on 2017/9/24.
 */
public class Solution_weekcontest_51_1 {
    public int calPoints(String[] ops) {

        Stack<Integer> stack = new Stack<>();
        int sum = 0;

        for (int i = 0; i < ops.length; i++) {
            String s = ops[i];
            if (s.equals("C")) {
                int n = stack.pop();
                sum -= n;
            } else if (s.equals("D")) {
                int n = stack.peek();
                stack.push(n*2);
                sum += n*2;
            } else if (s.equals("+")) {
                int n1 = stack.peek();
                int n2 = stack.get(stack.size()-2);
                int temp = n1 + n2;
                stack.push(temp);
                sum += temp;
            } else { // 数字
                int n = Integer.valueOf(s);
                stack.push(n);
                sum += n;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        String[] s = {"5","-2","4","C","D","9","+","+"};
        int r = new Solution_weekcontest_51_1().calPoints(s);
        System.out.println(r);
    }
}
