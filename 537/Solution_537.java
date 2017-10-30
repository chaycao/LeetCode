/**
 * Created by chaycao on 2017/10/30.
 * chaycao@163.com
 */
public class Solution_537 {
    public String complexNumberMultiply(String a, String b) {
        String[] s1 = a.split("\\+");
        String[] s2 = b.split("\\+");
        int a_r = Integer.valueOf(s1[0]);
        int a_i = Integer.valueOf(s1[1].substring(0, s1[1].length()-1));
        int b_r = Integer.valueOf(s2[0]);
        int b_i = Integer.valueOf(s2[1].substring(0, s2[1].length()-1));
        int c_r = a_r * b_r - (a_i * b_i);
        int c_i = a_r * b_i + a_i * b_r;
        return c_r + "+" + c_i + "i";
    }

    public static void main(String[] args) {
        System.out.println(new Solution_537().complexNumberMultiply("1+-1i","0+0i"));
    }
}
