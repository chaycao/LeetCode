import javafx.util.Pair;

import java.util.*;

/**
 * Created by chayc on 2017/10/1.
 */
public class Solution_weekcontest_52_3 {
    public double knightProbability(int N, int K, int r, int c) {
        if(K==0)
            return 1;
        double all = Math.pow(8, K);
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(r, c));
        queue.offer(null);
        double count = 0;
        int index = 0;
        List<Pair<Integer, Integer>> list = new ArrayList<>();
        while (queue.size() != 0) {
            Pair<Integer, Integer> pair = queue.poll();
            if (pair == null)
            {
                index++;
                if(index > K)
                    break;
                if (queue.peek() == null)
                {
                    return count/all;
                }
                count = 0;
                queue.offer(null);
                continue;
            }
            int x = pair.getKey();
            int y = pair.getValue();
            if (x >= 0 && x < N && y >= 0 && y < N) {
                count += 1;
            } else {
                continue;
            }
            int a = x+1, b = y+2;
            if (a >= 0 && a < N && b >= 0 && b < N)
            {
                queue.offer(new Pair<>(x+1, y+2));
                count++;
            }
            a = x+2; b = y+1;
            if (a >= 0 && a < N && b >= 0 && b < N)
                queue.offer(new Pair<>(x+2, y+1));
            a = x+1; b = y+2;
            if (a >= 0 && a < N && b >= 0 && b < N)
                queue.offer(new Pair<>(x-1, y-2));
            queue.offer(new Pair<>(x-2, y-1));
            queue.offer(new Pair<>(x-1, y+2));
            queue.offer(new Pair<>(x-2, y+1));
            queue.offer(new Pair<>(x+1, y-2));
            queue.offer(new Pair<>(x+2, y-1));
        }
        return count/all;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_weekcontest_52_3().knightProbability(3,3,0,0));;
    }
}
