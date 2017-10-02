/**
 * Created by chayc on 2017/9/17.
 */
public class Solution_weekcontest_50_1 {
    public boolean validPalindrome(String s) {
        int len = s.length();
        if (fun(s, 0, len-1, 0) < 2)
            return true;
        else
            return false;
    }

    public int fun(String s, int left, int right, int flag) {
//        System.out.println(left + " " + right);
        while (left < right && flag < 2) {
            char a = s.charAt(left);
            char b = s.charAt(right);
            if (a == b) {
                left++;
                right--;
            }
            else {
                return flag += Math.min(fun(s, left + 1, right, flag+1),fun(s, left, right - 1,  flag+1));
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_weekcontest_50_1().validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
//        System.out.println(new Solution_weekcontest_50_1().validPalindrome("abca"));
    }
}
