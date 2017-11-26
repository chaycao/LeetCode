import java.util.HashMap;

/**
 * Created by chaycao on 2017/11/26.
 * chaycao@163.com
 */
public class Solution_weekcontest_60_2 {
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length)
            return false;
        HashMap<String, Integer> map = new HashMap<>();
        int index = 0;
        for (int i = 0; i < pairs.length; i++) {
            if (!map.containsKey(pairs[i][0]))
                map.put(pairs[i][0], index++);
            if (!map.containsKey(pairs[i][1]))
                map.put(pairs[i][1], index++);
        }
        int[][] dic = new int[index][index];
        for (int i = 0; i < pairs.length; i++) {
            int a = map.get(pairs[i][0]);
            int b = map.get(pairs[i][1]);
            dic[a][b] = 1;
            dic[b][a] = 1;
        }

        for (int i = 0; i < words1.length; i++) {
            if (map.containsKey(words1[i]) && map.containsKey(words2[i])) {
                int a = map.get(words1[i]);
                int b = map.get(words2[i]);
                if (dic[a][b] == 0)
                    return false;
            } else if (!words1[i].equals(words2[i]))
                return false;
        }
        return true;
    }
}
