import java.util.*;

/**
 * Created by chayc on 2017/9/29.
 */
public class Solution_131 {
    private int len = 0;
    private List<List<String>> result = new ArrayList<>();
    private ArrayList<String> currentList = new ArrayList<>();
    public List<List<String>> partition(String s) {
        len = s.length();
        helper(s, 0);
        return result;
    }
    public void helper(String s, int n) {
        if (n >= len) {
            result.add((ArrayList<String>)currentList.clone());
        }

        for (int i = n; i < s.length(); i++) {
            if (isPalindrome(s, n, i)) {
                currentList.add(s.substring(n, i+1));
                helper(s, i+1);
                currentList.remove(currentList.size()-1);
            }
        }
    }

    public boolean isPalindrome(String s, int i, int j) {
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

}
