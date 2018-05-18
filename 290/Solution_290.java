import java.util.HashMap;

/**
 * @author chaycao
 * @description
 * @date 2018-05-18 22:27.
 */
public class Solution_290 {
    public static boolean wordPattern(String pattern, String str) {
        char[] chars = pattern.toCharArray();
        String[] strs = str.split(" ");
        if (chars.length != strs.length)
            return false;
        HashMap<Character, String> p_s_map = new HashMap<>();
        HashMap<String, Character> s_p_map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            String s = p_s_map.get(chars[i]);
            if (s == null)
                p_s_map.put(chars[i], strs[i]);
            else {
                if (!s.equals(strs[i]))
                    return false;
            }
            Character c = s_p_map.get(strs[i]);
            if (c == null)
                s_p_map.put(strs[i], chars[i]);
            else {
                if (!c.equals(chars[i]))
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String pattern = "abba";
        String str = "dog dog dog dog";
        System.out.println(wordPattern(pattern, str));
    }
}
