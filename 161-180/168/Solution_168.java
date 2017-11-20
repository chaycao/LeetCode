/**
 * Created by chaycao on 2017/11/20.
 * chaycao@163.com
 */
public class Solution_168 {
    public String convertToTitle(int n) {
        StringBuilder res = new StringBuilder();
        while (n > 0) {
            n--;
            res.insert(0, (char)('A' + n % 26));
            n /= 26;
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution_168().convertToTitle(17575));
    }
}
