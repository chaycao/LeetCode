import java.util.ArrayList;
import java.util.List;

/**
 * Title:
 *
 * @author chaycao
 * @description:
 * @date 2018-01-08 15:16.
 */
public class Solution_241 {
    public List<Integer> diffWaysToCompute(String input) {
        int len = input.length();
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < len-1; i++) {
            if (input.charAt(i) == '*' ||
                input.charAt(i) == '+' ||
                input.charAt(i) == '-') {
                String left = input.substring(0, i);
                String right = input.substring(i+1, len);
                List<Integer> left_res = diffWaysToCompute(left);
                List<Integer> right_res = diffWaysToCompute(right);
                int temp = 0;
                for (int left_par : left_res) {
                    for (int right_par : right_res) {
                        switch (input.charAt(i)) {
                            case '*':
                                temp = left_par * right_par;
                                break;
                            case '+':
                                temp = left_par + right_par;
                                break;
                            case '-':
                                temp = left_par - right_par;
                                break;
                        }
                        res.add(temp);
                    }
                }
            }
        }
        if (res.size() == 0)
            res.add(Integer.valueOf(input));
        return res;
    }
}
