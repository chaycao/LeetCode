/**
 * Created by chaycao on 2017/12/10.
 * chaycao@163.com
 */
public class Solution_weekcontest_62_1 {
    public char nextGreatestLetter(char[] letters, char target) {
        return letters[helper(letters, target, 0, letters.length)];
    }
    public int helper(char[] letters, char target, int left, int right) {
        int mid = (left + right) / 2;
        if (target >= letters[mid] && mid+1 < letters.length && target < letters[mid+1]) {
            return mid+1;
        }
        if (target >= letters[mid]) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
        if (left == letters.length || right == -1) {
            return 0;
        }
        return helper(letters, target, left, right);
    }
}
