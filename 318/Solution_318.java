/**
 * @author chaycao
 * @description
 * @date 2018-05-28 22:28.
 */
public class Solution_318 {
    public int maxProduct(String[] words) {
        if (words == null || words.length == 0)
            return 0;
        int[] code = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                code[i] |= 1 << (words[i].charAt(j)-'a');
            }
        }
        int max = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i+1; j < words.length; j++) {
                if ((code[i]&code[j]) == 0 && words[i].length()*words[j].length() > max) {
                    max = words[i].length()*words[j].length();
                }
            }
        }
        return max;
    }
}
