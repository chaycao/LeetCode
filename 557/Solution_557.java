import java.util.Collections;

/**
 * Created by chaycao on 2017/10/30.
 * chaycao@163.com
 */
public class Solution_557 {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (i != words.length-1)
                result.append(new StringBuilder(words[i]).reverse() + " ");
            else
                result.append(new StringBuilder(words[i]).reverse());
        }
        return result.toString();
    }
}
