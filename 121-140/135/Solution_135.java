import java.util.*;

/**
 * Created by chayc on 2017/10/3.
 */
public class Solution_135 {
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] candy = new int[len];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < len; i++) {
            map.put(i, ratings[i]);
        }

        // 升序比较器
        Comparator<Map.Entry<Integer, Integer>> valueComparator = new Comparator<Map.Entry<Integer,Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1,
                               Map.Entry<Integer, Integer> o2) {
                return o1.getValue()-o2.getValue();
            }
        };

        // map转换成list进行排序
        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer,Integer>>(map.entrySet());

        // 排序
        Collections.sort(list,valueComparator);

        int x = 0;
        int[] positon = new int[len];
        int[] ratting = new int[len];
        for (Map.Entry<Integer, Integer> entry : list) {
            positon[x] = entry.getKey();
            ratting[x] = entry.getValue();
            x++;
        }

        for (int i = 0; i < len; i++) {
            int pos = positon[i]; // 位置
            int rat = ratting[i];
            // 查找周围是否有已经分配了的
            int least = 1;
            if (pos == len-1)   //没有右边
                ;
            else {
                if (candy[pos+1] != 0 && rat > ratings[pos+1]) {
                    least = candy[pos+1] + 1;
                }
            }
            if (pos == 0)
                ;
            else {
                if (candy[pos-1] != 0 && rat > ratings[pos-1]) {
                    least = Integer.max(least, candy[pos-1]+1);
                }
            }
            candy[pos] = least;
        }
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += candy[i];
            System.out.println(candy[i]);
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] test = {2,2};
        new Solution_135().candy(test);
    }
}
