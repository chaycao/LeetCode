import java.util.ArrayList;
import java.util.List;

/**
 * Created by chayc on 2017/10/17.
 */
public class Solution_151 {
    public String reverseWords(String s) {
        char c[] = s.toCharArray();
        reverse(c, 0, c.length-1);
        reverseWord(c);
        return cleanSpace(c);
    }
    public void reverseWord(char[] c) {
        int i = 0, j = 0;
        int len = c.length;
        while (i < len) {
            i = j;
            while (i < len && c[i] == ' ') i++;
            j = i;
            while (j < len && c[j] != ' ') j++;
            reverse(c, i, j-1);
        }
    }
    public String cleanSpace(char[] c) {
        int i = 0, j = 0;
        int len = c.length;
        while (j < len) {
            while (j < len && c[j] == ' ') j++;
            while (j < len && c[j] != ' ') c[i++] = c[j++];
            while (j < len && c[j] == ' ') j++;
            if (j < len) c[i++] = ' ';
        }
        return new String(c).substring(0, i);
    }

    public void reverse(char[] c, int i, int j) {
        char temp;
        while (i < j) {
            temp = c[i];
            c[i] = c[j];
            c[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution_151().reverseWords(" "));
    }
}
