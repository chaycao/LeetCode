import java.util.Stack;

/**
 * Created by chaycao on 2017/11/26.
 * chaycao@163.com
 */
public class Solution_weekcontest_60_3 {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] > 0)
                stack.push(asteroids[i]);
            else {
                while (true) {
                    if (stack.empty()) {
                        stack.push(asteroids[i]);
                        break;
                    }
                    int top = stack.peek();
                    if (top < 0)
                    {
                        stack.push(asteroids[i]);
                        break;
                    }
                    if (top > 0-asteroids[i])
                        break;
                    if (top == 0-asteroids[i])
                    {
                        stack.pop();
                        break;
                    }
                    // 大于
                    stack.pop();
                }
            }
        }
        int[] res = new int[stack.size()];
        for (int i = res.length-1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }
}
