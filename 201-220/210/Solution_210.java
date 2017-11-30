import java.util.ArrayList;

/**
 * Created by chaycao on 2017/11/30.
 * chaycao@163.com
 */
public class Solution_210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        int[] result = new int[numCourses];
        int[] flag = new int[numCourses]; // 0:白色；1:灰色；2：黑色
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (dfs(i, graph, flag, temp) == false)
                return new int[0];
        }
        if (temp.size() == 0)
            return new int[0];
        for (int i = 0; i < numCourses; i++) {
            result[i] = temp.get(i);
        }
        return result;
    }

    public boolean dfs(int x, ArrayList[] graph, int[] flag, ArrayList<Integer> result) {
        if (flag[x] == 1)
            return false;
        else if (flag[x] == 2) {
            return true;
        }
        flag[x] = 1;
        if (graph[x] != null)  {
            for (int i = 0; i < graph[x].size(); i++) {
                if (!dfs((int)graph[x].get(i), graph, flag, result)) {
                    return false;
                }
            }
        }
        flag[x] = 2;
        System.out.println(x);
        result.add(0, x);
        return true;
    }
}
