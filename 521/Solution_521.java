import java.util.regex.Pattern;

/**
 * Created by chaycao on 2017/11/6.
 * chaycao@163.com
 */
public class Solution_521 {
    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1:Math.max(a.length(), b.length());
    }
}
