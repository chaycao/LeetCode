/**
 * Created by chayc on 2017/10/1.
 */
public class Solution_weekcontest_52_1 {
    public int repeatedStringMatch(String A, String B) {
        int result = 1;
        int a_len = A.length();
        int b_len = B.length();
        int temp = a_len;
        StringBuilder s = new StringBuilder(A);
        while (temp < b_len) {
            temp += a_len;
            result++;
            s.append(A);
        }
        int flag = 0;
        while (true) {
            if (isSubString(s.toString(), B) == true)
                return result;
            result++;
            if(flag >= 3)
                return -1;
            flag++;
            s.append(A);
        }
    }
    public boolean isSubString(String A, String B) {
        int a_len = A.length();
        int b_len = B.length();
        for (int i = 0; i <= a_len-b_len; i++) {
            if (A.substring(i, i+b_len).equals(B))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_weekcontest_52_1().repeatedStringMatch("a","aaaaa"));
    }
}
