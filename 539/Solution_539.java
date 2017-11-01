import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by chaycao on 2017/11/1.
 * chaycao@163.com
 */
public class Solution_539 {
    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] s1 = o1.split(":");
                String[] s2 = o2.split(":");
                int a1 = Integer.valueOf(s1[0]);
                int a2 = Integer.valueOf(s2[0]);
                if (a1 != a2) {
                    if (a1 > a2)
                        return 1;
                    return -1;
                }
                int b1 = Integer.valueOf(s1[1]);
                int b2 = Integer.valueOf(s2[1]);
                if (b1 != b2) {
                    if (b1 > b2)
                        return 1;
                    return -1;
                }
                return 0;
            }
        });
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < timePoints.size()-1; i++) {
            int r = helper(timePoints.get(i), timePoints.get(i+1));
            if (r < min) {
                min = r;
            }
        }
        int temp = 0;
        temp += helper(timePoints.get(timePoints.size()-1), "24:00");
        temp += helper("00:00", timePoints.get(0));
        if (temp < min) {
            min = temp;
        }
        return min;
    }

    public int helper(String o1, String o2) {
        String[] s1 = o1.split(":");
        String[] s2 = o2.split(":");
        int a1 = Integer.valueOf(s1[0]);
        int a2 = Integer.valueOf(s2[0]);
        int b1 = Integer.valueOf(s1[1]);
        int b2 = Integer.valueOf(s2[1]);
        int result = 0;
        result += (a2 - a1) * 60;
        result += b2 - b1;
        return result;
    }
}
