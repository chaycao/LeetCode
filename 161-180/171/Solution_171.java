/**
 * Created by chaycao on 2017/11/21.
 * chaycao@163.com
 */
public class Solution_171 {
    public int titleToNumber(String s) {
        int len = s.length();
        int r = 0;
        for (int i = 0; i < len; i++) {
            int x = s.charAt(i) - 'A' + 1;
            r = r * 26 + x;
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_171().titleToNumber("A"));
    }
}
