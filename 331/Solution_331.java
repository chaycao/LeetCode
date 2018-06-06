import java.util.HashMap;
import java.util.Stack;

/**
 * @author chaycao
 * @description
 * @date 2018-06-06 19:50.
 */
public class Solution_331 {
    public static boolean isValidSerialization(String preorder) {
        if (preorder.length() == 1 && !preorder.equals("#"))
            return false;
        char[] chars = preorder.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]==',') {
                if (chars[i-1] == '#') {
                    if (count > 0)
                        count--;
                    else
                        return false;
                } else {
                    count++;
                }
            }
        }
        if (count != 0)
            return false;
        else
            return true;
    }

    public static void main(String[] args) {
        String input = "#";
        System.out.println(isValidSerialization(input));
    }
}
