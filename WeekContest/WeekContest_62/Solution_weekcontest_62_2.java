import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by chaycao on 2017/12/10.
 * chaycao@163.com
 */
public class Solution_weekcontest_62_2 {
    public int networkDelayTime(int[][] times, int N, int K) {
        List[] index = new List[N+1];
        for (int i = 1; i < N+1; i++) {
            index[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < times.length; i++) {
            index[times[i][0]].add(i);
        }
        int[] visited = new int[N+1];
        for (int i = 1; i < N; i++) {
            visited[i] = Integer.MAX_VALUE;
        }
        dfs(times, index, K, visited, 0);
        int max = 0;
        for (int i = 1; i < N+1; i++) {
            max = Math.max(max, visited[i]);
        }
        if (max == Integer.MAX_VALUE)
            return -1;
        return max;

    }

    public void dfs(int[][] times, List[] index, int K, int[] visited, int time) {
        if (time < visited[K]) {
            System.out.println(time);
            visited[K] = time;
        } else {
            return;
        }
        List<Integer> list = index[K];
        System.out.println(K+" "+list.size());
        for (int i = 0; i < list.size(); i++) { //所有边
            int x = list.get(i);
            dfs(times, index, times[x][1], visited, time + times[x][2]);
        }
    }
}
