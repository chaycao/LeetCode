/**
 * Created by chaycao on 2017/10/29.
 * chaycao@163.com
 */
public class Solution_weekcontest_56_1 {
    public boolean isOneBitCharacter(int[] bits) {
        int len = bits.length;
        return helper(bits, len-2);
    }
    public boolean helper(int[] bits, int index) {
        if (index < 0)
            return true;
        if (bits[index] == 0) {
            if (index-1 < 0)
                return true;
            if (bits[index-1] == 1)
                if (helper(bits, index-2) == true) return true;
            if (helper(bits, index - 1) == true) return true;
        } else {
            if (index-1 >= 0 && bits[index-1] == 1)
                if (helper(bits, index-2) == true) return true;
            else
                return false;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {1,0,0};
        System.out.println(new Solution_weekcontest_56_1().isOneBitCharacter(a));
    }
}
