/**
 * Created by chaycao on 2017/10/29.
 * chaycao@163.com
 */
public class Solution_weekcontest_56_2 {
    public int compress(char[] chars) {
        int index = 0;
        int result = 0;
        int char_index = 0;
        while (index < chars.length) {
            char c = chars[index];
            int len = helper(chars, index);
            chars[char_index] = c;
            index += len;
            if (len == 1) {
                result += 1;
                char_index++;
            }
            else {
                char_index++;
                String s = Integer.toString(len);
                for (int i = 0; i < s.length(); i++) {
                    chars[char_index++] = s.charAt(i);
                }
                result += s.length() + 1;
            }
        }
        return result;
    }

    public int helper(char[] chars, int index) {
        int count = 1;
        while (index+1 < chars.length && chars[index+1] == chars[index]) {
            count++;
            index += 1;
        }
        return count;
    }

    public static void main(String[] args) {
        char[] c = {'a','b','b','b','b','b','b','b','b','b','b'};
        System.out.println(new Solution_weekcontest_56_2().compress(c));
    }
}
