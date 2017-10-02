/**
 * Created by chayc on 2017/9/23.
 */
public class Solution_125 {
    public boolean isPalindrome(String s) {
        int len = s.length();
        int first = 0;
        int tail = len-1;
        while (first < tail) {
            while (first < len && !isInRange(s.charAt(first)))
                first++;
            while (tail >= 0 && !isInRange(s.charAt(tail)))
                tail--;
            if (first >= len && tail < 0)
                return true;
            if (valid(s.charAt(first)) != valid(s.charAt(tail))) {
                return false;
            }
            first++;
            tail--;
        }

        return true;
    }
    public boolean isInRange(char c) {
        if ((c <= 'Z'&&c >= 'A') || (c <= 'z'&&c >= 'a') || (c <= '9' && c >= '0'))
            return true;
        return false;
    }
    public char valid(char c) {
        if (c <= 'Z' && c >= 'A')
            c += 32;
        return c;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_125().isPalindrome("0P"));
    }
}
