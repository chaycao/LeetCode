/**
 * Created by chaycao on 2017/10/30.
 * chaycao@163.com
 */
public class Solution_647 {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isPalindromic(s, i, j))
                    count++;
            }
        }
        return count;
    }

    public boolean isPalindromic(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low) != s.charAt(high))
                return false;
            low++;
            high--;
        }
        return true;
    }
}
