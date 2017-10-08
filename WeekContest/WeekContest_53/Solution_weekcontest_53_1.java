/**
 * Created by chayc on 2017/10/8.
 */
public class Solution_weekcontest_53_1 {
    public boolean hasAlternatingBits(int n) {
        int temp = n%2;
        n /= 2;
        while (n!=0) {
            int x = n%2;
            if (x == temp) {//不交替
                return false;
            }
            temp = x;
            n /= 2;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_weekcontest_53_1().hasAlternatingBits(1));
    }
}
