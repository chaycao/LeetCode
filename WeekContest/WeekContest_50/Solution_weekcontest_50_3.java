/**
 * Created by chayc on 2017/9/17.
 */
public class Solution_weekcontest_50_3 {
    public boolean checkValidString(String s) {
        return fun(s, 0, 0);
    }
    public boolean fun(String s, int start, int num) {
        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(' :
                    num++;
                    break;
                case ')' :
                    if (num==0)
                        return false;
                    num--;
                    break;
                case '*':
                    boolean temp_3 = fun(s, i+1, num);
                    if (temp_3 == true)
                        return true;
                    num++;
                    boolean temp_1 = fun(s, i+1, num);
                    if (temp_1 == true)
                        return true;
                    num--;
                    boolean temp_2 = false;
                    if (num != 0) {
                        num --;
                        temp_2 = fun(s, i+1, num);
                    }
                    if (temp_2 == true)
                        return true;
                    return false;
            }
        }
        if (num == 0)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_weekcontest_50_3().checkValidString("()"));
    }
}
