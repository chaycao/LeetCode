import java.util.HashMap;

/**
 * Created by chaycao on 2017/11/25.
 * chaycao@163.com
 */
public class Solution_205 {
    public boolean isIsomorphic(String s, String t) {
        StringBuilder a = new StringBuilder(s);
        StringBuilder b = new StringBuilder(t);
        if (a.length() != b.length())
            return false;
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < a.length(); i++) {
            char c1 = a.charAt(i);
            char c2 = b.charAt(i);
            int x1 = 0;
            int x2 = 0;
            if (!map1.containsKey(c1)) {
                map1.put(c1, index1);
                x1 = index1;
                index1++;
            } else {
                x1 = map1.get(c1);
            }
            if (!map2.containsKey(c2)) {
                map2.put(c2, index2);
                x2 = index2;
                index2++;
            } else {
                x2 = map2.get(c2);
            }
            System.out.println(x1 + ", " + x2);
            if (x1 != x2)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Solution_205 s = new Solution_205();
        System.out.println(s.isIsomorphic("122","211"));
    }
}
