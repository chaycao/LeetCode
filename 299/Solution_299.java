import java.util.HashMap;

/**
 * @author chaycao
 * @description
 * @date 2018-05-18 22:58.
 */
public class Solution_299 {
    public static void main(String[] args) {
        System.out.println(getHint("1123", "0111"));
    }
    public static String getHint(String secret, String guess) {
        int num_a = 0, num_b = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < secret.length(); i++) {
            char c = secret.charAt(i);
            if (map.containsKey(c)) {
                int count = map.get(c);
                count++;
                map.put(c, count);
            } else {
                map.put(c, 1);
            }
        }

        for (int i = 0; i < secret.length(); i++) {
            char c_s = secret.charAt(i);
            char c_g = guess.charAt(i);
            if (c_s == c_g) {
                num_a++;
                int count = map.get(c_s);
                count--;
                map.put(c_s, count);
            }
        }

        for (int i = 0; i < secret.length(); i++) {
            char c_s = secret.charAt(i);
            char c_g = guess.charAt(i);
            if (c_g == c_s)
                continue;
            if (map.containsKey(c_g)) {
                int count = map.get(c_g);
                if (count > 0) {
                    count--;
                    map.put(c_g, count);
                    num_b++;
                }
            }
        }
        return num_a+"A"+num_b+"B";
    }
}
