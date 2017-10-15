import java.util.Stack;

/**
 * Created by chayc on 2017/10/15.
 */
public class Solution_weekcontest_54_2 {
    public int countBinarySubstrings(String s) {
        int result = 0;
        for (int i = 0; i < s.length()-1; i++) {
            if (helper(s, i) == true)
                result++;
        }
        return result;
    }
    public boolean helper(String s, int index) {
        int count = 1;
        char push_flag = '0';
        if (s.charAt(index) == '1')
        {
            push_flag = '1';
        }

        int flag = 0;
        for (int i = index+1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == push_flag)
            {
                if(flag == 1)
                    return false;
                count++;
            }
            else {
                count--;
                flag = 1;
            }
            if (count == 0)
                return true;
            if (count < 0)
                return false;
        }
        return false;
    }
}
