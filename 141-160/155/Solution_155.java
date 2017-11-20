import java.util.Iterator;
import java.util.Stack;

/**
 * Created by chaycao on 2017/11/20.
 * chaycao@163.com
 */
public class Solution_155 {
    class MinStack {

        private int min = Integer.MAX_VALUE;

        private Stack<Integer> stack = new Stack<>();

        /** initialize your data structure here. */
        public MinStack() {
        }

        public void push(int x) {
            stack.push(x);
            if (x < min) {
                min = x;
            }
        }

        public void pop() {
            stack.pop();
            Iterator<Integer> iterator = stack.iterator();
            int m = Integer.MAX_VALUE;
            while (iterator.hasNext()) {
                int x = iterator.next();
                if (x < m)
                    m = x;
            }
            min = m;
        }

        public int top() {
            int r = stack.peek();
            Iterator<Integer> iterator = stack.iterator();
            int m = Integer.MAX_VALUE;
            while (iterator.hasNext()) {
                int x = iterator.next();
                if (x < m)
                    m = x;
            }
            min = m;
            return r;
        }

        public int getMin() {
            return min;
        }
    }
}
