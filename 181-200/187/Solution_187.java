import java.util.*;

/**
 * Created by chaycao on 2017/10/28.
 * chaycao@163.com
 */
public class Solution_187 {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        Set<Integer> words = new HashSet<>();
        Set<Integer> doubleWords = new HashSet<>();
        int[] map = new int[26];
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;
        if (s.length() < 10) return res;
        for (int i = 0; i + 9 < s.length(); i++) {
            int v = 0;
            for (int j = i; j < i + 10; j++) {
                v <<= 2;
                v |= map[s.charAt(j) - 'A'];
            }
            if (!words.add(v) && doubleWords.add(v)) {
                res.add(s.substring(i, i+10));
            }
        }
        return res;
    }
}
